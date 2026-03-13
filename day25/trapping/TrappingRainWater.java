package day25.trapping;

public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;

        while( left < right ) {
            // 왼쪽이 낮으면 최대 높이니까 오른쪽으로 이동.
            if( height[left] < height[right] ) {
                // 높거나 같으면 물 못 고임.
                if( height[left] >= leftMax ) {
                    leftMax = height[left];
                // 최대보다 낮으면 물이 고일 수 있음.    
                } else {
                    sum += leftMax - height[left];
                }


                left++;
            }

            // 오른쪽이 낮으면 왼쪽으로 이동.
            else {
                if( height[right] >= rightMax ) {
                    rightMax = height[right];
                } else {
                    sum += rightMax - height[right];
                }

                right--;
            }
        }

        return sum;
    }
}