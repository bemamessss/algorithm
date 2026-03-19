package day28.max_ones;

public class MaxOnes {
    
    public int findMaxConsecutiveOnes(int[] nums) {
        int current = 0;
        int max = 0;

        for (int num : nums) {
            // 1. 숫자가 1일 경우 연속 카운트 증가 및 최대값 갱신
            if (num == 1) {
                current++;
                
                // [핵심 최적화] Math.max() 대신 if문으로 오버헤드 방지
                if (current > max) {
                    max = current;
                }
            } 
            // 2. 숫자가 0일 경우 연속이 끊겼으므로 카운트 초기화
            else {
                current = 0;
            }
        }

        return max;
    }
}