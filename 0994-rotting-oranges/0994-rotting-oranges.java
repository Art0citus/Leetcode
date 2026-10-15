class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // Step 1: Scan the grid to find all initially rotten oranges and count fresh ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c}); // Enqueue rotten orange coordinates
                } else if (grid[r][c] == 1) {
                    freshOranges++; // Count fresh orange
                }
            }
        }

        // If there are no fresh oranges to begin with, 0 minutes are needed
        if (freshOranges == 0) {
            return 0;
        }

        int minutesElapsed = 0;
        // 4-directional offsets for navigating Up, Down, Left, Right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Step 2: Multi-source BFS traversal
        while (!queue.isEmpty() && freshOranges > 0) {
            int levelSize = queue.size();
            minutesElapsed++; // A new minute begins for the current level of rotting

            for (int i = 0; i < levelSize; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                // Check all 4 adjacent directions
                for (int[] dir : directions) {
                    int nextR = r + dir[0];
                    int nextC = c + dir[1];

                    // If the neighbor is within bounds and contains a fresh orange
                    if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && grid[nextR][nextC] == 1) {
                        grid[nextR][nextC] = 2; // Infect it / turn it rotten
                        freshOranges--;         // Decrement fresh count
                        queue.add(new int[]{nextR, nextC}); // Enqueue it to spread rot next minute
                    }
                }
            }
        }

        // Step 3: Return result. If fresh oranges remain, it's impossible to rot everything
        return freshOranges == 0 ? minutesElapsed : -1;
    }
}