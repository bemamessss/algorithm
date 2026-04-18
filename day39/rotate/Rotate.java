package day39.rotate;

public class Rotate {
    public void rotate(int[][] matrix) {
        // 대각선으로 접은 후 세로로 접으면 시계 모양으로 돌아감. (가로로 접으면 반시계)

        int n = matrix.length;

        // 대각선 반전
        for( int i = 0 ; i < n ; i ++ ) {
            // 바꾼 걸 또 바꾸면 안 되므로 j = i
            for( int j = i ; j < n ; j ++ ) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i]; // 대각선 데칼코마니
                matrix[j][i] = temp;
            }
        }

        // 세로 반전
        for( int i = 0 ; i < n ; i ++ ) {
            // 세로 절반으로 접기. 반까지만 오고 멈춰야 함.
            for( int j = 0 ; j < n / 2 ; j ++ ) {
                int temp = matrix[i][j];
                // 왼쪽에 오른쪽 넣기.
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}