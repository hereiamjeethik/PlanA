package com.puzzle.stack.impl;

import java.util.Iterator;

import com.puzzle.stack.queue.Stack;

public class StackImplUsingQueue {

	public static void main(String[] args) {
		Stack<Integer> myStack = new Stack<Integer>();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);
		Iterator<Integer> iter = myStack.iterator();	
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		myStack.pop();
		myStack.pop();
		iter = myStack.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

}
