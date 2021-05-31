package com.chuset.dataStructures.hashTables;

import java.util.ArrayList;
import java.util.List;

public class MyHashTable {

    private static class MyNodes extends ArrayList<MyNode> {
    }

    public static class MyNode {
        private String key;
        private int value;


        public MyNode(final String key, final int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(final String key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(final int value) {
            this.value = value;
        }
    }

    private final int size;
    private final MyNodes[] data;

    MyHashTable(final int size) {
        this.size = size;
        data = new MyNodes[size];
    }

    private int hash(final String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i) * i) % size;
        }
        return hash;
    }

    public void set(final String key, final int value) {
        final int hashedKey = hash(key);
        if (data[hashedKey] == null) {
            data[hashedKey] = new MyNodes();
        }
        data[hashedKey].add(new MyNode(key, value));
    }

    public int get(final String key) {
        final int hashedKey = hash(key);
        if (data[hashedKey] == null) {
            return 0;
        }
        for (final MyNode node : data[hashedKey]) {
            if (key.equals(node.getKey())) {
                return node.getValue();
            }
        }
        return 0;
    }

    public List<String> keys() {
        final List<String> keys = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (data[i] != null) {
                for (int j = 0; j < data[i].size(); j++) {
                    keys.add(data[i].get(j).getKey());
                }
            }
        }
        return keys;
    }

    public static void main(String[] args) {
        final MyHashTable myHashTable = new MyHashTable(50);
        myHashTable.set("ta", 1000);
        myHashTable.set("tu", 589);
        myHashTable.set("e", 10);
        System.out.println(myHashTable.keys().size());
        System.out.println(myHashTable.get("ta"));
        System.out.println(myHashTable.get("tu"));
        System.out.println(myHashTable.get("e"));
    }
}
