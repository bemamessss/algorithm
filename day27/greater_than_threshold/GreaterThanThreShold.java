package day27.greater_than_threshold;

public class GreaterThanThreShold {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;

        // 우선 앞에서 k개만큼의 합을 먼저 구한다.
        for( int i = 0 ; i < k ; i ++) {
            sum += nums[i];
        }

        double max = sum;

        // 옆으로 밀 수 있는 만큼만 돌아야 함.
        // k : 창문 안에 새로 들어올 제일 첫번째 인덱스.
        // e.g. 개수가 6이고 k가 4면, 0~3번째 인덱스까지 합산했으니 0이 빠지고 4가 추가돼야 한다. (i=k)
        // 4번째, 5번째 인덱스까지 전진할 수 있으므로 i(4,5) < nums.length(6)
        for( int i = k ; i < nums.length ; i++ ) {
            sum = sum + nums[i] - nums[i-k];

            if( sum > max ) {
                max = sum;
            }
        }

        return max/k;
    }
}