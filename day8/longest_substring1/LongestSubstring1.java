package day8.longest_substring1;

public class LongestSubstring1 {
    
    public String longestCommonPrefix(String[] strs) {
        if( strs == null || strs.length == 0 ) {
            return "";
        }

        String target = strs[0];

        for( String str : strs ) {
            
            // while은 조건 반대로 짜지 않게 주외. 내부가 true일 때까지 돈다. 일치하지 않으면 계속 돌면서 잘라야 됨.
            while( str.indexOf( target ) != 0 ) {
                
                // 끝에서부터 한 글자씩 자르기. subString 아님.
                target = target.substring( 0, target.length() -1 );

                // 일치하는 게 하나도 없으면 끝.
                if( target.isEmpty() ) return target;
            }
        }

        return target;
    }
}