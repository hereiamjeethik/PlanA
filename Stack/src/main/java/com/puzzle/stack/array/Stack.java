package com.puzzle.stack.array;

import java.util.Iterator;

public class Stack <Item> implements Iterable<Item>{
	private int top = -1;
	@SuppressWarnings("unchecked")
	private Item[] array = (Item[]) new Object[100];
	
	public boolean isEmpty(){
		if(top == -1){
			return true;
		}else{
			return false;
		}
	}
	
	private boolean isFull(){
		if(top == (array.length -1) ){
			return true;
		}else{
			return false;
		}
	}
	
	public void push(Item newItem){
		if(!this.isFull()){
			array[++top] = newItem;
		}else{
			Item[] newArray = (Item[])new Object[array.length*2];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
			array[++top] = newItem;
		}
	}
	
	public Item pop(){
		if(this.isEmpty()){
			System.out.println("Stack is Empty");
			return null;
		}else{
			return array[top--];
		}
	}
	
	public Item peek(){
		if(this.isEmpty()){
			System.out.println("Stack is Empty");
			return null;
		}else{
			return array[top];
		}
	}

	public Iterator<Item> iterator() {
		Iterator<Item> stackIterator = new Iterator<Item>() {
			int tempTop = top;
			public boolean hasNext() {
				if(tempTop == -1){
					return false;
				}
				return true;
			}

			public Item next() {
				return array[tempTop--];
			}
		};
		return stackIterator;
	}
	
	
}
