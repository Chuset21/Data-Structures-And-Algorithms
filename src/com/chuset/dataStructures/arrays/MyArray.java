package com.chuset.dataStructures.arrays;

import java.util.Arrays;

public class MyArray {

    private int length;
    private Object[] data;
    private int capacity;

    MyArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.data = new Object[1];
    }

    MyArray() {
        this(1);
    }

    @Override
    public String toString() {
        return String.format("MyArray{ length = %d, data = %s, capacity = %d}",
                length, this.printMyArray(), capacity);
    }

    private String printMyArray() {
        StringBuilder b = new StringBuilder("[");
        int limit = length - 1;
        for (int i = 0; i < limit; i++) {
            b.append(data[i]).append(", ");
        }
        return b.append(data[limit]).append("]").toString();
    }

    public Object getData(final int index) {
        return data[index];
    }

    public void push(final Object item) {
        if (length == capacity) {
            final int newCapacity = capacity * 2;
            data = Arrays.copyOf(data, newCapacity);
            capacity = newCapacity;
        }
        data[length++] = item;
    }

    public Object pop() { // I would make this void
        final Object popped = data[--length];
        data[length] = null;
        return popped;
    }

    public Object delete(final int index) { // I would make this void
        final Object item = data[index];
        this.shiftItems(index);
        return item;
    }

    public void shiftItems(final int index) {
        int limit = this.length - 1 - index;
        if (limit >= 0) {
            System.arraycopy(this.data, index + 1, this.data, index, limit);
            data[--length] = null;
        }
    }


    public static void main(String[] args) {
        MyArray newArray = new MyArray();
        newArray.push("hi");
        newArray.push("you");
        newArray.push('!');
        newArray.delete(1);
        System.out.println(newArray);
    }
}
