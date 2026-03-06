package day20.remove_dupl;

public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();

        for( char c : s.toCharArray() ) {
            int length = sb.length();
            if( length > 0 && sb.charAt( length - 1 ) == c ) {
                // for문 안에서 substring 사용 금지
                sb.deleteCharAt( length - 1 );
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}