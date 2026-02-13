# 📚 Coding Test Study - Day 4

📋 **오늘의 문제: LeetCode #217. Contains Duplicate**

## 1. 문제 핵심 요약

- **목표**: 정수 배열 `nums`가 주어졌을 때, 어떤 값이든 **최소 두 번 이상 나타나면 `true`**, 모든 요소가 서로 다르면 `false`를 반환.
- **조건**:
    - 배열의 길이는 최대 $10^5$.
    - 시간 복잡도를 최소화하여 중복을 찾아내는 것이 관건.

## 2. 알고리즘 포인트: Hash Set (Space-Time Tradeoff)

- **❌ Brute Force (이중 반복문)**
    - 모든 쌍을 비교 ($O(n^2)$). 배열 크기가 $10^5$이므로 시간 초과(TLE) 가능성 높음.
- **🔺 Sorting (정렬)**
    - 배열을 정렬한 뒤 인접한 두 수가 같은지 확인.
    - 시간 복잡도: $O(n \log n)$, 공간 복잡도: $O(1)$ (추가 공간을 안 쓸 때 유리).
- **✅ Hash Set (오늘의 치트키)**
    - **전략**: "한 번 본 숫자는 주머니(Set)에 넣어두고, 다음에 또 나오는지 감시한다."
    - **로직**: 데이터를 하나씩 읽으며 `HashSet`에 저장. 이미 있는 데이터라면 즉시 `true`.
    - **시간 복잡도**: **$O(n)$** (배열을 단 한 번만 순회).
    - **공간 복잡도**: **$O(n)$** (데이터 저장을 위한 추가 메모리 사용).

## 3. Java 문법 & 활용 포인트

🔹 **HashSet<Integer>와 제네릭(Generics)**

- `Set<Integer> set = new HashSet<>();` 처럼 인터페이스(`Set`)를 타입으로 선언하고 실제 구현체(`HashSet`)를 할당하는 것이 객체지향 관점에서 더 유연함.
- `int` 기본형은 직접 담을 수 없어 내부적으로 `Integer` 객체로 **Autoboxing**됨.

🔹 **set.add()의 리턴값 활용**

- `set.add(value)`는 단순히 값을 넣는 동작만 하는 게 아니라, **성공 여부를 boolean으로 반환**함.
    - 값이 없어서 새로 추가하면 `true` 반환.
    - 이미 값이 있어서 추가에 실패하면 `false` 반환.
- 이를 이용하면 `contains`를 따로 호출하지 않아도 한 줄로 중복 체크 가능.

## 4. 오늘의 깨달음 (Key Takeaways)

- **공간을 주고 시간을 산다**: 메모리($O(n)$)를 조금 더 쓰더라도 Hash 구조를 활용하면 실행 속도를 $O(n^2)$에서 $O(n)$으로 획기적으로 줄일 수 있다.
- **도구 선택이 전부다**: "중복 제거"나 "존재 여부 확인" 키워드가 나오면 고민 없이 `HashSet`을 꺼내 들자.
- **가장 짧은 코드가 항상 최선은 아니다**: `set.add()` 리턴값을 쓰는 게 효율적이지만, `set.contains()`를 먼저 쓰는 게 로직의 가독성 면에서는 더 직관적일 수 있다. 상황에 맞게 선택하자.

## 5. 모범 답안 (Best Practice)

가장 효율적이고 깔끔한 코드입니다. `add()`의 리턴값을 활용해 연산 횟수를 최소화했습니다.

`class Solution {
    public boolean containsDuplicate(int[] nums) {
        // 1. 초기 용량을 설정하여 리사이징 방지 (선택사항이지만 성능에 도움)
        Set<Integer> set = new HashSet<>(nums.length);

        // 2. 단일 반복문으로 탐색
        for (int num : nums) {
            // add 시도: 이미 존재해서 false가 리턴되면 바로 true 반환
            if (!set.add(num)) {
                return true;
            }
        }

        // 3. 끝까지 중복이 없으면 false
        return false;
    }
}`

## 🔓 내 답안 (사고 과정)

직접 작성한 코드입니다. 예외 처리(`null` 체크)와 명확한 존재 확인(`contains`) 로직이 돋보입니다.

Java

`class Solution {
    public boolean containsDuplicate(int[] nums) {
        // #1. 엣지 케이스 처리 (방어적 프로그래밍)
        if( nums == null || nums.length == 0 ) return false;

        // #2. 주머니(Set) 생성
        Set<Integer> set = new HashSet<>();

        for( int num : nums ) {
            // #3. 이미 본 숫자인지 확인
            if( set.contains( num ) ) {
                return true;
            }
            // #4. 처음 보는 숫자면 저장
            set.add( num );
        }

        return false;
    }
}

/* [Dry Run 주석]
   입력: [1, 2, 3, 1]
   1회: 1 확인 -> set에 없음 -> set:{1}
   2회: 2 확인 -> set에 없음 -> set:{1, 2}
   3회: 3 확인 -> set에 없음 -> set:{1, 2, 3}
   4회: 1 확인 -> set에 있음! -> return true
*/`

## 🛠️ 추가 학습: 언제 Set을 쓸까? (Cheat Sheet)

1. **중복(Duplicate)**: "중복이 있는가?", "중복을 제거하라."
2. **존재 여부(Existence)**: "이 값이 이전에 나온 적이 있는가?", "특정 리스트에 이 값이 포함되어 있는가?"
3. **교집합/합집합**: 두 데이터 그룹 간의 겹치는 요소를 찾을 때.
4. **고유값 추출**: 전체 데이터 중 유니크한 값이 몇 개인지 셀 때 (`set.size()`).

---