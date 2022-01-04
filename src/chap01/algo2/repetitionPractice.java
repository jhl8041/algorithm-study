package chap01.algo2;

import java.util.Scanner;

public class repetitionPractice {
    public static void main(String[] args){
//        Scanner stdIn = new Scanner(System.in);
//        int n = stdIn.nextInt();

        System.out.println("(1 ~ n 까지의 합) sum : " + sumOneToN(5));
        System.out.println("(a ~ b 까지의 합) sum : " + sumAToB(6, 117));

    }

    // 1 ~ n 까지의 합 구하기 (가우스 덧셈)
    private static int sumOneToN(int n){
        return (n+1)*n/2;
    }

    // 대/소 상관없이 a 부터 b 까지 모든 정수의 합 구하기 (가우스 덧셈 사용)
    private static int sumAToB(int a, int b){
        int bigNum = Math.max(a,b);
        int smallNum = Math.min(a,b);

        return sumOneToN(bigNum) - sumOneToN(smallNum-1);
    }

    // 짝수 체크
    private static boolean isEven(int n){
        return (n & 1) == 0;
    }
}
