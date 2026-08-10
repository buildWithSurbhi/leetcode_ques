class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int i, int j) {

        // Boundary check
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == '0') {
            return;
        }

        // Mark land as visited
        grid[i][j] = '0';

        // Up
        dfs(grid, i - 1, j);

        // Down
        dfs(grid, i + 1, j);

        // Left
        dfs(grid, i, j - 1);

        // Right
        dfs(grid, i, j + 1);
    }
}