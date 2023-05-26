package combine;

import java.util.Scanner;

public class P1256_사전찾기2 {
    static int N, M;
    static double K;
    static double[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        D = new double[202][202];
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    D[i][j] = 1;
                } else {
                    D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
                    if (D[i][j] > 1000000000) D[i][j] = 1900000001; //K 범위보다 큰값 넣기
                }
            }
        }
        if (D[N + M][M] < K) {
            System.out.println("-1");
        } else {
            while (!(N == 0 && M == 0)) {
                //a를 선택했을 때 남은 문자로 만들 수 있는 모든 경우의 수가 K 보다 크면
                if (D[N - 1 + M][M] >= K) {
                    System.out.print("a");
                    N--;
                } else { //모든 경우의 수가 K보다 작으면
                    System.out.print("z");
                    K = K - D[N - 1 + M][M];
                    M--;
                }
            }
        }
    }
}
