package combine;

import java.util.Scanner;

public class P11050_이항계수1 {
    static int N;
    static int K;
    static int[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        D = new int[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            D[i][0] = 1;
            D[i][1] = i;
            D[i][i] = 1;
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 1; j < i; j++) {
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1]; // 조합 기본 점화식
            }
        }
        System.out.println(D[N][K]);
    }
}
