package day32.find_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {

        // 정답(시작 인덱스)을 담을 리스트
        List<Integer> result = new ArrayList<>();

        // [엣지 케이스] 타겟(p)의 길이가 전체 문자열(s)보다 길면 애너그램 존재 불가
        if( p.length() > s.length() ) return result;

        int[] all = new int[26];      // s에서 훑고 지나갈 현재 창문(장바구니)
        int[] standard = new int[26]; // p의 알파벳 구성(정답 레시피)

        // 1. 첫 번째 창문 세팅 (0번 인덱스부터 p의 길이만큼)
        for( int i = 0 ; i < p.length() ; i ++ ) {
            all[s.charAt(i) - 'a']++;
            standard[p.charAt(i) - 'a']++;
        }

        // 혹시 첫 번째 창문부터 정답과 일치한다면, 시작점인 0을 정답 리스트에 추가
        if( Arrays.equals( all, standard ) ) {
            result.add(0);
        }

        int windowSize = p.length(); // 윈도우의 크기는 p의 길이로 완벽히 고정!

        // 2. 본격적인 고정 길이 슬라이딩 윈도우 탐색
        for( int i = windowSize ; i < s.length() ; i ++ ) {
            
            // [오른쪽] 창문이 한 칸 밀리면서 새롭게 들어온 값 추가
            all[s.charAt(i) - 'a']++;

            // [왼쪽] 창문이 한 칸 밀리면서 범위 밖으로 빠질 값 제거 (흔적 지우기)
            all[s.charAt(i - windowSize) - 'a']--;

            // 갱신된 현재 창문이 정답 레시피와 일치하는지 확인
            if( Arrays.equals( all, standard ) ) {
                // 일치한다면 시작 인덱스를 계산하여 리스트에 추가
                // (현재 오른쪽 끝 인덱스 i) - (창문 크기) + 1 = (창문의 시작 인덱스)
                result.add( i - windowSize + 1 );
            }
        }

        return result;
    }
}