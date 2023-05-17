package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2042_구간합구하기3_2 {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int treeHeight = 0;
        int length = N;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }
        int treeSize = (int) Math.pow(2, treeHeight +1);
        int NodeStartIndex = treeSize / 2 - 1; //리프노드 시작 인덱스
        tree = new long[treeSize + 1];
        for(int i = NodeStartIndex + 1; i <= NodeStartIndex + N; i++) { //리프노드에 데이터 입력
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize - 1);  //초기 트리 만들기
        for (int i = 0; i < M + K; i++){
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            if (a == 1){
                changeVal(NodeStartIndex + s, e);
            } else if (a == 2) {
                s = s + NodeStartIndex;
                e = e + NodeStartIndex;
                System.out.println(getSum(s, (int) e));
            } else {
                return;
            }
        }
        br.close();
    }
    private static long getSum(int s, int e) {  //구간 합 구하는 함수
        long partSum = 0;
        while (s <= e) {
            if (s % 2 == 1) {
                partSum = partSum + tree[s];
                s++;
            }
            if (e % 2 == 0){
                partSum = partSum + tree[e];
                e--;
            }
            s = s / 2;
            e = e / 2;
        }
        return partSum;
    }
    private static void changeVal(int index, long val){ //값 변경 함수
        long diff = val - tree[index];
        while (index > 0){
            tree[index] = tree[index] + diff;
            index = index / 2;
        }
    }
    private static void setTree(int i) { //초기 트리 만드는 함수
        while (i != 1){
            tree[i / 2] += tree[i];
            i--;
        }
    }
}
