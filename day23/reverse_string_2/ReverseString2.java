package day23.reverse_string_2;

public class ReverseString2 {

    public String reverseStr(String s, int k) {

        // k = 묶음 앞에 있는 글자 중 몇 개를 뒤집을지, 2*k = 하나의 묶음, 즉 어디에서 자를지
        char[] arr = s.toCharArray();
        int n = arr.length;

        // 문자열의 길이만큼 돌되, 2k가 하나의 묶음이니까 k*2만큼씩 증가한다.
        for( int i = 0 ; i < n ; i += k * 2 ) {

            // 시작점
            int left = i;
            // 끝점
            // i + k - 1 : left 4면서 4, 5(k=2) 두 개를 뒤집고 싶으면 right는 6이 아니라 5여야 하므로 -1.
            // n - 1 : 인덱스이므로 길이보다는 -1 (실제 문자열 제일 끝(n-1)을 넘어가면 안 됨)
            int right = Math.min( i + k - 1, n - 1 );

            // 이제 해당 포인터 사이에 있는 애들은 다 뒤집어 준다.
            while( left < right ) {
                char tempLeft = arr[left];
                arr[left] = arr[right];
                arr[right] = tempLeft; 

                left++;
                right--;
            }
        }

        // 🚨 [수정됨] arr.toString()은 주소값을 반환하므로 new String()으로 감싸서 문자열로 변환!
        return new String(arr);
    }
}
