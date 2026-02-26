package day14.intersection;
import java.util.*;

public class InterSectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        if( nums1.length == 0 || nums2.length == 0 ) return new int[]{};

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for( int num1 : nums1 ) {
            // 중복 없이 추가
            set1.add( num1 );
        }

        for( int num2 : nums2 ) {
            if( set1.contains( num2 ) ) {
                set2.add( num2 );
            }
        }

        // set 크기는 size()
        int[] result = new int[set2.size()];
        int i = 0;

        // set은 인덱스가 없어 하나하나 못 뽑으니 그냥 향상된 for문 쓰자.
        for( int num2 : set2 ) {
            result[i] = num2;
            i++;
        }

        return result;

    }
}