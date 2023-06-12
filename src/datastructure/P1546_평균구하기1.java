package datastructure;

import java.util.Scanner;

public class P1546_평균구하기1 {
    // 최댓값 M , 각 점수 나누기 M * 100

    // 시험 본 과목 개수 N , 시험성적 40 80 60 (ex)
    // 새로운 평균 출력

    //N 크기 배열 생성. 최대값 찾기.
    // for문 N만큼 반복. 새로운 배열에 공식을 통해 입력.  ---> (A + B + C) / max * 100 / N 으로 계산
    // 평균 도출

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] real = new int[N];

        for (int i = 0; i < N; i++) {
            real[i] = sc.nextInt();
        }

        float max = 0;
        float sum = 0;
        for ( int i = 0; i < N; i++){
            if( max < real[i]) max = real[i];
            sum += real[i];
        }

        System.out.println(sum * 100 / max / N);

    }
}
