package day32.min_sub_array_len;

public class MinSubArrayLen {
    
    public int minSubArrayLen(int target, int[] nums) {
        
        int sum = 0;
        int left = 0;
        
        // [핵심] 갱신 시 무조건 지는 '샌드백' 역할. 점점 줄일 수 있게 제일 큰 값으로 초기화.
        int minLen = Integer.MAX_VALUE;       

        for( int right = 0 ; right < nums.length ; right++ ) {

            // 1. [진입] 오른쪽 창문을 넓히며 누적합 계산
            sum += nums[right];

            // 2. [최적화] 타겟 숫자를 넘겼다면? 더 줄일 수 있을 때까지 줄여 보기!
            while( sum >= target ) {
                
                // 일단 조건 안에 들어왔으니까 답 갱신. (기존 최소 길이 vs 현재 창문 길이)
                minLen = Math.min( minLen, right - left + 1 );
                
                // 창문 왼쪽을 한 칸씩 줄여보면서 계속 쥐어짬
                sum -= nums[left];
                left++;
            }
        }

        // 끝까지 돌았는데 minLen이 초기값 그대로라면? 타겟을 한 번도 못 넘겼다는 뜻!
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}