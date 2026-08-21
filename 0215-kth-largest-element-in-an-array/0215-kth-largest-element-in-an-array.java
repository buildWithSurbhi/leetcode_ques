class Solution {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int pivot = nums[left + (right - left) / 2];

            int low = left;
            int mid = left;
            int high = right;

            // 3-way partition
            while (mid <= high) {
                if (nums[mid] < pivot) {
                    swap(nums, low, mid);
                    low++;
                    mid++;
                } 
                else if (nums[mid] > pivot) {
                    swap(nums, mid, high);
                    high--;
                } 
                else {
                    mid++;
                }
            }

            // target is in the left part
            if (target < low) {
                right = low - 1;
            }
            // target is in the equal part
            else if (target <= high) {
                return nums[target];
            }
            // target is in the right part
            else {
                left = high + 1;
            }
        }

        return -1;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}