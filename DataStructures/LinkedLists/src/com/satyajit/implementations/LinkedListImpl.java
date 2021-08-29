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
    public void addAt(int pos, T data) {
        // adds a node of type T at position pos (1 - n)
        //TODO: Review logic for adding a node to the middle of a linked list

        if(pos <= 0) {
            System.out.println("Invalid parameter - position should be not be less than or equal to zero");
            return;
        }

        if(Objects.isNull(this.headNode)) {
            if(pos == 1) {
                this.add(data);
                return;
            }
            System.out.println("List is empty");
            return;
        }

        if(pos == 1) {
            Node<T> newNode = new Node<>(data);
            newNode.setNext(this.headNode);
            this.headNode = newNode;
            return;
        }

        Node<T> runner = this.headNode;
        int traversed = 1;

        while(Objects.nonNull(runner)) {
            if(traversed == pos - 1)
                break;
            runner = runner.getNext();
            traversed++;
        }

        if(traversed < (pos - 1)) {
            System.out.printf("Item %s can't be added at position %d\n", data.toString(), pos);
        } else {
            Node<T> newNode = new Node<>(data);
            newNode.setNext(runner.getNext());
            runner.setNext(newNode);
        }

    }

    @Override
    public void deleteHead() {
        if(Objects.isNull(this.headNode)) {
            System.out.println("List is empty");
            return;
        }
        if(Objects.isNull(this.headNode.getNext())) {
            this.headNode = null;
        } else {
            this.headNode = this.headNode.getNext();
        }
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
