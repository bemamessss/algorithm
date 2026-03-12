package day24.backspace_string_compare;

public class BackspaceStringCompare {
    
    public boolean backspaceCompare(String s, String t) {
        return formatString(s).equals( formatString(t) );
    }


    private String formatString( String tget ) {

        StringBuilder sb = new StringBuilder();
        for( char ts : tget.toCharArray() ) {
            if( ts != '#' ) {
                sb.append( ts );
            } else if( sb.length() > 0 ) {
                sb.deleteCharAt( sb.length() - 1 );
            }
        }

        return sb.toString();
    }
}