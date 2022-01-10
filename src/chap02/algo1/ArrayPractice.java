package chap02.algo1;

import java.util.Arrays;
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

        int[] firstArray = new int[] {5, 10, 73, 2, -5, 42};
        int[] secondArray = new int[6];

        copyReveredArray(firstArray, secondArray);
        System.out.println(Arrays.toString(firstArray));
        System.out.println(Arrays.toString(secondArray));
    }

    // 역순정렬한 배열을 복사
    static void copyReveredArray(int[] array, int[] newArray){
        int[] tmpArray = array.clone();
        reverseArray(tmpArray);
        copyArray(tmpArray, newArray);
    }


    // 배열 복사
    static void copyArray(int[] array, int[] newArray){
        int arraySize = array.length;
        for (int i = 0; i<arraySize; i++){
            newArray[i] = array[i];
        }
    }

    // 배열 역순으로 정렬
    static void reverseArray(int[] array){
        int arraySize = array.length;
        for (int i=0; i<arraySize/2; i++){
            swap(array, i, arraySize-i-1);
        }
    }

    // 스왑
    static void swap(int[] array, int idx1, int idx2){
        int tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }
}
