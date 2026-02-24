package day12.valid_anagram;

import java.util.*;

public class ValidAnagramHashMap {

    public boolean isAnagram(String s, String t) {

        // 풀이 1 : HashMap

        // 글자 수 다르면 애초에 애니어그램 아님.
        if( s.length() != t.length() ) return false;

        // HashMap? 배열?
        // 빈도수를 카운트해야 하니까 무조건 key value 형태 해시 써야 하지 않나?
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        // toCharArray (글자 길이만큼 새로운 배열 생성하므로 짧으면 굳이)
        // charAt : 특정 인덱스값을 가져오니 O(1)지만 메소드 반복 호출
        // 50000 정도면 어떤 선택을 해야 할까. 짧은 건지 긴 건지... => 약 100KB(50,000×2 bytes) 미미한 수준임

        // 또 고민. s랑 t 글자 수는 같은 건가? 그럼 포문 두 번 안 돌려도 되는데. => 앞에서 엣지 케이스로 체크해 버리자.
        for( int i = 0 ; i < s.length() ; i ++ ) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            sMap.put( sChar, sMap.getOrDefault( sChar , 0 ) + 1 );
            tMap.put( tChar, tMap.getOrDefault( tChar , 0 ) + 1 );

            // 이런 방법도 있음. map은 하나만 만들고 증감으로 체크.
        }

        return sMap.equals( tMap );

    }
}