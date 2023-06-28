package sort;

import java.io.*;

public class P10989_수정렬하기3_1 { //기수정렬 시간복잡도 O(kn) , 일반적으로 우선순위 큐를 사용하면 비교적 간단하게 구현 가능, -> 시간 복잡도를 느리게 하는 요소가 있음.
    public static int[] A;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Radix_Sort(A, 5); // 10,000 보다 작은 수가 주어지기때문에 5자릿수까지 반복
        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void Radix_Sort(int[] A, int max_size) {
        int[] output = new int[A.length];
        int jarisu = 1;
        int count = 0;
        while (count != max_size) { //최대 자릿수만큼 반복
            int[] bucket = new int[10];
            for (int i = 0; i < A.length; i++) {
                bucket[(A[i] / jarisu) % 10]++; //1의 자릿수 부터.
            }
            for (int i = 1; i < 10; i++) { // 합의 배열을 이용해 index 계산하기
                bucket[i] += bucket[i - 1];
            }
            for (int i = A.length - 1; i >= 0; i--) { //현재 자릿수를 기준으로 정렬하기
                output[bucket[(A[i] / jarisu % 10)] - 1] = A[i];
                bucket[(A[i] / jarisu % 10)]--;
            }
            for (int i = 0; i < A.length; i++) {
                // 다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장하기
                A[i] = output[i];
            }
            jarisu = jarisu * 10; //자릿수 증가시키기
            count++;
        }
    }
}
