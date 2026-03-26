package day34.search_matrix_2;

public class SearchMatrix2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowCount = matrix.length; // 총 몇 줄?
        int colCount = matrix[0].length; // 한 줄에 몇 개?
        
        // 1. 모든 행을 하나씩 순회
        for( int i = 0 ; i < rowCount ; i ++ ) {

            // 2. 각 행(row)은 정렬되어 있으므로 이진 탐색 가능
            int left = 0;
            int right = colCount - 1;

            while( left <= right ) {
                int mid = (left + right) / 2;
                int midVal = matrix[i][mid]; // i번째 행의 중간값

                if( midVal == target ) {
                    return true;
                } else if ( midVal < target ) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}