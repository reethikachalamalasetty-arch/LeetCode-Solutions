class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,
                        int row, int col, int index) {

        // Word is completely found
        if (index == word.length()) {
            return true;
        }

        // Check boundaries and character
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Search in four directions
        boolean found = dfs(board, word, row + 1, col, index + 1)
                     || dfs(board, word, row - 1, col, index + 1)
                     || dfs(board, word, row, col + 1, index + 1)
                     || dfs(board, word, row, col - 1, index + 1);

        // Backtrack
        board[row][col] = temp;

        return found;
    }
}