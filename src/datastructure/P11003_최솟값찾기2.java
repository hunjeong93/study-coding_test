package datastructure;

import org.w3c.dom.Node;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P11003_최솟값찾기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //출력을 버퍼에 넣고 한번에 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Deque<Node> deque = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            //새로운 값보다 큰 값이 덱에 있을때, 덱에서 해당 값 제거
            while (!deque.isEmpty() && (deque.getLast().value > now)) {
                deque.removeLast();
            }
            deque.addLast(new Node(now, i));
            //인덱스 범위에서 벗어나면 first값 제거
            if(deque.getFirst().index <= i - L) {
                deque.removeFirst();
            }
            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();

    }
    static class Node {
        public int value;
        public int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
