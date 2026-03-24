package day33.search_insert;

public class SearchInsert {
    
    public int searchInsert(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        // left와 right가 교차하기 전까지 반복 (이진 탐색 기본 틀)
        while( left <= right ) {
            
            mid = left + (right - left) / 2; // 오버플로우 방지 중앙값 계산

            // 1. 찾은 경우: 해당 인덱스 바로 반환
            if( nums[mid] == target ) {
                return mid;
                
            // 2. 타겟이 더 클 때: 오른쪽 절반 탐색 (왼쪽 버림)
            } else if ( nums[mid] < target ) {
                left = mid + 1;
                
            // 3. 타겟이 더 작을 때: 왼쪽 절반 탐색 (오른쪽 버림)
            } else {
                right = mid - 1;
            }
        }

        // 4. 끝까지 못 찾은 경우: 
        // left는 '타겟보다 처음으로 큰 값의 인덱스' 혹은 '배열의 맨 끝'에 멈춰있음.
        // 즉, 타겟이 삽입되어야 할 정확한 위치임.
        return left;
    }
}