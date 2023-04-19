package greedy;

import java.util.Scanner;

public class P1541_잃어버린괄호2 {
    static int result = 0;
    public static void main(String[] args) {
        //최소값을 만들려면 +되어있는 값들을 괄호로 묶고 -를 해주면 될듯..
        //-기호를 만난 순간부터~ 다음 -기호 만나기 전까지의 숫자를 다 더한다.
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        //+로 된 숫자들만 묶어서 배열 만들기
        String[] bind = exp.split("-");
        //계산하기
        for (int i = 0; i < bind.length; i++){
           int temp = doSum(bind[i]);
           if (i == 0) {
               result += temp;
           }
           else {
               result -= temp;
           }
        }
        System.out.println(result);
    }
    //나뉜 배열안에 있는 숫자들 더하는 메소드
    static int doSum(String a){
        int sum = 0;
        String temp[] = a.split("[+]");
        for(int i = 0; i < temp.length; i++){
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
