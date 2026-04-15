package day38.spiral_order;

import java.util.*;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];

        // 우 -> 하 -> 좌 -> 상
        int[] dr = {0, 1, 0, -1}; // 위아래
        int[] dc = {1, 0, -1, 0}; // 좌우

        int r = 0; // 출발지 행 (0층)
        int c = 0; // 출발지 열 (0번방)
        int dir = 0; // 출발지 0: 오른쪽

        for( int i = 0 ; i < m * n ; i ++ ) {
            result.add( matrix[r][c] );
            visited[r][c] = true;

            // 미리 계산
            int nextR = r + dr[dir];
            int nextC = c + dc[dir];

            if( nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || visited[nextR][nextC] ) {
                // 방향 틀기
                dir = (dir + 1) % 4;

                nextR = r + dr[dir];
                nextC = c + dc[dir];
            }

            r = nextR;
            c = nextC;
        }

        return result;
    }
}