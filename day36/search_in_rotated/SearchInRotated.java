package day36.search_in_rotated;

public class SearchInRotated {
    
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 반으로 쪼개서 좌우를 검사하면 둘 중 한쪽은 정상적으로 정렬돼 있음
        while( left <= right ) {
            int mid = left + (right - left) / 2;

            if( nums[mid] == target ) return mid;

            // 반 잘라 봤더니 중간값보다 왼쪽 값이 작을 때? 왼쪽이 정상 정렬.
            // = 필요. 배열 2개 남았을 때 left=mid가 되므로.
            if( nums[left] <= nums[mid] ) {
                // target 값이 왼쪽 범위 내에 있을 때? 오른쪽 날리기.
                if( nums[left] <= target && target < nums[mid] ) {
                    right = mid - 1;
                // 없으면 오른쪽 검사해야 함.    
                } else {
                    left = mid + 1;
                }
            // 오른쪽이 정상 정렬.    
            } else {
                if( target > nums[mid] && target <= nums[right] ) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}