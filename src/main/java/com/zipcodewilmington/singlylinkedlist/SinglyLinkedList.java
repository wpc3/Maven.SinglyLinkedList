package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList <E extends Comparable<E>> {




    public class Node {
     E data;
     Node next;

     //node constructor
     Node(E data) {
         this.data = data;
         this.next = null;

     }
 }
        //head of the node
        public Node head;

        //list size
        int size;

    public int size() {
        return size;
    }

    //Constructor
   public SinglyLinkedList(){
        head = null;
        size = 0;
   }

    public void add(E i) {
       Node newNode = new Node(i);
       if(head == null){
        head = newNode;
       }
       else {
           Node current = head;
           while (current.next != null){
               current = current.next;
           }
    current.next = newNode;
       }

        size++;
    }

    public void remove(int index) {
       if(index < 0 || index>= size){
           throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
       }
       if(index ==0){
           head = head.next;
       }
       else{
           Node current = head;
           for (int i = 0; i<index-1; i++){
               current = current.next;
           }
           current.next = current.next.next;
       }


        size--;
    }


    public boolean contains(E element) {
        Node current = head;
        while(current != null){
            if (current.data.equals(element)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int find(E element) {
        Node current = head;
        int index = 0;
        while (current != null){
            if (current.data.equals(element)){
                return index;

            }

            current = current.next;
            index++;
        }
        return -1;

        }

    public E get(int index) {
        if(index < 0 || index>= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

            Node current = head;
            for (int i =0; i<index; i++){
                current = current.next;
            }

        return current.data;
    }


    public SinglyLinkedList<E> copy() {
        SinglyLinkedList<E> newCopy = new SinglyLinkedList<>();
        Node current = head;
        while (current != null){
            newCopy.add(current.data);
            current = current.next;
        }
        return newCopy;
    }


    public SinglyLinkedList<E> sort() {
        if (size > 1) {
            boolean swapped;
            do {
                swapped = false;
                Node current = head;
                Node previous = null;
                while (current.next != null) {
                    if (current.data.compareTo(current.next.data) > 0) {
                        Node temp = current.next;
                        current.next = temp.next;
                        temp.next = current;
                        if (previous == null) {
                            head = temp;
                        } else {
                            previous.next = temp;
                        }
                        previous = temp;
                        swapped = true;
                    } else {
                        previous = current;
                        current = current.next;
                    }
                }

            } while (swapped);

        }
        return null;

    }
    }











