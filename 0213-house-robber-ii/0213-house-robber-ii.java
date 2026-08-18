class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Case 1: Exclude last house
        int case1 = robLinear(nums, 0, n - 2);
        // Case 2: Exclude first house
        int case2 = robLinear(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0; // prev2 = dp[i-2], prev1 = dp[i-1]
        for (int i = start; i <= end; i++) {
            int pick = nums[i] + prev2;
            int skip = prev1;
            int curr = Math.max(pick, skip);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
