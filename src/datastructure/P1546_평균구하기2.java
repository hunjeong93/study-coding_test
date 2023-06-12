package datastructure;

import java.util.Scanner;
import java.util.*;

public class P1546_평균구하기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        float sum = 0;
        for(int i = 0; i < N; i++) {
            sum += arr[i];
        }
        float avg = sum/arr[N-1] * 100/N;
        System.out.println(avg);
    }

}
