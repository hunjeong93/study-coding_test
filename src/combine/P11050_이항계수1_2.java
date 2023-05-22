package combine;

import java.util.Scanner;

public class P11050_이항계수1_2 {
    static int N, K;
    static int[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        D = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++){
            D[i][1] = i;  //i 개에서 1개 선택
            D[i][0] = 1;  //i개에서 하나도 선택하지 않음
            D[i][i] = 1;  //i개에서 모두 선택
        }
        for (int i = 2; i <= N; i++){
            for(int j = 1; j < i; j++) {
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1]; //점화식
            }
        }
        System.out.println(D[N][K]);
    }
}
