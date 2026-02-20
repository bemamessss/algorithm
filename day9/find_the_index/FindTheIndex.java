package day9.find_the_index;

public class FindTheIndex {
    
    public int strStr(String haystack, String needle) {

        // 엣지 케이스 처리
        if( haystack.isEmpty() || needle.isEmpty() || haystack.length() < needle.length() ) {
            return -1;
        }

        boolean isSuccess = false;
        
        // haystack이 abcde고, needle이 cde라고 가정하면 두 칸만 밀 수 있다. for문 횟수 체크.
        for( int i = 0 ; i <= ( haystack.length() - needle.length() ) ; i ++ ) {

            // 이제 한 글자씩 비교한다.
            for( int j = 0 ; j < needle.length() ; j ++ ) {
                // 다르면 pass. i가 아니라 i+j이어야 한다. 아니면 첫 글자에서 계속 고정되어 있어 정확한 비교가 안 됨.
                if( haystack.charAt( i + j ) != needle.charAt( j ) ) {
                    // 틀리면 더 비교할 필요 없음. 한 칸 이동해야 하니 지금 포문은 나가자.
                    break;
                }

                // 길이까지 포문이 다 돌았다면 성공.
                if( j == needle.length() - 1 ) {
                    isSuccess = true;
                    // 보완 : 이렇게 할 필요 없이 바로 return i 해 버리는 게 더 깔끔.
                }
            }

            // 내부 for문에서 비교에 성공했다면? 끝. 인덱스 반환.
            if( isSuccess ) return i;
        }

        // 이때까지 리턴을 못 했다? 일치하는 게 없음.
        return -1;

    }
}