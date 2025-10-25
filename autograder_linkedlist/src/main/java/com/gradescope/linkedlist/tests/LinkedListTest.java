package com.gradescope.linkedlist.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import com.gradescope.jh61b.grader.GradedTest;
import com.gradescope.linkedlist.LinkedList;

/**
 * Autograder tests for LinkedList.
 * 
 * Each test compares student output to the instructor reference implementation.
 */
public class LinkedListTest {

    private void assertLinkedListEquals(ReferenceLinkedList ref, LinkedList stu) {
        assertEquals("List mismatch", ref.toString(), stu.toString());
        assertEquals("Head value mismatch", ref.getHeadValue(), stu.getHeadValue());
        assertEquals("End value mismatch", ref.getEndValue(), stu.getEndValue());
    }

    @Test(timeout = 1000)
    @GradedTest(name="Test create list", max_score=10)
    public void testCreateList() {
        ReferenceLinkedList ref = ReferenceLinkedList.createList(1, 2, 3, 4);
        LinkedList stu = LinkedList.createList(1, 2, 3, 4);
        assertLinkedListEquals(ref, stu);
    }

    @Test(timeout = 1000)
    @GradedTest(name="Test insert operation", max_score=20)
    public void testInsertOperations() {
        ReferenceLinkedList ref = new ReferenceLinkedList();
        LinkedList stu = new LinkedList();
        ref.insertAtBeginning(3); stu.insertAtBeginning(3);
        ref.insertAtBeginning(2); stu.insertAtBeginning(2);
        ref.insertAtBeginning(1); stu.insertAtBeginning(1);
        ref.insertAtEnd(4); stu.insertAtEnd(4);
        ref.insertAtPosition(2, 9); stu.insertAtPosition(2, 9);
        assertLinkedListEquals(ref, stu);
    }

    @Test(timeout = 1000)
    @GradedTest(name="Test deletion operation", max_score=20)
    public void testDeletionOperations() {
        ReferenceLinkedList ref = ReferenceLinkedList.createList(1, 2, 3, 4);
        LinkedList stu = LinkedList.createList(1, 2, 3, 4);
        ref.deleteByValue(2); stu.deleteByValue(2);
        ref.deleteHead(); stu.deleteHead();
        ref.deleteFromEnd(); stu.deleteFromEnd();
        assertLinkedListEquals(ref, stu);
    }

    @Test(timeout = 1000)
    @GradedTest(name="Test delete from position", max_score=20)
    public void testDeleteFromPosition() {
        ReferenceLinkedList ref = ReferenceLinkedList.createList(10, 20, 30, 40, 50);
        LinkedList stu = LinkedList.createList(10, 20, 30, 40, 50);
        ref.deleteFromPosition(2); stu.deleteFromPosition(2);
        ref.deleteFromPosition(0); stu.deleteFromPosition(0);
        ref.deleteFromPosition(10); stu.deleteFromPosition(10);
        assertLinkedListEquals(ref, stu);
    }

    @Test(timeout = 1000)
    @GradedTest(name="Test get function", max_score=10)
    public void testGetFunctions() {
        ReferenceLinkedList ref = ReferenceLinkedList.createList(5, 15, 25, 35);
        LinkedList stu = LinkedList.createList(5, 15, 25, 35);
        assertEquals(ref.getPosition(25), stu.getPosition(25));
        assertEquals(ref.getPosition(100), stu.getPosition(100));
        assertEquals(ref.getHeadValue(), stu.getHeadValue());
        assertEquals(ref.getEndValue(), stu.getEndValue());
    }

    @Test(timeout = 1000)
    @GradedTest(name="Test complex sequence", max_score=20)
    public void testComplexSequence() {
        ReferenceLinkedList ref = ReferenceLinkedList.createList(1, 2, 3);
        LinkedList stu = LinkedList.createList(1, 2, 3);

        ref.insertAtPosition(1, 5); stu.insertAtPosition(1, 5);
        ref.deleteByValue(2); stu.deleteByValue(2);
        ref.insertAtEnd(9); stu.insertAtEnd(9);
        ref.deleteFromEnd(); stu.deleteFromEnd();
        ref.deleteHead(); stu.deleteHead();

        assertLinkedListEquals(ref, stu);
    }
}

