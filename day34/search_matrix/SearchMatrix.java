package day34.search_matrix;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rowCount = matrix.length;    // 행(줄)의 개수
        int colCount = matrix[0].length; // 열(칸)의 개수

        // 2차원 표를 1차원 배열로 상상하여 포인터 설정
        int left = 0;
        int right = rowCount * colCount - 1;

        while( left <= right ) {
            
            // 1차원 기준 중간 인덱스
            int mid = left + (right - left) / 2;

            // 1차원 인덱스를 2차원 좌표(row, col)로 변환 (반드시 열의 개수로 나누기)
            int row = mid / colCount; 
            int col = mid % colCount;

            // 변환된 좌표로 중간값 추출
            int midMatrix = matrix[row][col];

            // 타겟 비교 및 탐색 범위 축소
            if( midMatrix == target ) {
                return true; 
            } else if ( midMatrix < target ) {
                left = mid + 1; // 타겟이 더 크면 왼쪽 절반 폐기
            } else {
                right = mid - 1; // 타겟이 더 작으면 오른쪽 절반 폐기
            }
        }

        return false; // 끝까지 없으면 false
    }
}