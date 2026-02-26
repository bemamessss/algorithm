package day13.isomorphic;
import java.util.*;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        // 엣지 케이스 처리: 길이가 다르면 애초에 1:1 매칭 불가
        if( s.length() != t.length() ) return false;

        // 짝을 Map에 만들어 주고, 양방향 검사를 통해 동형 판별
        // 키(s) : 밸류(t)
        Map<Character, Character> map = new HashMap<>();
        
        for( int i = 0 ; i < s.length() ; i ++ ) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            
            // 1. s의 짝이 이미 있을 때
            if( map.containsKey(cs) ) {
                // 짝에 해당하는 t의 값(map의 value)와 지금 뽑힌 ct가 다르면 동형 아님.
                if( map.get( cs ) != ct )  return false;
            
            // 2. 짝이 없을 때는 맵에 추가
            } else {
                // 추가하기 전에 짝인 t에 이미 매칭된 키가 있는지 확인. (양다리 방지)
                if( map.containsValue( ct ) ) {
                    // s는 짝이 없는데 t는 이미 있다? 다른 애랑 매칭된 것. 동형 아님.
                    return false;
                } else {
                    map.put( cs, ct );
                }
            }
        }
         return true;
    }
}
