package search;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P1920_원하는정수찾기1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int M = sc.nextInt();
        int[] targets = new int[M];
        for (int i = 0; i < M; i++) {
            targets[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            int start = 0;
            int end = arr.length -1;
            boolean find =false;
            while (start <= end) {
                int mid = (start + end) / 2;

                if (arr[mid] > targets[i]) {
                    end = mid - 1;
                } else if (arr[mid] < targets[i]) {
                    start = mid + 1;
                } else {
                    find = true;
                    break;
                }
            }
            if (find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }
}
