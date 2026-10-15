class Solution {
    public int numIslands(char[][] grid) {
        // Edge case: empty grid
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Traverse every cell in the grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // If a cell with land '1' is found, it represents a new island
                if (grid[r][c] == '1') {
                    numIslands++;
                    // Flood fill / sink the connected components using DFS
                    dfs(grid, r, c);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Base case: check for out-of-bound indices or water ('0')
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == '0') {
            return;
        }

        // Mark the current land cell as visited by sinking it to '0'
        grid[r][c] = '0';

        // Recursively visit all 4 adjacent directions
        dfs(grid, r - 1, c); // Up
        dfs(grid, r + 1, c); // Down
        dfs(grid, r, c - 1); // Left
        dfs(grid, r, c + 1); // Right
    }
}