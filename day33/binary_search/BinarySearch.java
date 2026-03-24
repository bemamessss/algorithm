package day33.binary_search;

public class BinarySearch {
    
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while( left <= right ) {
            mid = (left + right) / 2;

            if( nums[mid] == target ) {
                return mid;
            // 타겟이 반보다 클 때는 왼쪽 버리기.
            } else if ( nums[mid] < target ) {
                left = mid + 1;
            // 작을 때는 오른쪽 버리기.    
            } else {
                right = mid - 1;
            }
        }

        // 다 돌아도 return 못 했으면 없는 거.
        return -1;
    }
}