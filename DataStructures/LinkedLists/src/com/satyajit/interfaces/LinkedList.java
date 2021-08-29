package com.satyajit.interfaces;

public interface LinkedList<T> {

    public void add(T data);

    public void addAt(int position, T data);

    public void deleteHead();

    public void deleteTail();

    public void deleteAt(int position);

    public void deleteData(T data);

    public void reverseLinkedList();

    public void clear();

    public int length();

    public boolean empty();

    public void printList();

}
