package day35.min_eating_speed;

public class MinEatingSpeed {
    
    public int minEatingSpeed(int[] piles, int h) {

        // 리턴값: 모든 바나나를 h시간 내에 먹기 위한 최소한의 속도(k)

        // 코코가 먹을 수 있는 속도 k의 범위
        int left = 1; // 최소 속도 (한 시간에 1개)
        int right = 0; // 최대 속도 (제일 큰 더미 바나나 개수)

        // 더미 속 제일 큰 개수만큼은 1시간 동안 먹으니까 큰 범위 찾기.
        for( int pile : piles ) {
            right = Math.max( right, pile );
        }

        int result = right; // 최종 답은 최대한 작아야 하므로 최대치를 넣음.

        while( left <= right ) {
            // 테스트해 볼 중간 속도
            int mid = (left + right) / 2;

            // 입력값이 너무 크면 덧셈할 때 int가 터질 수 있다 ➔ long을 쓰자!
            // piles [805306368,805306368,805306368]
            // h 1000000000 넣으니까 실패함...
            long total = 0;

            // 예를 들어 한 더미에 7개 있고, mid가 3이면 '2시간' 동안 6개 먹고, 나머지 1개를 '1시간' 먹는다.
            // 더미 하나 다 먹으면 더 먹을 수 있어도 대기해야 하니까 몫으로 나누고 남은 나머지는 무조건 1시간 써야 함.
            for( int pile : piles ) {
                int hour = pile / mid; // e.g. 7/3 = 2시간
                if( pile % mid != 0 ) { // 나머지가 있으면 1시간 더 추가해야 함.
                    hour++;
                }
                total += hour;
            }

            // 제한 시간 이내로 먹을 수 있다면? 일단 답 후보인데 더 느리게 먹어도 가능한지 시도해 보자.
            if( total <= h ) {
                result = mid; // 속도 담는 거니까 mid
                // left = mid + 1; // 기준값 h와 가까워지는 값을 찾는 게 아님!! 더 느리려면 오른쪽을 날려야 함.
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}