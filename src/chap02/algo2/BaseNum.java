package chap02.algo2;

public class BaseNum {

    public static void main(String[] args){

        String answer = changeBase(34, 8, 16);

        System.out.println(answer);
    }

    // 진수 변환
    private static String changeBase(int originalNum, int originalBase, int newBase){

        int numDecimal = 0;
        int powerCnt = 0;

        while(originalNum != 0) {
            int singleDigit = originalNum%10;
            numDecimal += singleDigit * Math.pow(originalBase, powerCnt);
            powerCnt++;
            originalNum /= 10;

        }

        String digitChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder reversedNewBaseNum = new StringBuilder();
        while(numDecimal != 0) {
            reversedNewBaseNum.append(digitChar.charAt(numDecimal % newBase));
            numDecimal /= newBase;
        }

        return reversedNewBaseNum.reverse().toString();
    }
}
