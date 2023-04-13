package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253_좋은수1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int count = 0;
        long A[] = new long[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(stringTokenizer.nextToken());
        }
        Arrays.sort(A);

        for (int k = 0; k < N; k++) {
            long good = A[k];
            int i =0;
            int j = N - 1;

            while (i < j) {
                if (A[i] + A[j] == good) {
                    if (i != k && j != k) {
                        count++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (A[i] + A[j] < good) {
                    i++;
                } else {
                    j--;
                }
              }
            }
        System.out.println(count);
        bufferedReader.close();
        }
    }

