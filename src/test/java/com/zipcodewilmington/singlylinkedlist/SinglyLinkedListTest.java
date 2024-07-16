package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.soap.Node;

import static org.junit.Assert.*;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {


//    You may not use the LinkedList or ArrayList class or any other predefined Java collections
//            Your linked list must have a node inner class to represent each element





//            Your linked list must have add, remove, contains, find, size, get, copy and sort methods
//            Method definitions:
//    add -- add an element to the list

    private SinglyLinkedList<Integer> list;
    @Before
    public void SetUp(){
       list = new SinglyLinkedList<>();
    }


    @Test
    public void addToLinkListTest(){

       list.add(1);
       list.add(5);
       list.add(3);


        int expected=3;
        int actual = list.size();

       assertEquals(expected,actual);

    }

    @Test
    public void removeALinkTest(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);

        int expected = 2;
        assertEquals(expected,list.size);

    }

//    remove -- remove an element (specified by numeric index) from the list

//    contains -- returns true if the element is in the list, false otherwise
    @Test
    public void testContains(){
        list.add(1);
        list.add(2);
        list.add(3);


        assertTrue(list.contains(1));
        assertFalse(list.contains(50));

    }


//    find -- returns the element's index if it is in the list, -1 otherwise
    @Test
    public void testFind(){
        list.add(10);
        list.add(2);
        list.add(3);

        assertEquals(1,list.find(2));
        assertEquals(-1,list.find(7));


    }


//    size -- returns the current size of the list
    @Test
    public void sizeTest(){
        list.add(10);
        list.add(2);
        list.add(3);

        assertEquals(3,list.size);

    }

//    get -- returns the element at the specified index
    @Test
    public void testGet(){
        list.add(10);
        list.add(2);
        list.add(3);

        assertEquals(Integer.valueOf(3),list.get(2));

    }


//    copy -- returns a new linked list containing the same values (look up deep versus shallow copy)
    @Test
    public void testCopy(){
        list.add(10);
        list.add(2);
        list.add(3);

        SinglyLinkedList<Integer> newCopy = list.copy();

        assertEquals(list.size(), newCopy.size());

    }


//    sort -- sorts the list using your algorithm of choice. You must perform the sorting yourself (no fair using someone else's library)
    @Test
    public void sortTest(){
        list.add(10);
        list.add(2);
        list.add(3);
        list.add(55);

        list.sort();

        assertEquals(Integer.valueOf(2), list.get(0));

    }

}
