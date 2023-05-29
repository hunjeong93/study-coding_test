package DP;

import java.util.Scanner;

public class P1463_정수를1로만들기1 {
    // X가 3으로 나누어떨어지면 3으로 나눈다.
    // X 가 2 로 나누어 떨어지면 2로 나눈다.
    // 1을 뺀다.

    // 정수 n 이 주어졌을 때 위와 같은 연산 3개를 적절히 사용해 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 구하라.
    // 106보다 작거나 같은 정수 N

    // 재귀함수? if 3으로나누어 떨어지는 값이면 나눠서 그 값을 다시.
    // if else 2로 나누어떨어지면 2로 ㅏㄴ누고.
    // if else 2가 되면 -1 을 뺀다.
    // count 전역변수 선언.
    static int count;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        count = 0;

        makeOne(N);
        System.out.println(count);
    }
    static void makeOne(int n){
        if(n > 3 && n % 3 == 0){
            n /= 3;
            count++;
            makeOne(n);
        } else if (n > 2 && n % 2 == 0) {
            n /= 2;
            count++;
            makeOne(n);
        } else if (n >= 2) {
            n--;
            count++;
            makeOne(n);
        }

    }
}
