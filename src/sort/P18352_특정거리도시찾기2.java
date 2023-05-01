package sort;

import java.util.*;

public class P18352_특정거리도시찾기2 {
    static int visited[];
    static ArrayList<Integer>[] A;
    static int N,M,K,X;
    static List<Integer> answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //노드의 수
        M = sc.nextInt(); //에지의 수
        K = sc.nextInt(); //목표 거리
        X = sc.nextInt(); //시작점
        A = new ArrayList[N + 1];
        answer = new ArrayList<>();
        for (int i = 1; i <= N; i++){
            A[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
        }
        visited = new int[N + 1]; //방문 배열 초기화
        for(int i = 0; i <= N; i++) {
            visited[i] = -1;
        }
        BFS(X);
        for(int i = 0; i <= N; i++) {
            if(visited[i] == K) {
                answer.add(i);
            }
        }
        if(answer.isEmpty()) {
            System.out.println("-1");
        }
        else {
            Collections.sort(answer);
            for(int temp:answer) {
                System.out.println(temp);
            }
        }
    }
    private static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        visited[Node]++;
        while (!queue.isEmpty()) {
            int now_Node = queue.poll();
            for (int i : A[now_Node]){
                if (visited[i] == -1) {
                    visited[i] = visited[now_Node] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
