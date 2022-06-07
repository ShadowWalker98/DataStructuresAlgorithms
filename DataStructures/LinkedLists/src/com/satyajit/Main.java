package com.satyajit;

import com.satyajit.implementations.LinkedListImpl;

public class Main {

    public static void main(String[] args) {
		System.out.println("Hello inside the main function!");
        LinkedListImpl<Integer> linkedList = new LinkedListImpl<>();
        setUp(linkedList);
    }

    public static void setUp(LinkedListImpl<Integer> linkedList) {
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.printList();
    }
}
