package day7.max_dep_parentheses;
import java.util.*;

public class MaxDepParenthese {
    public boolean isValid(String s) {

        // 제네릭 Character로 한정
        Stack<Character> stack = new Stack<>();

        // toCharArray 기억하기!
        for( char c : s.toCharArray() ) {
            if( c == '(' || c == '{' || c == '[' ) {
                stack.push( c );
            } else {
                // isEmpty()로 검사. 
                if( stack.isEmpty() ) return false;

                char pop = stack.pop();
                
                if( pop == '(' && c != ')' ) return false;
                if( pop == '{' && c != '}' ) return false;
                if( pop == '[' && c != ']' ) return false;
            }
        }

        // 엣지 케이스 처리!! 여는 괄호로만 끝날 수도 있음.
        // return true;
        return stack.isEmpty();

        // 대칭이 아닐 수 있기 때문에 투 포인터로 풀면 안 됨.
        // int left = 0;
        // int right = s.length() - 1;

        // while( left < right ) {

        //     char cLeft = s.charAt( left );
        //     char cLeftPlus = s.charAt( left + 1 );
        //     char cRight = s.charAt( right );
            
        //     switch (cLeft) {
        //         case '(' : 
        //             if( ')' != cRight && ')' != cLeftPlus ) return false;
        //             break;
        //         case '{' : 
        //             if( '}' != cRight && '}' != cLeftPlus ) return false;
        //             break;
        //         case '[' : 
        //             if( ']' != cRight && ']' != cLeftPlus ) return false;
        //             break;
        //         default :
        //             return false;   
        //     }

        //     left++;
        //     right--;

        // }

        // return true;
    }
}