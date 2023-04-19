package numbertheory;

import java.util.Scanner;

public class P1929_소수구하기1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();//start
        int E = sc.nextInt();//end
        int[] arr = new int[E + 1];
        for (int i = 0; i < E + 1; i++) {
            arr[i] = i;
        }
        arr[1] = 0;
        for (int i = 2; i < Math.sqrt(E) + 1; i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + i; j < E + 1; j = j + i) {// 2인경우 4부터. 마지막값까지. j 만큼 상승
                arr[j] = 0;
            }
        }
        for (int i = S; i < E + 1; i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }
}
