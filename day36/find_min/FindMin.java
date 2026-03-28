package day36.find_min;

public class FindMin {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // left = right가 되면 그게 최솟값이다.
        while( left < right ) {
            int mid = left + ( right - left ) / 2;

            // 어차피 최솟값 찾을 거라 오른쪽만 비교하면 됨.
            // 중간값이 오른쪽보다 크면? 오른쪽 어딘가에 최소값이 있다.
            if( nums[mid] > nums[right] ) {
                left = mid + 1;
            } else {
                // 최소값이 내 위치(mid)일 수도 있으니까 right에다가 mid를 보존해야 함. mid - 1 금지.
                right = mid;
            }
        }

        return nums[left];
    }
}