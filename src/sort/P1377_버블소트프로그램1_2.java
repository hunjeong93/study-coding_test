package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1377_버블소트프로그램1_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mData2[] A = new mData2[N];
        for (int i = 0; i < N; i++) {
            A[i] = new mData2(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(A);
        int Max = 0;
        for (int i = 0; i < N; i++) {
            if (Max < A[i].index - i)
                Max = A[i].index - i;
        }
        System.out.println(Max + 1);
    }
}
class mData2 implements Comparable<mData2> {
    int value;
    int index;

    public mData2(int value, int index) {
        super();
        this.value = value;
        this.index = index;
    }
    @Override
    public int compareTo(mData2 o) {
        return this.value - o.value;
    }
}
