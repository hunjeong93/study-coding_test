package numbertheory;

import java.util.Scanner;

public class P1929_소수구하기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //처음 시작 숫자N, 마지막 숫자M
        int N = sc.nextInt();
        int M = sc.nextInt();
//        int[] arr = new int[M - N];
//        arr[0] = N;
//        //배열 만들기
//        for(int i = 1; i < arr.length; i++) {
//            arr[i] = arr[i - 1] + 1;
//        }
//        //소수 찾기
//        for(int i = 0; i <= Math.sqrt(N); i++) {
//            if (arr[i] == 0){
//                continue;
//            }
//            //배수 없애기
//            for(int j =0; j <= N; j++) {
//                double temp = Math.pow(arr[i], j);
//
//            }
//        }
        int[] A = new int[M + 1];
        for (int i = 2; i <= M; i++) {
            A[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(M); i++) {
            if (A[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= M; j = j + i) {
                A[j] = 0;
            }
        }
        for(int i = N; i <= M; i++) {
            if (A[i] != 0) {
                System.out.println(A[i]);
            }
        }
    }
}
