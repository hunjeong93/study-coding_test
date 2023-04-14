package datastructure;

import org.w3c.dom.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P11003_최솟값찾기1 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());

        Deque<Node> mydeque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!mydeque.isEmpty() && mydeque.getLast().value > now) {//덱이 비어있지 않고, 덱의 마지막 값이 들어오는 값보다 크면 제거 왜 while ->
                // 들어온 값이 앞에 있는 값보다 작은 경우가 연속될 수 있음. 제거 제거,
                mydeque.removeLast();
            }

            mydeque.addLast(new Node(now, i));

            if (mydeque.getFirst().index <= i - L) {
                mydeque.removeFirst(); // 범위 넘어가면 앞에서 제거
            }
            bw.write(mydeque.getFirst().value + " "); // for문 순환마다 가장 앞에 있는 값 출력 준비 (bufferedWriter에 담아놓음)
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
