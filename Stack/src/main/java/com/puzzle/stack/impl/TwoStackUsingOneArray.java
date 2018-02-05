package com.puzzle.stack.impl;

import java.util.Iterator;

public class TwoStackUsingOneArray <Item> implements Iterable<Item> {
	
	private Item[] array = (Item[]) new Object[100];
	private int top1 = -1;
	private int top2 = array.length;
	
	public synchronized void s1push(Item newItem){
		if(top1+1 == top2){
			System.out.println("The stack is full");
		}else{
			array[++top1] = newItem;
		}
	}
	
	public synchronized void s2push(Item newItem){
		if(top2-1 == top1){
			System.out.println("The stack is full");
		}else{
			array[--top2] = newItem;
		}
	}
	
	public synchronized Item s1pop(){
		if(top1 == -1){
			System.out.println("The stack is empty");
			return null;
		}else{
			return array[top1--];
		}
	}
	
	public synchronized Item s2pop(){
		if(top2 == array.length){
			System.out.println("The stack is empty");
			return null;
		}else{
			return array[top2++];
		}
	}
	
	public synchronized Item s1peek(){
		if(top1 == -1){
			System.out.println("The stack is empty");
			return null;
		}else{
			return array[top1];
		}
	}
	
	public synchronized Item s2peek(){
		if(top2 == array.length){
			System.out.println("The stack is empty");
			return null;
		}else{
			return array[top2];
		}
	}
			

	public Iterator<Item> iterator() {
		Iterator<Item> myIterator = new Iterator<Item>(){
			int tempTop1 = top1;
			int tempTop2 = top2;
			
			public boolean hasNext() {
				if(tempTop1 > -1 || tempTop2 < array.length){
					return true;
				}else{
					return false;
				}
				
			}

			public Item next() {
				if(tempTop1 > -1){
					return array[tempTop1--];
				}else if(tempTop2 < array.length){
					return array[tempTop2++];
				}
				return null;
			}
			
		};
		return myIterator;
	}

	public static void main(String[] args) {
		TwoStackUsingOneArray<Integer> myStack = new TwoStackUsingOneArray<Integer>();
		myStack.s1push(1);
		myStack.s1push(2);
		myStack.s1push(3);
		myStack.s1push(4);
		System.out.println("Peek of Stack1 is : "+myStack.s1peek());
		System.out.println("Peek of Stack2 is : "+myStack.s2peek());
		myStack.s2push(100);
		myStack.s2push(99);
		myStack.s2push(98);
		System.out.println("Peek of Stack2 is : "+myStack.s2peek());
		Iterator<Integer> iter = myStack.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}
