class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // First row
        for (int j = 1; j < cols; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // First column
        for (int i = 1; i < rows; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // Remaining cells
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[rows - 1][cols - 1];
    }
}