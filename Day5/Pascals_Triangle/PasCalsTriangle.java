package Day5.Pascals_Triangle;
import java.util.*;

public class PasCalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for( int i = 0 ; i < numRows ; i ++ ) {
            // 각 층을 저장할 리스트.
            List<Integer> row = new ArrayList<>();

            // e.g. i = 1이면 j에는 2개 담길 수 있음.
            for( int j = 0 ; j <= i ; j ++) {

                // 제일 앞이나 뒤는 다 1로 채운다.
                if( j == 0 || j == i ) {
                    // 어차피 순서대로 들어오니까 마지막 1도 가운데 다 채우고 들어옴.
                    row.add(1);
                // 1층은 무조건 if문 탈 테니까 else로 들어올 일 없음.    
                } else {
                    // List는 get으로 꺼낸다.
                    List<Integer> preRow = result.get(i-1);
                    int value = preRow.get(j-1) + preRow.get(j);
                    row.add(value);
                }
            }

            result.add(row);
        }

        return result;
    }
}