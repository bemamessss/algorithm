package day15.roman_to_integer;
import java.util.Map;

public class RomanToInteger {

    
    // 1. [최적화] static과 Map.of()를 활용한 읽기 전용(Immutable) 장부 세팅
    // 프로그램 실행 시 딱 한 번만 메모리에 올라가므로 성능이 극대화됨!
    // Map.of() => 10쌍까지만 가능한 것을 꼭 기억하자!
		private static final Map<Character, Integer> romanMap = Map.of(
	    'I', 1,
	    'V', 5,
	    'X', 10,
	    'L', 50,
	    'C', 100,
	    'D', 500,
	    'M', 1000
		);

    public int romanToInt(String s) {
        int sum = 0;

        // 2. 마지막 글자 '바로 앞'까지만 반복 검사 (IndexOutOfBounds 방지)
        for (int i = 0; i < s.length() - 1; i++) {
            int val = romanMap.get(s.charAt(i));
            int nextVal = romanMap.get(s.charAt(i + 1));

            // 3. 현재 숫자가 다음 숫자보다 작으면 빼기 (-)
            if (val < nextVal) {
                sum -= val;
            } 
            // 그 외(크거나 같으면) 더하기 (+)
            else {
                sum += val;
            }
        }

        // 4. 루프를 빠져나온 '마지막 글자'는 무조건 더해줌
        sum += romanMap.get(s.charAt(s.length() - 1));

        return sum;
    }
}