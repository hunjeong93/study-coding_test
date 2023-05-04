package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753_최단경로2 {
    public static int V,E,K;
    public static int distance[];
    public static boolean visited[];
    public static ArrayList<Edge2> list[];
    public static PriorityQueue<Edge2> q = new PriorityQueue<Edge2>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        distance = new int[V + 1];
        visited = new boolean[V + 1];
        list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Edge2>();
        }
        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < E; i++) { //가중치가 있는 인접 리스트 초기화하기
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge2(v, w));
        }
        q.add(new Edge2(K, 0)); //K를 시작점으로 설정하기
        distance[K] = 0;
        while (!q.isEmpty()) {
            Edge2 current = q.poll();
            int c_v = current.vertex;
            if (visited[c_v]) continue; //이미 방문한 적이 있는 노드는 다시 큐에 넣지 않음
            visited[c_v] = true;
            for (int i =0; i < list[c_v].size(); i++) {
                Edge2 tmp = list[c_v].get(i);
                int next = tmp.vertex;
                int value = tmp.value;
                if (distance[next] > distance[c_v] + value) { //최소 거리로 업데이트하기
                    distance[next] = value + distance[c_v];
                    q.add(new Edge2(next, distance[next]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (visited[i])
                System.out.println(distance[i]);
            else
                System.out.println("INF");
        }
    }
}
//가중치가 있는 그래프를 담는 클래스
class Edge2 implements Comparable<Edge2> {
 int vertex, value;
 Edge2(int vertex, int value) {
     this.vertex = vertex;
     this.value = value;
 }
 public int compareTo(Edge2 e) {
     if (this.value > e.value) return 1;
     else return -1;
 }
}
