package datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164_카드게임2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int N = sc.nextInt();
        //queue에 N만큼 카드 쌓기
        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            queue.poll(); //맨위 카드 버림
            queue.add(queue.poll()); //그다음 위 카드 아래에 저장
        }
        System.out.println(queue.poll());
    }
}
