package liveramp;


/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume
 * all four edges of the grid are all surrounded by water.
 */
public class NumberofIland {

    public static void main(String[] args) {
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println("Number of islands in grid1: " + numIslands(grid1)); // Expected: 1

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands in grid2: " + numIslands(grid2)); // Expected: 3
    }

    /**
     *
     Iterate through the grid: Go through each cell of the 2D grid,
     one by one.

     2.Find an island: When you find a cell that contains a '1', you've discovered a piece of an island.
     This is the start of a new island we haven't counted yet.

     3.
        Count and Sink:•Increment your island counter.•Now, you need to find all the connected parts of this same island and "sink"
        them (change their '1's to '0's). This prevents you from ever counting this island again.
        •We use a helper function (a DFS) that starts from the current cell.
        It recursively explores up, down, left, and right, changing every connected '1' to a '0'.

     4.Continue Searching: Once the DFS is done, the entire island is sunk.
        You continue your main iteration through the grid, looking for the next '1', which will be the start of a completely new island.
     */
    public static int numIslands(char[][] grid) {
        // Handle edge cases for an empty or null grid
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numRows = grid.length;
        int numCols = grid[0].length;
        int islandCount = 0;

        // Iterate through each cell of the grid
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                // If we find a '1', it's the start of a new island
                if (grid[r][c] == '1') {
                    islandCount++;
                    // "Sink" the entire island by turning all its '1's to '0's
                    dfs(grid, r, c);
                }
            }
        }

        return islandCount;
    }

    /**
     * A helper function to perform Depth-First Search (DFS) to find all parts of an island.
     * It marks visited land cells by changing '1' to '0'.
     *
     * @param grid The grid we are exploring.
     * @param r    The current row index.
     * @param c    The current column index.
     */
    private static void dfs(char[][] grid, int r, int c) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        // Base Case for recursion: Stop if we go out of bounds or hit water ('0')
        if (r < 0 || c < 0 || r >= numRows || c >= numCols || grid[r][c] == '0') {
            return;
        }

        // Mark the current cell as visited by "sinking" it
        grid[r][c] = '0';

        // Recursively visit all 4 neighbors
        dfs(grid, r + 1, c); // Down
        dfs(grid, r - 1, c); // Up
        dfs(grid, r, c + 1); // Right
        dfs(grid, r, c - 1); // Left
    }
}
