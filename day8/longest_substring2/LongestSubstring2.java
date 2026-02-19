package day8.longest_substring2;
import java.util.*;

public class LongestSubstring2 {

    public int lengthOfLongestSubstring(String s) {

        // 엣지 케이스 처리
        if( s.isEmpty() ) return 0;
        
        int max = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();

        for( int right = 0 ; right < s.length() ; right ++ ) {
            
            // 같으면 왼쪽부터 자르자. 어차피 max 값 저장할 거라 계속 나아가도 됨.
            while( !set.add( s.charAt(right) ) ) {
                set.remove( s.charAt(left) );
                left++;
            }

            // left = right일 때는 1개니까 +1을 해 주자.
            max = Math.max( max, right - left + 1 );
        }

        return max;
    }
}
