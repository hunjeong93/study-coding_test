package datastructure;

import java.util.Scanner;

public class P11660_구간합구하기2_1 {
    //N x N 배열.
    // N,  질의 갯수 Q
    // 배열 입력. 1 2 3 4 (N번 반복)
    //질의 -> 출력

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();

        int[][] arr = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int D[][] = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                D[i][j] = D[i][j -1] + D[i -1][j] - D[i - 1][j - 1] + arr[i][j];
            }
        }

        while (Q > 0) {
            int answer = 0;
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            answer = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];
            System.out.println(answer);
            Q--;
        }
    }
}
