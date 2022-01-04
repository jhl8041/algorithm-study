package chap01.algo1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Max3 {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.println("정수의 최대값을 구합니다");
        System.out.print("값을 띄어쓰기로 구분해서 입력해주세요 : ");
        String input = stdIn.nextLine();

        // String 으로 받은 값을 Integer List로 바꾸는 법
        List<String> strList = Arrays.asList(input.split(" "));
        List<Integer> intList = strList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(getMax(intList));
    }

    private static int getMax(List<Integer> intList){
        int max = intList.get(0);
        int listSize = intList.size();

        for (int i=1; i<listSize; i++){
            int currInt = intList.get(i);

            if (currInt > max) {
                max = currInt;
            }
        }

        return max;
    }
}
