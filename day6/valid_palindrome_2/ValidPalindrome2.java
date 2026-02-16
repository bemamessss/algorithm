package day6.valid_palindrome_2;

public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while ( left < right ) {
            if( s.charAt( left ) == s.charAt( right ) ) {
                left++;
                right--;
            // 만약 다르면? 한 번은 지울 기회가 있다. 왼쪽을 지우거나, 오른쪽을 지우거나.    
            } else {
                return ( this.removeOneChar( s, left + 1, right ) || this.removeOneChar( s, left, right - 1 ) );
            }

        }

        return true;
    }

    private boolean removeOneChar( String s, int left, int right ) {

        while( left < right ) {

            if( s.charAt( left ) == s.charAt( right ) ) {
                left++;
                right--;
            // 만약 다르면? 위와 다르게 기회 끝. false. 
            } else {
                return false;
            }           
        }

        return true;
    }
}