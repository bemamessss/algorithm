package day31.check_inclusion;
import java.util.*;

public class CheckInclusion {
    
    public boolean checkInclusion(String s1, String s2) {

        // 엣지 케이스 처리
        if (s1.length() > s2.length()) return false;

        int[] standard = new int[26];
        int[] all =  new int[26];

        for( int i = 0 ; i < s1.length() ; i ++ ) {
            standard[s1.charAt(i) - 'a']++;
            all[s2.charAt(i) - 'a']++;
        }

        if( Arrays.equals( standard, all ) ) return true;

        int windowSize = s1.length();

        for( int i = windowSize ; i < s2.length() ; i ++ ) {
            // 새로 들어온 값 
            all[s2.charAt( i ) - 'a']++;
            // 빠질 값
            all[s2.charAt( i - windowSize ) - 'a']--;

            if( Arrays.equals( standard, all ) ) return true;
        }

        return false;
    }
}