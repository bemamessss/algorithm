package day11.four_sum_2;
import java.util.*;

public class FourSum2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        // key : 합, value : 횟수
        Map<Integer, Integer> map = new HashMap<>();
        // 총 경우의 수
        int count = 0;

        // A + B + C + D = 0 
        // A + B = - (C + D)

        // #1. A, B 모든 조합에 대한 합의 카운트를 기록한다.
        for( int num1 : nums1 ) {
            for( int num2 : nums2 ) {
                int sum1 = num1 + num2;
                // 해당 합(key)이 이미 기록돼 있으면 카운트(value)를 1씩 늘려 준다. 없으면 기본값 0 + 1
                map.put( sum1, map.getOrDefault(sum1, 0) + 1 );
            }
        }

        // #2. C, D 모든 조합에 대해 -(C+D)을 구한 후, 이미 map에 있는지 확인한다.
        for( int num3 : nums3 ) {
            for( int num4 : nums4 ) {
                int sum2 = -( num3 + num4 );

                // 해당하는 합이 있으면, 카운트(value)를 변수에 기록하여 누적해 나감. (답이 경우의 수를 모두 세는 거므로.)
                count += map.getOrDefault( sum2, 0 );
            }
        }

        return count;
    }
}