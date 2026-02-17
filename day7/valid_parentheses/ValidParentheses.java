package day7.valid_parentheses;

public class ValidParentheses {
    
    public int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;

        for( char c : s.toCharArray() ) {
            if( c == '(' ) {
                currentDepth++;
                // 지금 뎁스가 맥스보다 크면 갱신한다.
                maxDepth = Math.max( maxDepth, currentDepth );
            } else if( c == ')' ) {
                currentDepth--;
            }
        }

        return maxDepth;
    }
}
