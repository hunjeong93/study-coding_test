package tree;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class P11752_트리의부모찾기 {
    static int N;
    static boolean[] visited;
    static ArrayList<Integer> tree[];
    static int answer[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //노드개수
        visited = new boolean[N + 1]; // 방문리스트
        tree = new ArrayList[N + 1]; // 인접리스트 생성
        answer = new int[N + 1]; //부모노드 배열

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) { //인접리스트 노드끼리 양방향 연결
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            tree[n1].add(n2);
            tree[n2].add(n1);
        }
        DFS(1); // 부모 노드부터 DFS 시작
        for (int i = 2; i < N + 1; i++) {
            System.out.println(answer[i]);
        }
    }


    static void DFS(int number) {
        visited[number] = true; //방문 기록
        for (int i : tree[number]) {
            if (!visited[i]) { //방문안했던 노드면 정답 배열에 저장 : 부모 노드
                answer[i] = number;
                DFS(i);
            }
        }
    }
}
