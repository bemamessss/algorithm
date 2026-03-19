package day28.longest_substring;
import java.util.*;

public class LongestSubstring {
    
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;

        // 중복 검사 : HashSet
        Set<Character> set = new HashSet<>();

        for( int right = 0 ; right < s.length() ; right++ ) {
            char c = s.charAt(right);
            
            while( set.contains(c) ) {
                // remove는 인덱스가 아니라 특정 값을 지정해야 함. 해시셋은 인덱스 없음.
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);

            max = Math.max( max, right - left + 1 );
        }

        return max;
    }
}