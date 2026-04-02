package day37.search_range;

public class SearchRange {
    
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        // 왼쪽 끝점 찾기.
        result[0] = this.findPosition( nums, target, true );

        // 왼쪽도 못 찾았으면 그냥 return.
        if( result[0] == -1 ) return result;

        // 오른쪽 끝점 찾기.
        result[1] = this.findPosition( nums, target, false );

        return result;
    }

    private int findPosition( int[] nums, int target, boolean isLeft ) {
        int left = 0;
        int right = nums.length - 1;
        int position = -1;

        while( left <= right ) {
            int mid = (left + right) / 2;

            if( nums[mid] == target ) {
                // 일단 저장은 하고 더 탐색하기.
                position = mid;
                if( isLeft ) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if ( nums[mid] < target ) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return position;
    }
}