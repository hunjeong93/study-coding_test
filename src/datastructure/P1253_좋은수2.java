package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253_좋은수2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //수의 개수 N
        int N = Integer.parseInt(bufferedReader.readLine());
        int Result = 0;
        //배열에 데이터 저장 & 정렬
        long A[] = new long[N];
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);
        //i번째에 있는 값에 대해 j와 k번째의 데이터의 합으로 나타 낼 수 있는가? j와k는 투 포인터
        for(int i = 0; i < N; i++) {
            long find = A[i];
            int j = 0;
            int k = N -1;

            while (j < k) {
                if(A[j] + A[k] == find) {
                    //find는 서로 다른 두 수의 합이어야 한다
                    if (j != i && k != i) {
                        Result++;
                        break;
                    } else if (j == i) {
                        j++;
                    } else if (k == i) {
                        k--;
                    }
                } else if (A[j] + A[k] < find) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        System.out.println(Result);
        bufferedReader.close();

    }
}
