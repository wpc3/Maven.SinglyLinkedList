package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList <E extends Comparable<E>> {



//Inner class we need to make to create a node
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

        //Getting a method for the size of our list
    public int size() {
        return size;
    }

    //Constructor
   public SinglyLinkedList(){
        head = null;
        size = 0;
   }

    public void add(E i) {
       Node newNode = new Node(i);//Create a new node with data "i"
       if(head == null){
        head = newNode;//if list is empty, head is new node
       }
       else {
           Node current = head;//else if list is not empty, start from "Head"
           while (current.next != null){//"Travesing" to the end of the list
               current = current.next;
           }
    current.next = newNode;//Add newNode to end of list
       }

        size++;//Increment size of the list by each new node
    }

    public void remove(int index) {
       if(index < 0 || index>= size){
           throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);//Checking if our index is out of bounds
       }//Removing the first node
       if(index ==0){
           head = head.next; //Move head to next node,which will remove the current head
       }
       else{//Removing if index is greater than 0
           Node current = head;
           for (int i = 0; i<index-1; i++){//Traverse to the node just before the one to be removed
               current = current.next;
           }
           current.next = current.next.next;//Update the currents next reference to skip ove the node we removed
       }


        size--;
    }


    public boolean contains(E element) {
        Node current = head; //Start from the head of the list
        while(current != null){//Traverse the list until you get to the end
            if (current.data.equals(element)){//Checking if the current node's data matches the element
                return true;
            }
            current = current.next; //If it doesnt, move to the next node
        }
        return false;
    }

    public int find(E element) {
        Node current = head;
        int index = 0;//index counter
        while (current != null){
            if (current.data.equals(element)){//Checking if the current node's index matches element
                return index;

            }

            current = current.next;//Move to the next node if it doesn't
            index++;//increment the index as you move through the nodes
        }
        return -1;

        }

    public E get(int index) {
        if(index < 0 || index>= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

            Node current = head;
            for (int i =0; i<index; i++){//Traverse through the list until we get the index we're looking for
                current = current.next;//Moving to the next node
            }

        return current.data; //Return the data of the node at the specified index
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
        if (size > 1) {//Check if there is more than one element in the list
            boolean swapped; //Flag to track if any elements were swapped
            do {
                swapped = false; //Initialize swapped to false to start our iteration
                Node current = head;
                Node previous = null; //Track the previous node during traversal
                while (current.next != null) {
                    if (current.data.compareTo(current.next.data) > 0) {//Compare current and next node's data
                        Node temp = current.next;//Swap current and next nodes
                        current.next = temp.next;
                        temp.next = current;
                        if (previous == null) {//Update previous node's next reference
                            head = temp; //update the head if swapping the first element
                        } else {
                            previous.next = temp; //Link the previous node to the new node after swapped
                        }
                        previous = temp; //Update the previous to the swapped node
                        swapped = true; //Set swap to true
                    } else {
                        previous = current; //Move previous and current pointer forward
                        current = current.next;
                    }
                }

            } while (swapped); //Continue swapping while swaps were made in this pass

        }
        return null; //Set null as the placeholder

    }
    }











