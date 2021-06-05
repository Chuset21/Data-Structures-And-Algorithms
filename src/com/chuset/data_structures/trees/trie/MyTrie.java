package com.chuset.data_structures.trees.trie;

import java.util.Locale;

public class MyTrie {

    private final MyTrieNode root;

    public MyTrie() {
        root = new MyTrieNode();
    }

    public boolean isEmpty() {
        return root.isEmpty();
    }

    public void delete(final String word) {
        delete(root, word.toLowerCase(Locale.ROOT), 0);
    }

    private boolean delete(final MyTrieNode current, final String word, final int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        final char ch = word.charAt(index);
        final MyTrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }

        if (delete(node, word, index + 1) && !node.isEndOfWord()) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }

    public boolean contains(String word) {
        word = word.toLowerCase(Locale.ROOT);
        MyTrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            final MyTrieNode node = current.getChildren().get(word.charAt(i));
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    public void insert(final String word) {
        MyTrieNode current = root;

        for (char letter : word.toLowerCase(Locale.ROOT).toCharArray()) {
            current = current.getChildren().computeIfAbsent(letter, c -> new MyTrieNode());
        }
        current.setEndOfWord(true);
    }

    public static void main(String[] args) {
        final MyTrie dictionary = new MyTrie();
        System.out.printf("The dictionary is%s empty.%n", dictionary.isEmpty() ? "" : "n't");

        dictionary.insert("Joe");
        dictionary.insert("Joseph");
        dictionary.insert("lola");
        System.out.printf("The dictionary is%s empty.%n", dictionary.isEmpty() ? "" : "n't");

        dictionary.insert("hitch hiking");
        dictionary.insert("Road");
        dictionary.insert("trip");
        System.out.printf("The dictionary %s \"trip\".%n",
                dictionary.contains("trip") ? "contains" : "doesn't contain");

        dictionary.delete("trip");
        System.out.printf("The dictionary %s \"trip\".%n",
                dictionary.contains("trip") ? "contains" : "doesn't contain");
    }
}
