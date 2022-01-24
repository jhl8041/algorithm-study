package chap02.algo2;

public class PrimeNum {

    public static void main(String[] args){

        // 이미 찾은 소수를 활용해서 1000 이하 소수 구하기
        usePrimeToGetPrime2();


    }

    private static void usePrimeToGetPrime(){
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];

        // ptr 값을 증가시키기위해 ptr++를 사용한다
        prime[ptr++] = 2;

        for (int n = 3; n <= 1000; n += 2){
            int i;
            for (i = 1; i < ptr; i++){
                counter ++;
                if (n % prime[i] == 0){
                    break;
                }
            }
            if (ptr == i){
                prime[ptr++] = n;
            }
        }

        for (int i = 0; i < ptr; i++){
            System.out.println(prime[i]);
        }


        System.out.println("나눗셈을 수행한 횟수: " +  counter);
    }

    private static void usePrimeToGetPrime2(){
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];

        // ptr 값을 증가시키기위해 ptr++를 사용한다
        prime[ptr++] = 2;
        prime[ptr++] = 3; // 3도 소수다

        for (int n = 5; n <= 1000; n += 2){
            boolean flag = false;

            for (int i = 1; prime[i] * prime[i] < n; i++){
                counter += 2; // 나눗셈도 카운트하기위해 2씩 증가한다
                if (n % prime[i] == 0){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                prime[ptr++] = n;
                counter++;
            }
        }

        for (int i = 0; i < ptr; i++){
            System.out.println(prime[i]);
        }


        System.out.println("나눗셈을 수행한 횟수: " +  counter);
    }

}
