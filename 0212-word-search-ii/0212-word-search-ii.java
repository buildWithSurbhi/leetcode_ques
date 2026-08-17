import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        for (String word : words) {
            insert(word);
        }

        int m = board.length;
        int n = board[0].length;

        // Start DFS from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }

        return result;
    }

    private void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.word = word;
    }

    private void dfs(char[][] board, int row, int col, TrieNode node) {

        // Boundary check
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return;
        }

        char ch = board[row][col];

        // Visited cell
        if (ch == '#') {
            return;
        }

        TrieNode next = node.children[ch - 'a'];

        // Character not present in Trie
        if (next == null) {
            return;
        }

        // Found a complete word
        if (next.word != null) {
            result.add(next.word);

            // Prevent duplicate result
            next.word = null;
        }

        // Mark current cell as visited
        board[row][col] = '#';

        // Up
        dfs(board, row - 1, col, next);

        // Down
        dfs(board, row + 1, col, next);

        // Left
        dfs(board, row, col - 1, next);

        // Right
        dfs(board, row, col + 1, next);

        // Restore cell
        board[row][col] = ch;
    }
}