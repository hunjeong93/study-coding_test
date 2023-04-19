package greedy;

import java.util.Scanner;

public class P1541_잃어버린괄호1 {
    static int res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        String[] str = st.split("-");

        for (int i = 0; i < str.length; i++) {
            int tmp = mySum(str[i]);
            if (i == 0) {
                res = res + tmp;
            } else {
                res = res - tmp;
            }
        }
        System.out.println(res);
    }

    static int mySum(String a) {
        int sum = 0;
        String tmp[] = a.split("[+]");// ???
        for (int i = 0; i < tmp.length; i++) {
            sum += Integer.parseInt(tmp[i]);
        }
        return sum;
    }
}
