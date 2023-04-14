package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class P1874_스택오름차순1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1;
        boolean result = true;
        for (int i = 0; i < A.length; i++) {
            int su = A[i];
            if (su >= num) { // pop 할 숫자가 나올때 까지 정수를 push
                while (su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else { // pop할 숫자보다 높아서 먼저 pop 으로 빼줘야함.
                int n = stack.pop();
                if (n > su) { // 꺼낸 수가 꺼내야하는 수보다 크면 NO 출력
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else {
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf.toString());
    }
}
