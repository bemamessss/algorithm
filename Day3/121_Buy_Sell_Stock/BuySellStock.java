
public class BuySellStock {
    public int maxProfit(int[] prices) {

        if( prices == null || prices.length == 0 ) return 0;
        
        // 제일 저렴한 가격을 계속 갱신하자. 어떤 값이든 MAX_VALUE보단 작을 것.
        int min = Integer.MAX_VALUE;
        // 차익이 큰 값을 계속 갱신하자. 이익이 없을 경우에는 0을 반환해야 하므로 0으로 초기화.
        int max = 0;

        for( int price : prices ) {

            // #1. 최소값을 저장한다.
            // if( price < min ) {
            //     min = price;
            // }
            min = Math.min( price, min );

            // #2. 기존 저장한 차익보다 크면 저장한다.
            // if( ( price - min ) > max ) {
            //     max = price;
            // }
            max = Math.max( (price - min), max );
        }

        return max;

        // min 7 max 0
        // min 1 max 0
        // min 1 max 4
        // min 1 max 4
        // min 1 max 5
        // min 1 max 5        
    }
}