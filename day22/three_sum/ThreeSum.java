package day22.three_sum;
import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // a+b+c=0   =   b+c=-a

        // pass-by-value : 참조형이라 주소값 복사해 주므로 return 값 안 받아도 됨.
        Arrays.sort(nums);
        
        // 정렬 후 하나는 고정해 두고 투포인터.
        // ABCDE라고 치면, left, right 하나씩이 필요함. C, D, E가 최대고 D부터는 불가능하기 때문에 투 포인터 개수만큼 뺌 -2
        for( int i = 0 ; i < nums.length - 2 ; i ++ ) {

            // 양수면 b+c=-a이 불가능. 쌓은 result까지만 돌고 빠져나오자.
            if( nums[i] > 0 ) {
                break;
            }

            // 기준수가 중복이면 건너뛰기. 처음 건 해야 하고 이후에 중복 검사하는 거. 예를 들어 nums이 3개일 수 있으니까.
            if( i > 0 && nums[i] == nums[i-1] ) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while( left < right ) {
                int sum = nums[i] + nums[left] + nums[right];

                if( sum == 0 ) {
                    result.add( Arrays.asList( nums[i], nums[left], nums[right] ) );

                    // 답이 여러 개일 수 있으니 다음 포인터로 이동하되, 중복은 건너뛰어야 함.
                    while( left < right && nums[left] == nums[left + 1] ) left++;
                    while( left < right && nums[right] == nums[right - 1 ] ) right--;

                    // 중복까지 걸렀으면 실제로 포인터 이동.
                    left++;
                    right--;

                // 얘넨 어차피 정답 아니니 중복 검사 안 해 줘도 됨.    
                } else if( sum < 0 ) {
                    left++;
                } else {
                    right--;
                }
            }

        }

        return result;
    }
}