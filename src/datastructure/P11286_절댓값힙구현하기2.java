package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P11286_절댓값힙구현하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            int first_abs = Math.abs(a);
            int second_abs = Math.abs(b);
            if (first_abs == second_abs){
                return a > b ? 1: -1;
            } else {
                return first_abs - second_abs;
            }
        });
        for (int i = 0; i < N; i++) {
            int request = Integer.parseInt(br.readLine());
            if (request == 0) {
                if (queue.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(queue.poll());
            } else {
                queue.add(request);
            }
        }
    }
}
