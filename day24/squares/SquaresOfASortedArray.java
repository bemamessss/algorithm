package day24.squares;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        // O(n)으로 해결: 양 끝에서 중앙으로 좁혀오기
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];

        // 가장 큰 값부터 채우기 위해 인덱스를 마지막부터 시작
        int index = right;

        while( left <= right ) {
            int doubleLeft = nums[left] * nums[left];
            int doubleRight = nums[right] * nums[right];

            if( doubleLeft > doubleRight ) {
                result[index] = doubleLeft;
                left++;  // 왼쪽 값이 컸으므로 왼쪽 포인터 이동
            } else {
                result[index] = doubleRight;
                right--; // 오른쪽 값이 컸으므로 오른쪽 포인터 이동
            }
            // 한 칸 채웠으니 정답지 인덱스 앞으로 한 칸 이동
            index--;
        }

        return result;        
    }
}