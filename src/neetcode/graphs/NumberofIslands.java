package neetcode.graphs;

//Number of Islands
//https://leetcode.com/problems/number-of-islands/
public class NumberofIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int column) {
        if (row == grid.length || column == grid[0].length || row < 0 || column < 0) {
            return;
        }
        if (grid[row][column] == '1') {
            grid[row][column] = '0';
            dfs(grid, row - 1, column);
            dfs(grid, row + 1, column);
            dfs(grid, row, column - 1);
            dfs(grid, row, column + 1);
        }

    }
/*
    Input: grid = [
            [ 1 , 1 , 0 , 1 , 0 ],
            [ 1 , 1 , 0 , 1 , 0 ],
            [ 1 , 1 , 0 , 0 , 0 ],
            [ 0 , 0 , 0 , 0 , 1 ]
            ]
            */

    public static void main(String arg[]) {
        char arr[][] = {{1, 1, 0, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1}};
        System.out.println(minnumIslands(arr));
    }

    public static int minnumIslands(char[][] grid) {
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int value = mindfs(grid, i, j);
                    count = Math.min(count, value);
                }
            }
        }
        return count;
    }

    public static int mindfs(char[][] grid, int row, int column) {
        if (row == grid.length || column == grid[0].length || row < 0 || column < 0) {
            return 0;
        }
        if (grid[row][column] == 0) {
            return 0;
        }
        int size = 1;
        grid[row][column] = 0;

        size = size + mindfs(grid, row - 1, column);
        size = size + mindfs(grid, row + 1, column);
        size = size + mindfs(grid, row, column - 1);
        size = size + mindfs(grid, row, column + 1);

        return size;

    }
}
