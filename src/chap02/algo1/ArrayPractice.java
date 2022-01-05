package chap02.algo1;

import java.util.Random;

public class ArrayPractice {

    public static void main(String[] args){

        // 배열 선언
        int[] a;

        // 배열 참조
        a = new int[5];

        // 요솟값 초기화
        int[] b = {1, 2, 3, 4, 5};
        int[] c = new int[] {1, 2, 3, 4, 5}; // 더 명확하게

        // 배열 사이즈
        int cLength = c.length;

        // 배열 복제
        int[] d = c.clone();

        // 난수 생성
        Random rand = new Random();
        rand.nextInt(90); // 0 ~ n 사이의 랜덥 값 반환


    }
}
