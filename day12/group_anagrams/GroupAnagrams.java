package day12.group_anagrams;

import java.util.*;

public class GroupAnagrams {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // key : 정렬한 단어, value : 원본 단어 List
        Map<String, List<String>> map = new HashMap<>();

        for( String str : strs ) {
            // 1. 애너그램들을 정렬해서 한 단어로 만든 후 키로 쓴다.
            char[] cArray = str.toCharArray();
            Arrays.sort(cArray);
            String key = new String(cArray);
            
            // 2. computeIfAbsent: 맵에 키가 없으면 함수 실행 후 반환, 있으면 기존 value 반환
            // 반환된 List<String>에 바로 원본 단어(str)를 추가(.add)
            map.computeIfAbsent( key, k -> new ArrayList<>() ).add(str);
        }

        // 3. 반환은 value만 해 주면 됨. 
        // Collection<List<String>> 형태를 요구 사항인 List<List<String>>으로 변환.
        return new ArrayList<>(map.values());
    }
}