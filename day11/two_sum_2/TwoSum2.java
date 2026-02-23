package day11.two_sum_2;

public class TwoSum2 {
    
    public int[] twoSum(int[] numbers, int target) {
        
        // Your solution must use only constant extra space. => 공간 복잡도 O(1) 구현 필요하므로 해시맵 X
        // 제일 작은 값(left)와 제일 큰 값(right)을 더하여 조절.
        int left = 0;
        int right = numbers.length - 1;
        
        // 정렬이 되어 있으므로 무조건 오른쪽 값이 더 크다. left > right까지 돌면 조건을 충족하는 짝이 없는 것.
        while( left < right ) {
            int sum = numbers[left] + numbers[right];

            if( sum == target ) {
                return new int[]{ left + 1, right + 1 };
            // 합계가 목표값보다 더 작다면? 지금보다 값을 키워야 한다.
            } else if( target > sum ) {
                left++;
            // 합계가 목표값보다 더 크다면? 지금보다 값을 줄여야 한다.    
            } else if( target < sum ) {
                right--;
            }
        }

        return new int[]{ -1, -1 };
    }
}