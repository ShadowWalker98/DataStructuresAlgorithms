package com.satyajit;

import com.satyajit.implementations.LinkedListImpl;
import com.satyajit.implementations.Node;

import java.util.Objects;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
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
