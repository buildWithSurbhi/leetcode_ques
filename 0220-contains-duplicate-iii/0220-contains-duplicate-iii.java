import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            
            // Find smallest number >= nums[i] - valueDiff
            Long x = set.ceiling((long) nums[i] - valueDiff);

            // Check if |nums[i] - x| <= valueDiff
            if (x != null && x <= (long) nums[i] + valueDiff) {
                return true;
            }

            set.add((long) nums[i]);

            // Keep only previous indexDiff elements
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}