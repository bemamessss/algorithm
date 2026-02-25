package day13.happy_number;
import java.util.*;

public class HappyNumber {

    public boolean isHappy(int n) {
        // 각 자리를 똑 떼서 제곱해서 더한다. 최종적으로 1이 나와야 함.

        // 같은 수가 루프 안에서 두 번 나오면 계속 반복될 테니 false로 종료해 줘야 함. 그걸 위한 해시셋 방명록.
        Set<Integer> set = new HashSet<>();

        // 중복수(이미 나온 값이 또 나옴)이 아니면서 n이 1이 아니면 계속 반복하자.
        while( !set.contains(n) && n != 1 ) {
            set.add(n);
            n = this.makeNum(n);
        }

        return ( n == 1 );
    }

    private int makeNum( int n ) {
        // 일의 자리수 떼기.
        int sum = 0;

        // n이 한자리수일 때 n/10을 하면 0이므로 그때까지 반복한다. 3자리, 4자리일 수도 있으므로 루프 필요.
        while( n > 0 ) {
            int m = n % 10; // 끝자리만 떼어내기. (나머지) (e.g. 19 -> 9, 82 -> 2)
            sum += m * m; 
            n = n / 10; // 끝자리만 날리기. (e.g. 13 -> 1, 8 -> 0)
        }

        return sum;

    }
}