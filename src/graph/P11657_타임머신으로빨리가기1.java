package graph;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11657_타임머신으로빨리가기1 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static long distance[];
    static Edge edges[];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M + 1];
        distance = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE); // 최단 거리 배열  초기화 하기
        for (int i = 0; i < M; i++) { // 에지 리스트 데이터 저장하기
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, time);
        }
        //벨만-포드 알고리즘 수행하기
        distance[1] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                //더 작은 최단 거리가 있을 때 업데이트하기
                if (distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }
        boolean mCycle = false;
        for (int i = 0; i < M; i++) { // 음수 사이클 확인하기
            Edge edge = edges[i];
            if (distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.time) {
                mCycle = true;
            }
        }
        if (!mCycle) {
            for (int i = 2; i < N + 1; i++) {
                if (distance[i] == Integer.MAX_VALUE) System.out.println("-1");
                else System.out.println(distance[i]);
            }
        } else {
            System.out.println("-1");
        }
    }
}
    class Edge {
        int start, end, time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

