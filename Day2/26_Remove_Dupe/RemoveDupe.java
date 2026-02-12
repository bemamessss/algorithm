public class Remove_Dupe {
    
    public int removeDuplicates(int[] nums) {
        // 비교하다가 다른애가 있으면 1번쨰 인덱스부터 값을 덮어씌우자. 어차피 0번째 인덱스는 사실상 고정.

        int point = 1; // 몇 번째 자리까지 채웠니?
        for( int i = 1 ; i < nums.length ; i ++ ) {
            
            // 0, 0, 1이라 치면 1idx와 2idx 값이 다르니, 2idx를 0idx 다음 값에 채워 넣는다.
            if( nums[i] != nums[i - 1] ) {
                nums[point] = nums[i];
                point++;
            };
        }

        return point;
    }
}

// case 1
// 0,0,1
// i = 1 : 0 0
// i = 2: 0 0 1 => 다름! 첫 번째 다음 자리(idx=1)에 넣기.