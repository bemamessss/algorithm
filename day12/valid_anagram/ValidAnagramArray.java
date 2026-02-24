package day12.valid_anagram;

public class ValidAnagramArray {

    public boolean isAnagram(String s, String t) {

        // 풀이 2 : int[]

        if( s.length() != t.length() ) return false;

        // 어차피 소문자 한정이니까 인덱스를 키라고 생각하면 편함. 값은 빈도수를 담자. 굳이 해시맵을 쓸 필요가 없다. 
        int[] count = new int[26];

        // 10^4개밖에 안 되니까 toCharArray 써도 됨.
        for( char sc : s.toCharArray() ) {
            count[ sc - 'a' ] ++;
        }

        for( char tc : t.toCharArray() ) {
            count[ tc - 'a' ] --;

            // t가 s보다 더 많이 쓰인 문자가 있다면? 덜 쓰인 문자도 있을 것. 여기까지만 체크해도 됨.
            if( count [ tc - 'a' ] < 0 ) return false;
        }

        // 이제 두 개 비교는 어떻게? => 할 필요 없음. 이미 < 0 에서 다 걸러졌음.
        return true;

    }
}