

# 📚 Coding Test Study - Day 3

## 📋 오늘의 문제: [LeetCode #121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

### 1. 문제 핵심 요약

* **목표**: 주식 가격 배열 `prices`가 주어졌을 때, 단 한 번의 거래(한 번 사고 한 번 팔기)로 얻을 수 있는 **최대 이익**을 계산.
* **조건**:
* 반드시 주식을 산 이후의 날짜에만 팔 수 있음.
* 이익을 낼 수 없는 경우에는 `0`을 반환.



---

### 2. 알고리즘 포인트: **Greedy (One Pass)**

#### ❌ Brute Force (이중 반복문)

* 모든 사고파는 경우의 수를 계산하면 $O(n^2)$이 되어 데이터가 많을 때 **Time Limit Exceeded (TLE)** 발생.

#### ✅ Greedy - **과거의 최솟값을 기억하며 전진**

* 배열을 단 한 번만 순회하며(), **"지금까지 중 가장 쌌던 가격"**을 계속 업데이트함.
* **로직**:
1. `minPrice`: 지금까지 본 가격 중 가장 낮은 가격을 저장 (초기값: `Integer.MAX_VALUE`).
2. `maxProfit`: 현재 가격에서 `minPrice`를 뺀 값이 기존 `maxProfit`보다 크면 갱신 (초기값: `0`).


* **시간 복잡도**:  (배열을 한 번만 순회)
* **공간 복잡도**:  (변수 두 개만 사용)

---

### 3. Java 문법 & 활용 포인트

#### 🔹 `Integer.MAX_VALUE` 활용

* 최솟값을 찾기 위한 비교 대상으로 자바에서 표현 가능한 가장 큰 정수값을 초기값으로 설정.
* 어떤 가격이 들어오더라도 첫 번째 비교에서 바로 최솟값으로 갱신되도록 보장함.

#### 🔹 `Math.min()` & `Math.max()`

* `if` 문을 사용하는 대신 `Math` 클래스의 메서드를 사용하여 코드를 더 간결하고 가독성 있게 작성.
```java
minPrice = Math.min(minPrice, price);
maxProfit = Math.max(maxProfit, price - minPrice);

```



#### 🔹 향상된 for문 (Enhanced For-Loop)

* 인덱스(`i`)가 필요 없고 값만 꺼내 쓰면 되는 상황이므로 `for (int price : prices)` 형식을 사용하여 간결함 유지.

---

### 4. 오늘의 깨달음 (Key Takeaways)

1. **순서의 중요성**: "미래의 가격에서 과거의 최솟값을 뺀다"는 개념이 핵심이므로, 루프를 돌며 **최솟값을 먼저 갱신**하고 그 뒤에 이익을 계산하는 순서가 논리적으로 타당함.
2. **단일 순회의 힘**: $O(n^2)$을 $O(n)$으로 줄이는 것만으로도 성능이 비약적으로 향상됨을 이해함.
3. **초기값 설정**: 최솟값 변수에는 아주 큰 값을, 최댓값 변수에는 아주 작은 값(혹은 문제 조건에 따른 0)을 넣는 습관이 중요함.

---

### 5. 제출 코드 (Java)

```java
class Solution {
    public int maxProfit(int[] prices) {
        // 엣지 케이스 처리: 가격 정보가 없거나 하루치뿐이면 이득을 볼 수 없음
        if (prices == null || prices.length == 0) return 0;
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // 1. 지금까지 중 최저가인가? 갱신!
            minPrice = Math.min(minPrice, price);
            
            // 2. 오늘 팔면 최대 이익인가? 갱신!
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
