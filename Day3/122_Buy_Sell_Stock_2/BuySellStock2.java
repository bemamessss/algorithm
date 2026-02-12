public class BuySellStock2 {
    public int maxProfit(int[] prices) {

        if( prices == null || prices.length == 0 ) return 0;
        
        // greedy로 풀어야 한다.
        // 이미 미래의 주가를 알고 있으므로, 오르는 것들만 합해도 최소에서 구매하고 최대에서 판 것과 동일한 효과를 낸다.

        int profit = 0;

        for( int i = 1 ; i < prices.length ; i ++ ) {

            // 다음날 가격이 더 비싸면? 샀다 판다.
            if( prices[i] > prices[i-1] ) {
                profit += prices[i] - prices[i-1];
            }
        }

        return profit;

        // ## case 1
        // i = 1 {7 < 1} false -> p : 0
        // i = 2 {1 < 5} true -> p : 4
        // i = 3 {5 < 3} false -> p : 4
        // i = 4 {3 < 6} true -> p : 4 + 3
        // i = 5 {6 < 4} false -> p : 7
    }
}