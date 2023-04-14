package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1874_스택오름차순2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1; //오름차순 시작 수
        boolean result = true;
        for(int i = 0; i < A.length; i++) {
            int su = A[i];              //현재 입력된 수
            if(su >= num) {             //입력된 수 >= 오름 차순 자연수 : 값이 같아질 때까지 push
                while (su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            else {                      //입력된 수 < 오름차순 자연수 : pop을 수행하여 스택에서 값을 꺼냄
                int n = stack.pop();
                //스택의 가장 위의 수가 입력된 수 보다 크면 수열 출력 불가
                if(n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else {
                    bf.append("-\n");
                }

            }
        }
        if(result) System.out.println(bf.toString());
    }
}
