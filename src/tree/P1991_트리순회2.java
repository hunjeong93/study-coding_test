package tree;

import java.util.Scanner;

public class P1991_트리순회2 {
    static int[][] tree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        tree = new int[26][2];  //왼쪽 자식노드 0, 오른쪽 자식노드 1
        for (int i = 0; i < n; i++){
            String[] temp = sc.nextLine().split(" ");
            int node = temp[0].charAt(0) -'A';   //index로 변환
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);

            if (left == '.') {
                tree[node][0] = -1;  //자식 노드가 없을때 -1 저장
            } else {
                tree[node][0] = left - 'A';
            }
            if (right == '.'){
                tree[node][1] = -1;
            } else {
                tree[node][1] = right - 'A';
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }
    public static void preOrder(int now){
        if (now == -1)
            return;
        System.out.print((char) (now + 'A'));  //현재노드
        preOrder(tree[now][0]);  //왼쪽탐색
        preOrder(tree[now][1]);  //오른쪽 탐색
    }
    public static void inOrder(int now){
        if (now == -1)
            return;
        inOrder(tree[now][0]);  //왼쪽
        System.out.print((char) (now +'A'));  //현재
        inOrder(tree[now][1]);  //오른쪽
    }
    public static void postOrder(int now){
        if (now == -1)
            return;
        postOrder(tree[now][0]); //왼쪽
        postOrder(tree[now][1]); //오른쪽
        System.out.print((char) (now +'A')); //현재
    }
}
