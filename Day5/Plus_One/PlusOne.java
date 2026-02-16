package day5.plus_one;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        
        for( int i = digits.length - 1 ; i >= 0 ; i -- ){

            // 끝자리가 9보다 작으면 올림 없이 1만 추가하면 됨.
            if( digits[i] < 9 ) {
                digits[i] = digits[i] + 1;
                return digits;
            }

            // 위에서 리턴 못 했다 => 올림 발생.
            digits[i] = 0;

        } 

        // 다 돌았는데 나왔으면 0000... 상태니까 앞에 1을 붙여 줘야 함.
        int[] aNewDigit = new int[digits.length + 1];
        aNewDigit[0] = 1;
        return aNewDigit;
    }
}