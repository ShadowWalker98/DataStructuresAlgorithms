package com.satyajit.implementations;

import com.satyajit.interfaces.LinkedList;

import java.util.Objects;

public class LinkedListImpl<T> implements LinkedList<T> {

    Node<T> headNode;

    public LinkedListImpl() {
        this.headNode = null;
    }

    @Override
    public void add(T data) {
        // if the list is empty
        if(Objects.isNull(this.headNode)) {
            this.headNode = new Node<>(data);
        } else {
            Node<T> runner = headNode;
            while(Objects.nonNull(runner.getNext())) {
                runner = runner.getNext();
            }
            Node<T> newNode = new Node<>(data);
            runner.setNext(newNode);
        }
    }

    @Override
    public void addAt(int position, Object data) {

    }

    @Override
    public void deleteHead() {

    }

    @Override
    public void deleteTail() {

    }

    @Override
    public void deleteAt(int position) {

    }

    @Override
    public void deleteData(Object data) {

    }

    @Override
    public void reverseLinkedList() {

    }

    @Override
    public void clear() {

    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public void printList() {
        if(Objects.isNull(this.headNode))
            System.out.println("list is empty");
        else {
            Node runner = this.headNode;
            while(Objects.nonNull(runner)) {
                System.out.println("node data: " + runner.getData());
                runner = runner.getNext();
            }
        }
    }
}
