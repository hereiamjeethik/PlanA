package com.puzzle.stack.impl;

import java.util.Iterator;

import com.puzzle.stack.array.Stack;

public class ReverseStackUsingRecursion {

	public void reverseStack(Stack<Integer> myStack, Stack<Integer> newStack){
		if(myStack.isEmpty()){
			return;
		}else{
			int temp = myStack.pop();
			newStack.push(temp);
			reverseStack(myStack, newStack);
		}
	}
	public static void main(String[] args) {
		Stack<Integer> myStack = new Stack<Integer>();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.push(5);
		Iterator<Integer> iter = myStack.iterator();
		System.out.println("Correct order");
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		ReverseStackUsingRecursion obj = new ReverseStackUsingRecursion();
		Stack<Integer> newStack = new Stack<Integer>();
		obj.reverseStack(myStack, newStack);
		System.out.println("Reverse order");
		Iterator<Integer> iter2 = newStack.iterator();
		while(iter2.hasNext()){
			System.out.println(iter2.next());
		}

	}

}
