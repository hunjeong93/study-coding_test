package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11659_구간합1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer =
                new StringTokenizer(bufferedReader.readLine()); //버퍼리더 개행을 포함하여 저장해둠 , 여기서 입력 받음

        int suNo = Integer.parseInt(stringTokenizer.nextToken()); //저장해둔걸 토큰별로 찢어 저장
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());

        long[] S = new long[suNo + 1]; //인덱스를 1 부터 시작해서 계산이 편리하기 위함
        stringTokenizer = new StringTokenizer(bufferedReader.readLine()); // 대상 배열 입력 받음
        for (int i = 1; i <= suNo; i++) {
            S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken()); // 입력 받은걸 바로 합 배열로 저장, 입력받은 토큰 값 + 앞에 값
        }
        for (int q = 0; q < quizNo; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());// 구간 입력 받음
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i - 1]); // 구간 합 출력
        }
    }
}
