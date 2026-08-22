class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(int start, int k, int target,
                   List<Integer> current,
                   List<List<Integer>> ans) {

        // Valid combination
        if (k == 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(current));
            }
            return;
        }

        // Try numbers from start to 9
        for (int i = start; i <= 9; i++) {

            // If number is bigger than target, no need to continue
            if (i > target) {
                break;
            }

            current.add(i);

            // i + 1 ensures the same number is not reused
            backtrack(i + 1, k - 1, target - i, current, ans);

            // Remove last number (backtracking)
            current.remove(current.size() - 1);
        }
    }
}