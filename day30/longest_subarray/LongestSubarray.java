package day30.longest_subarray;

public class LongestSubarray {

    public int longestSubarray(int[] nums) {
        int max = 0;
        int left = 0;
        int zeroCount = 0;

        for( int right = 0 ; right < nums.length ; right++ ) {
            
            // 1. 숫자 0을 만나면 카운트 증가 ('0' 문자 아님 주의!)
            if( nums[right] == 0 ) {
                zeroCount++;
            }

            // 2. 1004번의 k 대신 1이 들어간 것. (0은 최대 1개만 허용)
            while( zeroCount > 1 ) {

                // while문을 빠져나갈 수 있는 조건을 만들어야 함.
                if( nums[left] == 0 ) {
                    zeroCount--;
                }

                // [핵심] 창문을 좁히는 거라서 지우는 게 아님.
                // nums.remove(left); (X)
                left++; 
            }

            // 3. 무조건 1개는 빼야 하니까 right - left 
            // ex) [1,1,1]이면 left는 0, right는 2일 시 창문 크기는 3이지만 하나 빼야 하므로 정답은 2임.
            max = Math.max( max, right - left );    
        }

        return max;
    }
}