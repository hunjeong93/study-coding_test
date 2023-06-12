package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11660_구간합구하기2_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int A[][] = new int[X + 1][X + 1];
        for(int i = 1; i <= X; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= X; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int D[][] = new int[X + 1][X + 1]; //구간 합 배열
        //구간합 구하는 방법
        // : 배열의 처음부터 ~ D[i][j]까지의 합 = D[i-1][j] + D[i][j-1] + A[i][j] - D[i - 1][j - 1] -> 두번 더해지므로
        for (int i = 1; i <= X; i++) {
            for(int j = 1; j <= X; j++) {
                D[i][j] = D[i - 1][j] + D[i][j - 1] + A[i][j] - D[i - 1][j - 1];
            }
        }
        for(int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            //(x1,y1) ~ (x2,y2)사이의 합 구하는 방법 :
            // (x2, y2)까지의 구간합에서 (x2,y1 -1) (x1 -1, y2) 를 빼고 두번 빼게 된 (x1 -1, y1 -1)을 더해준다
            int result = D[x2][y2] - D[x2][y1 - 1] - D[x1 - 1][y2] + D[x1 - 1][y1 - 1];
            System.out.println(result);
        }
    }
}
