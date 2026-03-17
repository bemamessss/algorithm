package day27.max_average;

public class MaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        // 1. 첫 번째 창문(인덱스 0 ~ k-1)의 합 구하기
        // 나중에 평균(/ k)을 소수점까지 구하기 위해 처음부터 double 사용
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // 초기 최대합을 무조건 '첫 창문의 합'으로 세팅
        double maxSum = sum;

        // 2. 창문 밀기 (슬라이딩 윈도우 시작)
        // i는 '새로 창문으로 들어오는 원소'의 인덱스
        for (int i = k; i < nums.length; i++) {
            
            // [핵심 로직] 기존 합 + 새로 들어온 값 - 밖으로 밀려난 값
            // i - k : 정확히 창문의 맨 앞(나가는 값)을 가리키는 인덱스
            sum = sum + nums[i] - nums[i - k];

            // 최대 합 갱신
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        // 3. 최댓값을 k로 나누어 평균 반환
        return maxSum / k;
    }
}