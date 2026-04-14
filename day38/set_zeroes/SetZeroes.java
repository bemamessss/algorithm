package day38.set_zeroes;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length; // 행
        int n = matrix[0].length; // 열

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for( int i = 0 ; i < m ; i ++ ) {
            for( int j = 0 ; j < n ; j ++ ) {
                if( matrix[i][j] == 0 ) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

         for( int i = 0 ; i < m ; i ++ ) {
            for( int j = 0 ; j < n ; j ++ ) {
                if( row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }       
    }
}