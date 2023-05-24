package combine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1722_순열의순서1 {
    static int N;
    static int Q;
    static long F[]  = new long[21]; // N 은 1~20 , 0 번 인덱스 제외 / 각 자리별로 만들 수 있는 경우의 수 저장 -> 팩토리얼 형태
    static boolean visited[] = new boolean[21];  // 중복체크
    static int S[] = new int[21];
    static BufferedReader bf;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        Q = Integer.parseInt(st.nextToken());
        createFactorial();
        if(Q == 1){
            long K = Long.parseLong(st.nextToken());
            findNth(K);
        }else if(Q == 2){
            findPermutation();
        }else {
            System.out.println("소문제 지정 : K 는 1 또는 2 입니다.");
        }
    }

    private static void createFactorial() {
        F[0] = 1;
        for(int i = 1; i < N +1; i++){
            F[i] = F[i -1] * i; //팩토리얼 초기화
        }
    }

    static void findNth(long K) { // q 가 1 일때 -> k 번째 순열 출력
        for(int i = 1; i < N + 1; i ++){
            for (int j = 1, cnt = 1; j < N + 1; j++) {
                if (visited[j]) {
                    continue;
                }
                if (K <= cnt * F[N - i]) { // 주어진 K에 따라 각 자리에 들어갈 수 있는 수 찾기
                    K -= ((cnt - 1) * F[N - i]);
                    S[i] = j;
                    visited[j] = true;
                    break;
                }
                cnt++;
            }
        }
        for (int i = 1; i < N + 1; i++) {
            System.out.print(S[i] + " ");
        }
    }
    static void findPermutation() { // q 가 2 일 때 -> 입력 받은 순열이 몇번째 순열인지 출력
        long K = 1;
        for (int i = 1; i < N + 1; i++) {
            S[i] = Integer.parseInt(st.nextToken());
            long cnt = 0;
            for (int j = 1; j < S[i]; j++) {
                if (visited[j] == false) {
                    cnt++; //미사용 숫자 개수만큼 카운트
                }
            }
            K += cnt * F[N - i]; // 자릿수에 따라 순서 더하기
            visited[S[i]] = true;
        }
        System.out.println(K);
    }
}
