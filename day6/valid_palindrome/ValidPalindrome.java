package day6.valid_palindrome;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        
        int left = 0;
        int right = s.length() - 1;

        // 경계 처리 필요. 0이나 "" 같이 값이 하나만 들어와도 굳이 비교할 필요 없이 true이므로 true==false 비교 생략. (ex.3)
        while( left < right ) {

            // if else if else문으로 처리하는 방법도 있지만...
            // 띄어쓰기나 특수문자 같은 건 다 건너뛴다. 안에서도 포인터가 이동하기 때문에 left right 체크는 또 해야 함.
            while( left < right && !Character.isLetterOrDigit( s.charAt(left) ) ) {
                left++;
            }

            while( left < right && !Character.isLetterOrDigit( s.charAt(right) ) ) {
                right--;
            }

            // 다르면? 바로 false.
            if( Character.toLowerCase( s.charAt(left) ) != Character.toLowerCase( s.charAt(right) ) ) {
                return false;
            }

            // 동일하면 다음 비교를 위해 포인터 이동.
            left++;
            right--;
        }

        return true;
    }
}
