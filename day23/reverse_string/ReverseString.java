package day23.reverse_string;

public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while( left < right ) {
            char tempLeft = s[left];
            s[left] = s[right];
            s[right] = tempLeft;
            left++;
            right--;
        }
    }
}