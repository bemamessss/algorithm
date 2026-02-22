package day10.length_of_last_word;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int length = 0;
        
        // 뒤에서부터 앞으로 이동하며 탐색
        for (int i = s.length() - 1; i >= 0; i--) {
            // 1. 공백이 아니면 단어의 길이를 하나씩 증가
            if (s.charAt(i) != ' ') {
                length++;
            } 
            // 2. 단어를 이미 세고 있는데(length > 0) 공백을 만났다면?
            // 그것은 마지막 단어의 시작 부분에 도달했다는 뜻!
            else if (length > 0) {
                return length; // 즉시 정답 반환 후 종료
            }
        }

        // 3. 문장 전체에 단어가 하나뿐인 경우(예: "Hello") 루프 종료 후 반환
        return length;
    }
}