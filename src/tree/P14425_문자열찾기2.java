package tree;

import java.util.Scanner;

public class P14425_문자열찾기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Node2 root = new Node2();
        //자료구조 저장
        while (n > 0) {
            String text = sc.next();
            Node2 now = root;
            for(int i = 0; i < text.length(); i++){
                char c = text.charAt(i);
                if (now.next[c - 'a'] == null) {
                    now.next[c - 'a'] = new Node2();
                }
                now = now.next[c - 'a'];
                if(i == text.length() - 1)
                    now.isEnd = true;
            }
            n--;
        }
        //검색
        int count = 0;
        while (m > 0) {
            String text = sc.next();
            Node2 now = root;
            for(int i = 0; i < text.length(); i++){
                char c = text.charAt(i);
                if (now.next[c - 'a'] == null) {
                    break;
                }
                now = now.next[c - 'a'];
                if (i == text.length() - 1 && now.isEnd)
                    count++;
            }
            m--;
        }
        System.out.println(count);
    }
}
 class Node2 {
    Node2[] next = new Node2[26];
    boolean isEnd;
 }
