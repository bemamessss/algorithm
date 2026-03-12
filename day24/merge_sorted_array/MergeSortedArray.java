package day24.merge_sorted_array;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 앞부분부터 쓰면 덮어써지니까 뒤(큰수)부터 채우자.
        int index1 = m - 1;
        int index2 = n - 1;
        int p = nums1.length - 1;

        // 1. 두 배열의 숫자를 비교하며 더 큰 수를 뒤에서부터 채우기
        while( index1 >= 0 && index2 >= 0 ) {
            if( nums1[index1] > nums2[index2] ) {
                nums1[p] = nums1[index1--];
            } else {
                // 값이 같을 때(==)도 이쪽을 타서 index2를 먼저 처리함
                nums1[p] = nums2[index2--];
            }
            p--;
        }

        // 2. [중요] nums2가 아직 남았으면? nums1의 앞부분으로 옮겨야 함
        // index1이 남은 경우는 이미 nums1의 제자리에 있으므로 처리 불필요!
        while( index2 >= 0 ) {
            nums1[p] = nums2[index2--];
            p--;
        }
    }
}