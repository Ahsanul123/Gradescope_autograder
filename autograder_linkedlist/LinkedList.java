package com.gradescope.linkedlist;

/**
 * Student demo solution for LinkedList assignment.
 * This version correctly implements all required methods.
 */
public class LinkedList {

    /** Node definition */
    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    /** Creates a linked list from given values. */
    public static LinkedList createList(int... values) {
        LinkedList list = new LinkedList();
        for (int v : values) {
            list.insertAtEnd(v);
        }
        return list;
    }

    /** Insert at beginning */
    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    /** Insert at end */
    public void insertAtEnd(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            return;
        }
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = node;
    }

    /** Insert at position (0-based) */
    public void insertAtPosition(int index, int value) {
        if (index <= 0 || head == null) {
            insertAtBeginning(value);
            return;
        }
        Node cur = head;
        for (int i = 0; i < index - 1 && cur.next != null; i++) {
            cur = cur.next;
        }
        Node node = new Node(value);
        node.next = cur.next;
        cur.next = node;
    }

    /** Delete by value (first occurrence) */
    public void deleteByValue(int value) {
        if (head == null) return;
        if (head.data == value) {
            head = head.next;
            return;
        }
        Node cur = head;
        while (cur.next != null && cur.next.data != value) {
            cur = cur.next;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
    }

    /** Delete head */
    public void deleteHead() {
        if (head != null) head = head.next;
    }

    /** Delete from position */
    public void deleteFromPosition(int index) {
        if (head == null) return;
        if (index <= 0) {
            deleteHead();
            return;
        }
        Node cur = head;
        for (int i = 0; i < index - 1 && cur.next != null; i++) {
            cur = cur.next;
        }
        if (cur.next != null) cur.next = cur.next.next;
    }

    /** Delete from end */
    public void deleteFromEnd() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
    }

    /** Get position of value (0-based) */
    public int getPosition(int value) {
        Node cur = head;
        int index = 0;
        while (cur != null) {
            if (cur.data == value) return index;
            cur = cur.next;
            index++;
        }
        return -1;
    }

    /** Get head value */
    public int getHeadValue() {
        return head == null ? -1 : head.data;
    }

    /** Get end value */
    public int getEndValue() {
        if (head == null) return -1;
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        return cur.data;
    }

    /** Convert list to string */
    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node cur = head;
        while (cur != null) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(" -> ");
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // Optional local main for testing
    public static void main(String[] args) {
        LinkedList list = LinkedList.createList(1, 2, 3);
        System.out.println(list); // [1 -> 2 -> 3]
        list.insertAtBeginning(0);
        System.out.println(list); // [0 -> 1 -> 2 -> 3]
        list.deleteFromPosition(2);
        System.out.println(list); // [0 -> 1 -> 3]
        System.out.println("Head: " + list.getHeadValue());
        System.out.println("End: " + list.getEndValue());
        System.out.println("Position of 3: " + list.getPosition(3));
    }
}
