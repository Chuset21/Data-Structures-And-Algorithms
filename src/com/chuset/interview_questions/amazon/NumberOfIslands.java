package com.chuset.interview_questions.amazon;

public class NumberOfIslands {

    /*
    Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
    return the number of islands.

    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.



    Example 1:

    Input: grid = [
      ["1","1","1","1","0"],
      ["1","1","0","1","0"],
      ["1","1","0","0","0"],
      ["0","0","0","0","0"]
    ]
    Output: 1

    Example 2:

    Input: grid = [
      ["1","1","0","0","0"],
      ["1","1","0","0","0"],
      ["0","0","1","0","0"],
      ["0","0","0","1","1"]
    ]
    Output: 3
     */

    public static int numIslands(final char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && traverseGrid(i, j, grid)) {
                    result++;
                }
            }
        }
        return result;
    }

    private static boolean traverseGrid(final int row, final int col, final char[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return true;
        } else {
            grid[row][col] = '0';
            return traverseGrid(row + 1, col, grid)
                    && traverseGrid(row, col + 1, grid)
                    && traverseGrid(row - 1, col, grid)
                    && traverseGrid(row, col - 1, grid);
        }
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{
                '1', '1', '1', '1', '0'
        }, {
                '1', '1', '0', '1', '0'
        }, {
                '1', '1', '0', '0', '0'
        }, {
                '0', '0', '0', '0', '0'
        }
        }));
    }
}
