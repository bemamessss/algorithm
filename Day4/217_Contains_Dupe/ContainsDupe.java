import java.util.*;

public class ContainsDupe {
    public boolean containsDuplicate(int[] nums) {
        if( nums == null || nums.length == 0 ) return false;

        // TIP : 앞으로는 Integer 제네릭 추가해 주고, 사이즈도 미리 넣어 주면 좋음.
        Set set = new HashSet<>(); 

        for( int num : nums ) {

            if( set.contains( num ) ) {
                return true;
            }
            set.add( num );
//          if( !set.add( num ) ) => TIP : 중복이면 반환값이 false임.
        }

        return false;
    }
}