package sort;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class P1517_버블소트프로그램2_1 { //N의 최대 범위가 크기 때문에 병합정렬을 이용해 시간복잡도(nlogn)를 이용한다.
    public static int[] A , tmp;
    public static long result;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new int[N + 1];
        tmp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }
        result = 0;
        merget_sort(1, N);
        System.out.println(result);
    }

    private static void merget_sort(int s, int e) {
        if (e - s < 1 )
            return;
        int m = s + (e -s ) / 2;
        merget_sort(s,m);
        merget_sort(m + 1, e);
        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }
        int k = s;
        int index1 = s;
        int index2 = m + 1;
        while (index1 <= m && index2 <= e) {
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                result = result + index2 - k; //뒤쪽 데이터가 값이 작은 경우 result 업데이트
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
