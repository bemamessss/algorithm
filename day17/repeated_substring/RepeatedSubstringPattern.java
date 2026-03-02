package day17.repeated_substring;

public class RepeatedSubstringPattern {
    
    public boolean repeatedSubstringPattern(String s) {
        // 두 번 붙이기
        String doubleS = s + s;

        // 기존 패턴은 깨기 위해 양끝 글자 자르기.
        String subS = doubleS.substring( 1, doubleS.length() - 1 );

        // 기존 패턴 깬 문자열에도 패턴이 반복되는지?
        return subS.contains( s );

    }
}
