import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // 내가 보고 온 걸 기억하려면 해시맵을 쓰자.
        Map<Integer, Integer> map = new HashMap<>();

        for( int i = 0 ; i < nums.length ; i ++ ) {

            // 나에게 필요한 값.
            // e.g. target이 9고, 들어온 값이 3이라면 나에겐 6이 필요함.
            int temp = target - nums[i];

            // 혹시 저장한 맵 중에 6이 있니?
            if( map.containsKey ( temp )) {
                return new int[] { i, map.get( temp ) };
            }

            // 일치하는 게 없어? 그럼 담자. 나중에 필요할 때 찾아가도록...
            // 인덱스를 output으로 줄 거니까 key가 수, value가 인덱스(주소).
            map.put( nums[i], i );
        }

        return null;
    }
}

