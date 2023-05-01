package sort;

import java.sql.SQLData;
import java.util.*;

public class P18352_특정거리도시찾기1 {
    static int visited[];
    static ArrayList<Integer>[] A;
    static int N,M,K,X;
    static List<Integer> answer;
    public static void main(String[] args) {
        //거리 정보 > 얼마나 떨어진 도시를 알아볼건지
        //도시 개수 받고, 도로 개수 받고, 거리 정보 받고, 출발 도시 번호 받음.
        // 가중치가 없는 인접리스트 > N^2, 시간제한 2초라 가능?????????. 90,000,000,000
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //도시 개수
        M = sc.nextInt(); // 도로 개수
        K = sc.nextInt(); // 목표 거리
        X = sc.nextInt(); // 출발 도시
        A = new ArrayList[N + 1];
        answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
        }
        visited = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            visited[i] = -1;
        }
        BFS(X);
        for (int i = 0; i <= N; i++) {
            if (visited[i] == K) {
                answer.add(i);
            }
        }
        if (answer.isEmpty()) {
            System.out.println("-1");
        }
        else {
            Collections.sort(answer);
            for (int temp : answer) {
                System.out.println(temp);
            }
        }
    }

    //BFS 구현
    private static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        visited[Node]++;
        while (!queue.isEmpty()) {
            int now_Node = queue.poll();
            for (int i : A[now_Node]) {
                if (visited[i] == -1) {
                    visited[i] = visited[now_Node] +1;
                    queue.add(i);
                }
            }
        }
    }
}
