package day21.next_greater_element;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // 1. 대기실(스택)과 정답 사전(해시맵) 준비
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        // 2. nums2를 돌며 짝꿍 사전 완성하기
        for( int num2 : nums2 ) {
            
            // [핵심] 꼭대기 수보다 내가 크면? 대기자들 와르르 빼서 짝지어줌
            while( !stack.isEmpty() && stack.peek() < num2 ) {
                map.put( stack.pop(), num2 );
            }
            // 나도 일단 대기실 입장
            stack.push(num2);
        }

        // 3. nums1 돌면서 정답 배열 채우기
        int[] result = new int[nums1.length];
        
        for( int i = 0 ; i < result.length ; i ++ ) {
            // 사전에 있으면 주고, 없으면 -1
            result[i] = map.getOrDefault( nums1[i], -1 );
        }

        return result;
    }
}