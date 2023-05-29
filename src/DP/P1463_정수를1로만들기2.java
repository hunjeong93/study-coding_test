package DP;

import java.util.Scanner;

public class P1463_정수를1로만들기2 {
    static int N;
    static int D[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D = new int[N + 1];
        D[0] = 0;
        D[1] = 0;
        for(int i = 2; i <= N; i++) {
            //N보다 1작은 수에서 -1연산을 할 때. 1작은수의 횟수에서 1을 더한다
            D[i] = D[i - 1] + 1;
            //N이 2로 나누어 질때, 2로 나눈 수의 횟수에서 1을 더하고 -1 연산 한 횟수와 비교하여 더 작은 수를 저장
            if(i % 2 == 0) {
                D[i] = Math.min(D[i], D[i / 2] + 1);
            }
            //N이 3으로 나누어 질때, 3으로 나눈 수의 횟수에서 1을 더하고 앞에서 구한 D[i]와 비교하여 더 작은 수를 저장
            if(i % 3 == 0) {
                D[i] = Math.min(D[i], D[i / 3] + 1);
            }
        }
        System.out.println(D[N]);
    }
}
