package day26.remove_dupe_2;

public class RemoveDupe2 {
    public int removeDuplicates(int[] nums) {

        if( nums.length <= 2 ) return nums.length;

        // 어차피 0, 1 인덱스까지는 중복 가능하므로 2 인덱스부터 검사하면 된다. 
        int p = 2;
        
        for( int i = 2 ; i < nums.length ; i ++ ) {

            // 두개 이전의 값이랑 다르면 덮어쓸수 있도록 위치를 기록한 p에다가 값을 덮어 쓴다. 그리고 p는 다음 자리로 이동.
            if( nums[i] != nums[p-2] ) {
                nums[p] = nums[i];
                p++;
            }
            // 두개 이전의 값이랑 같으면 중복임. 

        }

        return p;
    }
}