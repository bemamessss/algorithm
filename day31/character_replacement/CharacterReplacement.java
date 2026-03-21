package day31.character_replacement;

public class CharacterReplacement {
    
    public int characterReplacement(String s, int k) {

        int[] count = new int[26];

        // 창문 내에서 [제일 많은 알파벳]을 기준으로 나머지를 뒤집어야 제일 길다.

        int left = 0;
        int currentMax = 0; // 현재 창문 내에서 대장인 알파벳 갯수
        int result = 0;

        for( int right = 0 ; right < s.length() ; right ++ ) {
            char rightChar = s.charAt(right);

            // 방금 들어온 알파벳 빈도수 기록. 대문자만 들어오니까 'A' 빼기
            count[rightChar - 'A']++;

            // 방금 추가된 알파벳 반영해서 지금 이 창문 안 대장 업데이트.
            currentMax = Math.max( currentMax, count[rightChar - 'A'] );

            // 현재 창문 길이가 [최대로 뒤집을 수 있는 k+현재 대장 수]보다 커진다면 왼쪽 문 줄여야 함.
            // => 슬라이딩 윈도우 템플릿이 while문인 거지, 이건 모든 알파벳 대상으로 흔적 지우기를 하므로 if문도 가능함.
            // left++로 창문 사이즈만 줄이면 바로 조건 충족이니 반복문 필요가 없음.
//            while( right - left + 1 > k + currentMax ) {
            if ((right - left + 1) > k + currentMax) {    
                char leftChar = s.charAt(left);
                // 쫓겨나니까 개수 빼 줌. 흔적 지우기.
                count[leftChar - 'A']--;
                left++;
            }

            result = Math.max( result, right - left + 1 );

        }

        return result;
    }
}