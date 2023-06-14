package datastructure;

import java.util.HashMap;
import java.util.Scanner;

public class P10986_나머지합구하기1 {
    // 구간합 만들고. M으로 나누어 떨어지는 구간이 몇개인가
    //( A + B ) % C  = ((A % C) + (B % C)) % C
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Long[] S = new Long[N];
        S[0] = (long) A[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i-1] + A[i];
        }
        int[] D = new int[N];
        for (int i = 0; i < N; i++) {
            D[i] =  S[i].intValue() % M;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(D[i], map.getOrDefault(D[i], 0) + 1);
        }
        int answer = 0;
        answer += map.get(0);
        for (int key :  map.keySet()) {
            if (map.get(key)>0) {
                answer += map.get(key) * ( map.get(key) -1 ) / 2;
            }

        }
        System.out.println(answer);
    }
}
