package tree;

import java.util.ArrayList;
import java.util.Scanner;

public class P11752_트리의부모찾기2 {
    static int N;
    static boolean[] visited;
    static ArrayList<Integer> tree[];
    static int result[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N + 1];
        tree = new ArrayList[N + 1];
        result = new int[N + 1];
        for(int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) { //노드 두개 인접리스트에 저장
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            tree[n1].add(n2);
            tree[n2].add(n1);
        }
        DFS(1); //루트노드를 1이라 했으므로 1부터 시작
        for (int i = 2; i <= N; i++) {
            System.out.println(result[i]);
        }
    }
    static void DFS(int number) {
        visited[number] = true;
        for (int i : tree[number]) {
            if (!visited[i]) { //방문한적 없는 노드일경우 결과 배열에 부모노드 저장. DFS다시호출.
                result[i] = number;
                DFS(i);
            }
        }
    }
}
