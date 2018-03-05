package com.puzzle.stack.queue;

import java.util.Iterator;

import com.puzzle.queue.linkedlist.*;

public class Stack<Item> implements Iterable<Item>{
	private Item top;
	private Queue<Item> myQueue = new Queue<Item>();
	private Queue<Item> tempQueue;
	
	public void push(Item newItem){
		myQueue.enQueue(newItem);
	}
	
	public Item pop(){
		tempQueue = new Queue<Item>();
		Item prev = null;
		while(!myQueue.isEmpty()){
			prev = myQueue.deQueue();
			if(myQueue.isEmpty()){
				myQueue = tempQueue;
				tempQueue = null;
				return prev;
			}else{
				tempQueue.enQueue(prev);
			}
			
		}
		System.out.println("The Stack is empty, so we cannot pop");
		return null;
	}
	
	public Iterator<Item> iterator(){
		Iterator<Item> iter= null;
		try {
			iter = new Iterator<Item>(){
				private Queue<Item> queue  = (Queue<Item>)myQueue.clone();
				public boolean hasNext() {
					if(queue.isEmpty()){
						return false;
					}
					return true;
				}

				public Item next() {
					return queue.deQueue();
					
				}
				
			};
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return iter;
	}
}
