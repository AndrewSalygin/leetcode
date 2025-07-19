package tries;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode(null, false);
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        char[] charsInWord = word.toCharArray();
        for (char c : charsInWord) {
            TrieNode nextNode = currentNode.trieNodes[c - 'a'];
            if (nextNode == null) {
                TrieNode newNode = new TrieNode(c);
                currentNode.trieNodes[c - 'a'] = newNode;
                currentNode = newNode;
            } else {
                currentNode = nextNode;
            }
        }
        currentNode.isWord = true;
    }

    public boolean search(String word) {
        TrieNode currentNode = root;
        char[] charsInWord = word.toCharArray();
        for (char c : charsInWord) {
            TrieNode nextNode = currentNode.trieNodes[c - 'a'];
            if (nextNode != null) {
                currentNode = nextNode;
            } else {
                return false;
            }
        }
        return currentNode.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        char[] charsInWord = prefix.toCharArray();
        for (char c : charsInWord) {
            TrieNode nextNode = currentNode.trieNodes[c - 'a'];
            if (nextNode != null) {
                currentNode = nextNode;
            } else {
                return false;
            }
        }
        return true;
    }

    private static class TrieNode {

        private final TrieNode[] trieNodes;

        private boolean isWord;

        private TrieNode(Character symbol) {
            this.trieNodes = new TrieNode[26];
            this.isWord = false;
        }

        private TrieNode(Character symbol, boolean isWord) {
            this.trieNodes = new TrieNode[26];
            this.isWord = isWord;
        }
    }
}
