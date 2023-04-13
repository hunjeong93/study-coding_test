package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11659_구간합2 {
    public static void main(String[] args) throws IOException {
        //Scanner로 입력 받아서 처리하기는 불가능...?
//        Scanner sc = new Scanner(System.in);
//        //데이터의 개수 N 받기
//        int N = sc.nextInt();
//        //합을 구해야 하는 횟수 SN 받기
//        int SN = sc.nextInt();
//        //N개의 수(구간 합을 구할 대상 배열)
//        int A[] = new int[N];
//        for(int i = 0; i < N; i++){
//            A[i] = sc.nextInt();
//        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        //데이터의 갯수 DN, 질의갯수 QN
        int DN = Integer.parseInt(stringTokenizer.nextToken());
        int QN = Integer.parseInt(stringTokenizer.nextToken());
        //배열의 합 구하기
        long[] S = new long[DN + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= DN; i++) {
            S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int i = 0; i < QN; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[k] - S[j - 1]);
        }

    }

}
