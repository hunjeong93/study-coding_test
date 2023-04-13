package datastructure;

import java.util.Scanner;

public class P11720_숫자의합1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String nums = sc.next();

        char[] ch = new char[N];
        for (int i = 0; i < N; i++) { // -> ch = nums.toCharArray(); 로 한방에 가능
            ch[i] = nums.charAt(i);
//            System.out.println(ch[i]);
        }
        int sum = 0;
        for (int j = 0; j < N; j++) {
            sum += ch[j] - '0'; // 정수형으로 변환하면서 sum에 더하여 누적
        }
        System.out.println(sum);
    }
}
