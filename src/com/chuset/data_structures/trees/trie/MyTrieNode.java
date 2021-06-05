package com.chuset.data_structures.trees.trie;

import java.util.HashMap;

public class MyTrieNode {

    private final HashMap<Character, MyTrieNode> children;
    private boolean isEndOfWord;

    public MyTrieNode() {
        children = new HashMap<>();
    }

    public boolean isEmpty() {
        return children.isEmpty();
    }

    public HashMap<Character, MyTrieNode> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(final boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}
