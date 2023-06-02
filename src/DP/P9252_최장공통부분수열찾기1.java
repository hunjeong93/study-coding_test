package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P9252_최장공통부분수열찾기1 {
    private static long[][] DP;
    private static ArrayList<Character> Path;
    private static char[] A;
    private static char[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();
        DP = new long[A.length + 1][B.length + 1];
        Path = new ArrayList<Character>();

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                }
            }
        }
        System.out.println(DP[A.length][B.length]);
        getText(A.length, B.length);
        for (int i = Path.size() - 1; i >= 0; i--) {
            System.out.print(Path.get(i));
        }
        System.out.println();
    }

    private static void getText(int row, int col) {
        if (row == 0 || col == 0) {
            return;
        }
        if (A[row - 1] == B[col - 1]) {
            Path.add(A[row - 1]);
            getText(row - 1, col - 1);
        } else {
            if (DP[row - 1][col] > DP[row][col - 1]) {
                getText(row - 1, col);
            } else {
                getText(row, col - 1);
            }
        }
    }
}
