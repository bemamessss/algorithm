

# 📚 Coding Test Study - Day 3

## 📋 오늘의 문제: [LeetCode #122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

### 1. 문제 핵심 요약

* **목표**: 여러 번의 주식 거래를 통해 얻을 수 있는 **최대 이익**을 계산.
* **조건**:
* 주식을 **여러 번** 사고팔 수 있음 (무제한 거래).
* 단, 새로운 주식을 사려면 반드시 기존 주식을 먼저 팔아야 함 (동시 보유 불가).
* 이익이 없는 경우 `0`을 반환.



---

### 2. 알고리즘 포인트: **Greedy (상승분 누적)**

#### ❌ Peak-Valley 탐색 (불필요하게 복잡한 방식)

* 가장 낮은 지점과 높은 지점을 세트로 찾으려고 하면 하락장이 섞여 있을 때 조건 분기가 매우 복잡해짐.

#### ✅ Greedy - **모든 상승 마디를 더하며 전진**

* 배열을 단 한 번만 순회하며, **"어제보다 오늘 올랐다면"** 그 차익을 모두 합산함.
* **로직**:
1. `totalProfit`: 누적된 총 이익을 저장 (초기값: `0`).
2. 반복문: 두 번째 날(`i=1`)부터 탐색하며 오늘 가격과 어제 가격을 비교.
3. **비교**: `prices[i] > prices[i-1]` 이면, 그 차액을 `totalProfit`에 더함.


* **시간 복잡도**:  (배열을 한 번만 순회)
* **공간 복잡도**:  (변수 하나만 사용)

---

### 3. Java 문법 & 활용 포인트

#### 🔹 반복문 시작 인덱스 설정

* 오늘과 어제(`i-1`)를 비교해야 하므로 `int i = 1`부터 시작하는 것이 핵심.
* 인덱스 `0`부터 시작할 경우 `i-1` 참조 시 `ArrayIndexOutOfBoundsException`이 발생할 수 있음.

#### 🔹 복합 대입 연산자 (`+=`) 활용

* `totalProfit = totalProfit + (price[i] - price[i-1]);`을 간결하게 표현.
* `totalProfit += prices[i] - prices[i-1];`

---

### 4. 오늘의 깨달음 (Key Takeaways)

1. **그리디의 정석**: 큰 상승 폭 하나를 찾는 것보다, 작은 상승 마디들을 모두 더하는 것이 결국 전체 최대 수익과 같다는 수학적 원리를 이해함.
2. **단순화의 힘**: "언제 사서 언제 팔지"를 고민하는 대신 "내일이 오늘보다 비싼가?"라는 단순한 조건으로 Medium 난이도 문제를 해결함.
3. **121번과의 차이**: 1회 거래(121번)는 최솟값 갱신이 핵심이고, 무제한 거래(122번)는 상승분 누적이 핵심임을 명확히 구분함.

---

### 5. 제출 코드 (Java)

```java
class Solution {
    public int maxProfit(int[] prices) {
        // 엣지 케이스 처리: 가격 정보가 없거나 하루치뿐이면 거래 불가
        if (prices == null || prices.length < 2) return 0;
        
        int totalProfit = 0;

        // 두 번째 날부터 탐색 시작
        for (int i = 1; i < prices.length; i++) {
            // 오늘 가격이 어제보다 높다면 그 차액을 무조건 더함
            if (prices[i] > prices[i - 1]) {
                totalProfit += (prices[i] - prices[i - 1]);
            }
        }

        return totalProfit;
    }
}

