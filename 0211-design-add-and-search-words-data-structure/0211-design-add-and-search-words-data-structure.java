class WordDictionary {

    // Trie Node
    class Node {
        Node[] children = new Node[26];
        boolean isEnd;
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    // Add a word to Trie
    public void addWord(String word) {
        Node curr = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }

            curr = curr.children[index];
        }

        curr.isEnd = true;
    }

    // Search a word
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(Node curr, String word, int index) {

        // Entire word processed
        if (index == word.length()) {
            return curr.isEnd;
        }

        char ch = word.charAt(index);

        // Normal character
        if (ch != '.') {
            int childIndex = ch - 'a';

            if (curr.children[childIndex] == null) {
                return false;
            }

            return dfs(curr.children[childIndex], word, index + 1);
        }

        // '.' can match any character
        for (int i = 0; i < 26; i++) {

            if (curr.children[i] != null) {
                if (dfs(curr.children[i], word, index + 1)) {
                    return true;
                }
            }
        }

        return false;
    }
}