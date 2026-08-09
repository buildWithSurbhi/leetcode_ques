import java.util.*;

class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffix = new int[n + 1];
        
        // Build suffix sums
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        
        // Memoization table
        Map<String, Integer> memo = new HashMap<>();
        
        return helper(0, 1, suffix, memo, n);
    }
    
    private int helper(int i, int M, int[] suffix, Map<String, Integer> memo, int n) {
        if (i >= n) return 0;
        
        String key = i + "," + M;
        if (memo.containsKey(key)) return memo.get(key);
        
        // If we can take all remaining piles
        if (i + 2 * M >= n) {
            memo.put(key, suffix[i]);
            return suffix[i];
        }
        
        int best = 0;
        for (int X = 1; X <= 2 * M; X++) {
            int opponent = helper(i + X, Math.max(M, X), suffix, memo, n);
            best = Math.max(best, suffix[i] - opponent);
        }
        
        memo.put(key, best);
        return best;
    }
}
