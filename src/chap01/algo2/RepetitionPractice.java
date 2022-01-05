package chap01.algo2;

import java.util.Scanner;

public class RepetitionPractice {
    public static void main(String[] args){
//        Scanner stdIn = new Scanner(System.in);
//        int n = stdIn.nextInt();

        System.out.println("(1 ~ n 까지의 합) sum : " + sumOneToN(5));
        System.out.println("(a ~ b 까지의 합) sum : " + sumAToB(6, 117));

        printTriangleLB(5);
        System.out.println("-----");
        printTriangleLU(5);
        System.out.println("-----");
        printTriangleRU(5);
        System.out.println("-----");
        printTriangleRB(5);
        System.out.println("-----");
        spira(4);
        System.out.println("-----");
        nspira(4);

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

    // 왼쪽 아래가 직각인 이등변 삼각형 출력
    private static void printTriangleLB(int n){
        for (int i = 0; i <= n; i++){
            for (int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 왼쪽 위가 직각인 이등변 삼각형 출력
    private static void printTriangleLU(int n){
        for (int i = n; i > 0; i--){
            for (int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 오른쪽 위가 직각인 이등변 삼각형 출력
    private static void printTriangleRU(int n){
        for (int i = n; i > 0; i--){
            for (int j = 0; j < n-i; j++){
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 오른쪽 아래가 직각인 이등변 삼각형 출력
    private static void printTriangleRB(int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n-i-1; j++){
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 피라미드형 이등변 삼각형 출력
    private static void spira(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < n-i; j++){
                System.out.print(" ");
            }
            for (int j = 0; j < (i-1)*2 + 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // n단 피라미드형 이등변 삼각형 출력
    private static void nspira(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < n-i; j++){
                System.out.print(" ");
            }
            for (int j = 0; j < (i-1)*2 + 1; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
