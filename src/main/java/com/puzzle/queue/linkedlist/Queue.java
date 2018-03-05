package com.puzzle.queue.linkedlist;

import java.util.Iterator;

import linkedlist.singlylinkedlist.Node;
import linkedlist.singlylinkedlist.SinglyLinkedList;

public class Queue<Item> implements Iterable<Item>, Cloneable{
	private SinglyLinkedList<Item> myQueue = new SinglyLinkedList<Item>();
	
	public Item getFront(){
		return myQueue.getList().getItem();
	}
		
	public void enQueue(Item item){
		myQueue.insertNodeAtEnd(new Node<Item>(item));
	}
	
	public Item deQueue(){
		if(this.isEmpty()){
			System.out.println("The Queue is empty, we cannot dequeue");
			return null;
		}else{
			Item deletedItem = myQueue.getList().getItem();
			myQueue.deleteNodeUsingPosition(0);
			return deletedItem;
		}
	}
	
	public boolean isEmpty(){
		if(myQueue.getList() == null){
			return true;
		}else{
			return false;
		}
	}
	
	public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


	public Iterator<Item> iterator() {
		Iterator<Item> myIterator = new Iterator<Item>() {
			private int listLength = myQueue.getLengthIteratively();
			private int currPos = 0;
			public boolean hasNext() {
				if(currPos < listLength){
					return true;
				}else{
					return false;
				}
			}
	
			public Item next() {
				return myQueue.getNthNode(currPos++).getItem();
			}
	
			public void remove() {
				// TODO Auto-generated method stub
				
			}
		
	};
		return myIterator;
	}
}
