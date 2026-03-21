package day30.max_ones_3;

public class MaxOnes3 {
    
    public int longestOnes(int[] nums, int k) {

        // 1. 상태를 저장할 변수 초기화
        int max = 0;         // 지금까지 발견한 가장 긴 연속된 1의 길이 (정답)
        int left = 0;        // 슬라이딩 윈도우의 왼쪽 끝 포인터
        int zeroCount = 0;   // 현재 창문(left...right) 안에 포함된 0의 개수

        // 2. 오른쪽 포인터(right)가 배열의 처음부터 끝까지 한 칸씩 이동하며 창문을 확장
        for( int right = 0 ; right < nums.length ; right++ ) {

            // [진입] 창문의 오른쪽 끝으로 새로 들어온 숫자가 0이라면 카운트 증가
            if( nums[right] == 0 ) {
                zeroCount++;
            }

            // [중요 로직: 조건 보정] 
            // 창문 안의 0의 개수(zeroCount)가 허용치(k)를 초과했다면,
            // 조건을 만족할 때까지(zeroCount가 k 이하가 될 때까지) 창문의 왼쪽 끝을 좁혀야 함.
            while( zeroCount > k ) {
                // 창문의 왼쪽 끝(left)에서 밀려나는 숫자가 0이었다면,
                // 이제 창문 밖에 있으므로 zeroCount를 감소시켜 줌.
                if( nums[left] == 0 ) {
                    zeroCount--;
                }
                
                // 창문의 왼쪽 끝을 한 칸 오른쪽으로 이동 (창문 축소)
                left++;
            }

            // [결과 계산]
            // while 루프를 탈출했다는 것은 현재 창문이 0을 k개 이하로 포함하고 있다는 의미(유효함).
            // 현재 유효한 창문의 길이(right - left + 1)를 계산하여 지금까지의 최대 길이와 비교 후 갱신.
            max = Math.max( max, right - left + 1 );
        }

        // 3. 탐색이 끝난 후 저장된 최대 길이를 반환
        return max;
    }
}