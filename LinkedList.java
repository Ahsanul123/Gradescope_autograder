package com.gradescope.linkedlist;

/**
 * LinkedList assignment template for students.
 *
 * Students must implement ALL the methods below.
 * DO NOT change method names or signatures — the autograder depends on them.
 *
 * Required methods:
 * - createList(int... values)
 * - insertAtBeginning(int value)
 * - insertAtEnd(int value)
 * - insertAtPosition(int index, int value)
 * - deleteByValue(int value)
 * - deleteHead()
 * - deleteFromPosition(int index)
 * - deleteFromEnd()
 * - getPosition(int value)
 * - getHeadValue()
 * - getEndValue()
 * - toString()
 */
public class LinkedList {

    /**
     * Node class representing one element in the list.
     */
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head node
    private Node head;

    /**
     * Constructs an empty linked list.
     */
    public LinkedList() {
        this.head = null;
    }

    /**
     * Creates a linked list from a sequence of values.
     * Example: LinkedList.createList(1, 2, 3) -> [1 -> 2 -> 3]
     */
    public static LinkedList createList(int... values) {
        // TODO: Implement
        return null;
    }

    /**
     * Inserts a new node at the beginning.
     * Example: [] -> insertAtBeginning(1) => [1]
     *          [2,3] -> insertAtBeginning(1) => [1,2,3]
     */
    public void insertAtBeginning(int value) {
        // TODO: Implement
    }

    /** 
     * Inserts a new node at the end.
     * Example: [1,2] -> insertAtEnd(3) => [1,2,3]
     */
    public void insertAtEnd(int value) {
        // TODO: Implement
    }

    /**
     * Inserts a node at the given position (0-based index).
     * If index = 0, acts like insertAtBeginning().
     * If index >= size, appends at the end.
     */
    public void insertAtPosition(int index, int value) {
        // TODO: Implement
    }

    /**
     * Deletes the first occurrence of the specified value.
     * Example: [1,2,3,2] -> deleteByValue(2) => [1,3,2]
     */
    public void deleteByValue(int value) {
        // TODO: Implement
    }

    /**
     * Deletes the head node (first element) of the list.
     * Example: [1,2,3] -> deleteHead() => [2,3]
     */
    public void deleteHead() {
        // TODO: Implement
    }

    /**
     * Deletes the node at the specified position (0-based index).
     * If index = 0, behaves like deleteHead().
     * If index >= size, does nothing.
     */
    public void deleteFromPosition(int index) {
        // TODO: Implement
    }

    /**
     * Deletes the node from the end of the list.
     * Example: [1,2,3] -> deleteFromEnd() => [1,2]
     */
    public void deleteFromEnd() {
        // TODO: Implement
    }

    /**
     * Returns the position (0-based index) of the first occurrence of value.
     * If not found, return -1.
     * Example: [1,3,5] -> getPosition(3) => 1
     */
    public int getPosition(int value) {
        // TODO: Implement
        return -1;
    }

    /**
     * Returns the value of the head node, or -1 if the list is empty.
     */
    public int getHeadValue() {
        // TODO: Implement
        return -1;
    }

    /**
     * Returns the value of the last node, or -1 if the list is empty.
     */
    public int getEndValue() {
        // TODO: Implement
        return -1;
    }

    /**
     * Returns a string representation of the linked list.
     * Example: [1 -> 2 -> 3]
     */
    public String toString() {
        // TODO: Implement
        return "";
    }
}
