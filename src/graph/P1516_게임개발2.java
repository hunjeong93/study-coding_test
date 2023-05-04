package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1516_게임개발2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }
        int[] indegree = new int[N + 1]; //진입 차수 배열
        int[] selfBuild = new int[N + 1]; //자기 건물 짓는 데 걸리는 시간
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken()); //건물 짓는 데 걸리는 시간
            while (true) {  //인접 리스트 초기화. 입력된 값에다 i번째를 추가.
                int preTemp = Integer.parseInt(st.nextToken());
                if (preTemp == -1)
                    break;
                A.get(preTemp).add(i);
                indegree[i]++;
            }
        }
        //위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] result = new int[N + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : A.get(now)) {
                indegree[next]--;
                //시간 업데이트하기
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.println(result[i] + selfBuild[i]);
        }
    }
}
