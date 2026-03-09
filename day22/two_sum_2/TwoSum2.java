package day22.two_sum_2;

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        // Your solution must use only constant extra space. => hashMap X

        int left = 0;
        int right = numbers.length - 1;

        while( left < right ) {
            int sum = numbers[left] + numbers[right];
            if( sum == target ) {
                return new int[]{ left + 1, right + 1 };
            } else if ( sum < target ) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}