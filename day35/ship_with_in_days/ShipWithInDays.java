package day35.ship_with_in_days;

public class ShipWithInDays {
    
    public int shipWithinDays(int[] weights, int days) {
        
        // 1. 탐색 범위 설정 (배의 최소/최대 용량)
        int left = 0;
        int right = 0;
        
        for (int weight : weights) {
            left = Math.max(left, weight); // 제일 무거운 짐 1개는 무조건 실어야 함
            right += weight;               // 하루 만에 다 보내려면 다 합친 무게 필요
        }
        
        int result = right; // 최소 용량 찾기. 초기값은 최대로 세팅.

        // 2. 매개 변수 탐색 (Parametric Search) 시작
        while (left <= right) {
            int mid = left + (right - left) / 2; // 테스트해 볼 배의 용량
            
            int days_needed = 1; // 배송에는 무조건 1일 이상 소요됨
            int current_weight = 0; // 내 눈앞에 정박해 있는 현재 배에 실린 무게
            
            // 3. 물류센터 짐 싣기 시뮬레이션
            for (int weight : weights) {
                // 이번 짐을 실었을 때 배 용량을 초과한다면?
                if (current_weight + weight > mid) {
                    days_needed++;           // "배 출발!" (다음 날로 넘어감)
                    current_weight = weight; // "빈 새 배에 방금 막힌 짐부터 실어!" (덮어쓰기)
                } else {
                    // 용량이 넉넉하다면?
                    current_weight += weight;// "계속 실어!" (누적)
                }
            }
            
            // 4. 탐색 방향 결정 (가장 작은 '최소 용량'을 찾아라!)
            if (days_needed <= days) {
                // 기한 내 배송 성공(S) -> 배 용량을 더 줄여도 되는지 확인 (우측 폐기)
                result = mid;
                right = mid - 1;
            } else {
                // 기한 초과(F) -> 배가 너무 작아서 지연됨. 용량 늘려야 함 (좌측 폐기)
                left = mid + 1;
            }
        }
        
        return result;
    }
}