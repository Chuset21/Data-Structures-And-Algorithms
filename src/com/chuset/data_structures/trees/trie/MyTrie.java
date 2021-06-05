package com.chuset.data_structures.trees.trie;

import java.io.*;
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

    // The boolean in this is used for the method to know what to do, the return from the original call is meaningless
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

    public void insertFromFile(final File file) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String row;
        while ((row = bufferedReader.readLine()) != null) {
            this.insert(row);
        }
    }

    public static void main(String[] args) throws IOException {
        final MyTrie dictionary = new MyTrie();
        System.out.printf("The dictionary is%s empty.%n", dictionary.isEmpty() ? "" : "n't");

        dictionary.insertFromFile(new File("dictionary.txt"));

        System.out.printf("The dictionary is%s empty.%n", dictionary.isEmpty() ? "" : "n't");
        System.out.printf("The dictionary %s \"trip\".%n",
                dictionary.contains("trip") ? "contains" : "doesn't contain");

        dictionary.delete("trip");
        System.out.printf("The dictionary %s \"trip\".%n",
                dictionary.contains("trip") ? "contains" : "doesn't contain");
    }
}
