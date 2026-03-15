package day26.move_zeroes;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // 0이 아닌 값이 들어오면 덮어 써질 자리
        int p = 0;

        for( int i = 0 ; i < nums.length ; i ++ ) {
            if( nums[i] != 0 ) {
                nums[p] = nums[i];
                p++;
            }
        }

        while( p < nums.length ) {
            nums[p] = 0;
            p++;
        }
    }
}