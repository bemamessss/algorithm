package day14.intersection2;
import java.util.*;

public class InterSectionOfTwoArrays2 {
    
    public int[] intersect(int[] nums1, int[] nums2) {
        // [엣지 케이스] 둘 중 하나라도 빈 배열이면 0칸짜리 배열 리턴
        if( nums1.length == 0 || nums2.length == 0 ) return new int[0];

        // 1. 빈도수 장부 만들기 (Key: 숫자, Value: 등장 횟수)
        Map<Integer, Integer> map = new HashMap<>();
        for( int num1 : nums1 ) {
            map.put( num1, map.getOrDefault( num1, 0 ) + 1 );
        }

        // 2. 겹치는 숫자 모으기 (몇 개일지 모르니 가변 리스트 사용)
        List<Integer> resultList = new ArrayList<>();
        for( int num2 : nums2 ) {
            // [핵심 방어 로직] 맵에 존재하고 && 재고가 1개 이상일 때만!
            // (주의: containsKey 없이 get > 0만 쓰면 NullPointerException 발생 위험)
            if( map.containsKey( num2 ) && map.get( num2 ) > 0 )  {
                resultList.add( num2 );
                map.replace( num2, map.get( num2 ) - 1 ); // 재고 1개 차감
            }
        }

        // 3. ArrayList -> int[] 배열로 변환
        int[] resultArray = new int[resultList.size()];
        int index = 0;
        
        for( int num : resultList ) {
            // 후위 증감 연산자를 활용한 1줄짜리 깔끔한 삽입
            resultArray[index++] = num; 
        }

        return resultArray;
    }
}