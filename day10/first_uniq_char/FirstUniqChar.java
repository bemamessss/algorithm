package day10.first_uniq_char;

public class FirstUniqChar {

    public int firstUniqChar(String s) {
        // 알파벳 소문자는 26개. 해시맵을 사용해도 되나, 영문 소문자만 들어오므로 배열로 정해 놓고 가는 게 메모리와 속도 면에서 유리.
        int[] al = new int[26];

        // 각 알파벳마다 몇 번씩 사용됐는지 기록한다.
        // 보완 : toCharArray는 문자열 길이만큼 배열을 반환하므로 공간 복잡도가 O(n)이 된다. 다음부터는 s.charAt(i) 써서 메모리 아끼자.
        for( char c : s.toCharArray() ) {
            al[c - 'a']++;
        }

        // 첫 알파벳부터 꺼내 보면서 1번 사용된 알파벳을 찾는다.
        for( int i = 0 ; i < s.length() ; i ++ ) {
            char c = s.charAt(i);
            if( al[c - 'a'] == 1 ) return i;
        }

        return -1;
    }
}