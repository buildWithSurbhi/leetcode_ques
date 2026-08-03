class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][] ahead = new int[2][k + 1];
        int[][] curr = new int[2][k + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int cap = 1; cap <= k; cap++) {

                // Buy state
                curr[1][cap] = Math.max(
                        -prices[i] + ahead[0][cap],
                        ahead[1][cap]
                );

                // Sell state
                curr[0][cap] = Math.max(
                        prices[i] + ahead[1][cap - 1],
                        ahead[0][cap]
                );
            }

            for (int b = 0; b < 2; b++) {
                System.arraycopy(curr[b], 0, ahead[b], 0, k + 1);
            }
        }

        return ahead[1][k];
    }
}