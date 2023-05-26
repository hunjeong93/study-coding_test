package combine;

import java.util.Scanner;

public class P1256_사전찾기1 {
    //a 와 z 로만 이루어진사전.
    // a 와 z 의 개수가 N,M 일 때 이 문자들로 만들 수 있는 모든 경우의 수는 N + M 개에서 N 개를 뽑는 경우의 수 또는 M 개를 뽄느 경우의 수와 동일하다
    static int N, M, K;
    static int[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        D = new int[202][202];
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    D[i][j] = 1;
                } else {
                    D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
                    if (D[i][j] > 1000000000) D[i][j] = 1000000001; // K 범위가 넘어가면 범위의 최댓값 저장하기
                }
            }
        }
        if (D[N + M][M] < K) {
            // 주어진 자릿수로 만들 수 없는 K 번째 수이면
            System.out.println("-1");
        }else {
            while (!(N == 0 && M == 0)) {
                // a를 선택했을 때 남은 문자로 만들 수 있는 모든 경우의 수가 K 보다 크면
                if (D[N - 1 + M][M] >= K) {
                    System.out.print("a");
                    N--;
                } else {
                    System.out.print("z");
                    K = K - D[N - 1 + M][M]; // K 값 업데이트
                    M--;
                }
            }
        }
    }
}
