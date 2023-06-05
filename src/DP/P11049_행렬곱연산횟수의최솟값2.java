package DP;

import java.util.Scanner;

public class P11049_행렬곱연산횟수의최솟값2 {
    static int N;
    static Matrix2[] M;
    static int[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = new Matrix2[N + 1];
        D = new int[N + 1][N + 1];
        for (int i = 0; i < D.length; i++) {
            for (int j = 0; j < D[i].length; j++) {
                D[i][j] = -1;
            }
        }
        for (int i = 1; i <= N; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            M[i] = new Matrix2(y, x);
        }
        System.out.println(exute(1, N));
    }
    static int exute(int s, int e) {
        int result = Integer.MAX_VALUE;
        if (D[s][e] != -1) return D[s][e];
        if (s == e) return 0;
        if (s + 1 == e) return M[s].y * M[s].x * M[e].x;
        for (int i = s; i < e; i++) {
            result = Math.min(result, M[s].y * M[i].x * M[e].x + exute(s, i) + exute(i + 1, e));
        }
        return D[s][e] = result;
    }
    static class Matrix2 {
        private int y;
        private int x;

        public Matrix2(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
