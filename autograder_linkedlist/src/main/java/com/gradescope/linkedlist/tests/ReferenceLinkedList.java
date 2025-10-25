package com.gradescope.linkedlist.tests;

/**
 * Internal instructor-only reference implementation
 * used to validate student outputs.
 *
 * DO NOT share this file with students.
 */
public class ReferenceLinkedList {

    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;

    public ReferenceLinkedList() { head = null; }

    public static ReferenceLinkedList createList(int... values) {
        ReferenceLinkedList list = new ReferenceLinkedList();
        for (int v : values) list.insertAtEnd(v);
        return list;
    }

    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    public void insertAtEnd(int value) {
        Node node = new Node(value);
        if (head == null) { head = node; return; }
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = node;
    }

    public void insertAtPosition(int index, int value) {
        if (index <= 0 || head == null) { insertAtBeginning(value); return; }
        Node cur = head;
        for (int i = 0; i < index - 1 && cur.next != null; i++) cur = cur.next;
        Node node = new Node(value);
        node.next = cur.next;
        cur.next = node;
    }

    public void deleteByValue(int value) {
        if (head == null) return;
        if (head.data == value) { head = head.next; return; }
        Node cur = head;
        while (cur.next != null && cur.next.data != value) cur = cur.next;
        if (cur.next != null) cur.next = cur.next.next;
    }

    public void deleteHead() {
        if (head != null) head = head.next;
    }

    public void deleteFromPosition(int index) {
        if (head == null) return;
        if (index <= 0) { deleteHead(); return; }
        Node cur = head;
        for (int i = 0; i < index - 1 && cur.next != null; i++) cur = cur.next;
        if (cur.next != null) cur.next = cur.next.next;
    }

    public void deleteFromEnd() {
        if (head == null) return;
        if (head.next == null) { head = null; return; }
        Node cur = head;
        while (cur.next.next != null) cur = cur.next;
        cur.next = null;
    }

    public int getPosition(int value) {
        Node cur = head;
        int idx = 0;
        while (cur != null) {
            if (cur.data == value) return idx;
            idx++;
            cur = cur.next;
        }
        return -1;
    }

    public int getHeadValue() {
        return head == null ? -1 : head.data;
    }

    public int getEndValue() {
        if (head == null) return -1;
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        return cur.data;
    }

    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node cur = head;
        while (cur != null) {
            sb.append(cur.data);
            cur = cur.next;
            if (cur != null) sb.append(" -> ");
        }
        sb.append("]");
        return sb.toString();
    }
}
