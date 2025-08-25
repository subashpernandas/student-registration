package com.tech.subash.common.prgram;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length; // 3
        int cols = board[0].length; //4
        System.out.println("rows and cols "+ rows + " "+ cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        // Base case: full word matched
        if (index == word.length()) return true;

        // Check bounds and character match
        if (row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length ||
                board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited
        char temp = board[row][col];
        board[row][col] = '#'; // any non-alphabet placeholder

        // Explore 4 directions (up, down, left, right)
        boolean found =
                backtrack(board, word, row + 1, col, index + 1) ||
                        backtrack(board, word, row - 1, col, index + 1) ||
                        backtrack(board, word, row, col + 1, index + 1) ||
                        backtrack(board, word, row, col - 1, index + 1);

        // Backtrack (restore the character)
        board[row][col] = temp;

        return found;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        WordSearch sol = new WordSearch();
        System.out.println(sol.exist(board, "ABCCED")); // true
        System.out.println(sol.exist(board, "SEE"));    // true
        System.out.println(sol.exist(board, "ABCB"));   // false
    }

    }
