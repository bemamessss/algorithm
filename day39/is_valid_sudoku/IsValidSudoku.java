package day39.is_valid_sudoku;

public class IsValidSudoku {
    
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowCheck = new boolean[9][9]; // 가로 중복 검사
        boolean[][] colCheck = new boolean[9][9]; // 세로 중복 검사
        boolean[][] boxCheck = new boolean[9][9]; // 3 * 3 박스 중복 검사

        for( int i = 0 ; i < 9 ; i ++ ) {
            for( int j = 0 ; j < 9 ; j ++ ) {

                char current = board[i][j];

                if( current == '.' ) {
                    continue;
                }

                // 인덱스는 0부터 시작하므로 1~9를 표현하려면 -1 뺴 준다.
                int num = current - '1';

                int box = (i / 3) * 3 + (j / 3); // 4번 칸이라면 크게 보면 2행 1열이니까 3 + 1

                // 이미 해당 가로줄, 세로줄, 박스에 해당 숫자가 있으면? 유효하지 않은 스도쿠.
                if( rowCheck[i][num] || colCheck[j][num] || boxCheck[box][num] ) {
                    return false;
                }

                rowCheck[i][num] = true;
                colCheck[j][num] = true;
                boxCheck[box][num] = true;
            }
        }

        return true;
    }
}