package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920_원하는정수찾기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //데이터 개수 N, 찾아야 할 숫자 개수 M
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        //배열 정렬
        Arrays.sort(A);
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int front = 0;
            int back = A.length - 1;
            boolean result = false;
            while (front <= back) {
                int mIndex = (front + back) / 2;
                int mValue = A[mIndex];
                if(mValue > target) {
                    back = mIndex - 1;
                }
                else if (mValue < target) {
                    front = mIndex + 1;
                }
                else {
                    result = true;
                    break;
                }
            }
            if(result) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }
}
