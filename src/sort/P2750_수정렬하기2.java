package sort;

import java.util.Scanner;

public class P2750_수정렬하기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        //배열A에 입력값 넣기
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        //앞에서부터 하나씩 비교 후 큰 수를 뒤쪽으로
        //i의 범위가 N이 아닌 N-1인 이유 : 마지막 인덱스는 비교 대상이 없기 떄문.
        //안쪽 for문을 반복 할때 마다 마지막 인덱스에는 최고값이 들어가 있다.
        //따라서 i = 1일때는 루프를 한바퀴 돈 상태, 마지막 인덱스와 비교할 필요 x. 그러므로 최대 인덱스에서 i를 빼준다.
        //이걸 반복
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < N - 1 - i; j++){
                if(A[j] > A[j + 1]){
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        for(int i = 0; i < N; i++){
            System.out.println(A[i]);
        }
    }
}
