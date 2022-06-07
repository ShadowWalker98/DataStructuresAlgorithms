package com.satyajit.DataStructures.LinkedLists.implementations;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.satyajit.interfaces.LinkedList;

public class LinkedListImpl<T> implements LinkedList<T> {

    Node<T> headNode;

    Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public LinkedListImpl() {
        this.headNode = null;
    }

    @Override
    public void add(T data) {
        // if the list is empty
        if(this.empty()) {
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
        if(pos <= 0) {
            logger.log(Level.SEVERE,"Invalid parameter - position should be not be less than or equal to zero");
            return;
        }

        if(this.empty()) {
            if(pos == 1) {
                this.add(data);
                return;
            }
            logger.log(Level.INFO,"List is empty");
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
            logger.log(Level.WARNING,"Item " + data.toString() + " can't be added at position " + pos + "\n");
        } else {
            Node<T> newNode = new Node<>(data);
            newNode.setNext(runner.getNext());
            runner.setNext(newNode);
        }

    }

    @Override
    public void deleteHead() {
        if(Objects.isNull(this.headNode)) {
            logger.log(Level.INFO,"List is empty");
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
        Node<T> runner = this.headNode;
        if(this.empty()) {
            logger.log(Level.INFO,"List is empty");
            return;
        }
        if(Objects.isNull(this.headNode.getNext())) {
            this.headNode = null;
            return;
        }

        while(Objects.nonNull(runner.getNext().getNext())) {
            runner = runner.getNext();
        }
        runner.setNext(null);
    }

    @Override
    public void deleteAt(int position) {
        if(empty()) {
            logger.log(Level.INFO,"List is empty");
            return;
        }
        Node<T> runner = this.headNode;
        Node<T> previousNode = null;
        int pos = 0;
        while(Objects.nonNull(runner)) {
            pos++;
            if(pos == position) {
                break;
            }
            previousNode = runner;
            runner = runner.getNext();
        }

        if(pos < position) {
            logger.log(Level.WARNING,"Item can't be deleted at position " + position + "\n");
            return;
        }

        if(Objects.isNull(previousNode)) {
            this.headNode = this.headNode.getNext();
            return;
        }
        previousNode.setNext(runner.getNext());
    }

    @Override
    public void deleteData(T data) {
        if(this.empty()) return;

        if(Objects.isNull(this.headNode.getNext())) {
            if(this.headNode.getData() == data) {
                this.headNode = null;
            }
            return;
        }

        Node<T> runner = this.headNode;
        Node<T> previousNode = null;

        while(Objects.nonNull(runner)) {
            if(runner.getData() == data) {
                if(Objects.isNull(previousNode)) {
                    this.headNode = this.headNode.getNext();
                } else {
                    previousNode.setNext(runner.getNext());
                }
                break;
            }
            previousNode = runner;
            runner = runner.getNext();
        }

    }

    @Override
    public void reverseLinkedList() {

    }

    @Override
    public void clear() {

    }

    @Override
    public int length() {
        int totalLength = 0;
        Node<T> runner = headNode;
        while(Objects.nonNull(runner)) {
            totalLength++;
            runner = runner.getNext();
        }
        return totalLength;
    }

    @Override
    public boolean empty() {
        return Objects.isNull(this.headNode);
    }

    @Override
    public void printList() {
        if(this.empty())
            logger.log(Level.INFO,"List is empty");
        else {
            Node<T> runner = this.headNode;
            while(Objects.nonNull(runner)) {
                System.out.println("node data: " + runner.getData());
                runner = runner.getNext();
            }
        }
    }
}
