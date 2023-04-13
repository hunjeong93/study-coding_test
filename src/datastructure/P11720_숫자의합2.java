package datastructure;

import java.util.Scanner;

//만약 갯수는 N인데 주어진 숫자의 수가 N보다 많거나 적다면?
//for문에서 i의 범위를 N으로 하는가 chNumbers.length 로 하는가 stNumbers.length()로 하는가 차이?

public class P11720_숫자의합2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //갯수 N 받기
        int N = sc.nextInt();
        //N개의 숫자 String 으로 받기
        String stNumbers = sc.next();
        //받은 숫자 String char로 변환
        char[] chNumbers = stNumbers.toCharArray();
        int sum = 0;
        //char에 담긴 숫자 합 구하기. char을 숫자로 변환 하는법 : char - '0'. ascii code 48
        for(int i = 0; i < N; i++) {
            sum += chNumbers[i] - '0';
        }
        System.out.println(sum);

    }


}
