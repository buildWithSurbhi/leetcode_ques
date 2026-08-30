class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        if (nums.length == 0) {
            return ans;
        }

        int start = nums[0];

        for (int i = 1; i <= nums.length; i++) {

            // End of a consecutive range
            if (i == nums.length || (long) nums[i] != (long) nums[i - 1] + 1) {

                if (start == nums[i - 1]) {
                    ans.add(String.valueOf(start));
                } else {
                    ans.add(start + "->" + nums[i - 1]);
                }

                // Start of next range
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }

        return ans;
    }
}