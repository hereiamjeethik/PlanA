package com.puzzle.stack.linkedlist;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import com.puzzle.stack.linkedlist.Stack;

public class TestListStack {
	@Test
	public void validatingPush(){
		String name ="Karthik";
		Stack<String> nameStack = new Stack<String>();
		Assert.assertTrue(nameStack.isEmpty());
		nameStack.push(name);
		Assert.assertTrue(nameStack.peek().equals("Karthik"));
		Assert.assertFalse(nameStack.isEmpty());
	}
	
	@Test
	public void validatingPop(){
		Integer serialNumber = 1;
		Stack<Integer> numberStack = new Stack<Integer>();
		Assert.assertTrue(numberStack.isEmpty());
		numberStack.push(serialNumber);
		Assert.assertFalse(numberStack.isEmpty());
		Assert.assertTrue(numberStack.pop().equals(1));
		Assert.assertTrue(numberStack.pop() == null);
	}
	
	@Test
	public void validatingPeek(){
		Stack<Integer> intStack1 = new Stack<Integer>();
		Stack<Integer> intStack2 = new Stack<Integer>();
		intStack1.push(1);
		intStack1.push(2);
		intStack1.push(3);
		intStack2.push(4);
		intStack2.push(5);
		intStack2.push(6);
		
		Stack<Stack<Integer>> stackOfStack = new Stack<Stack<Integer>>();
		stackOfStack.push(intStack1);
		stackOfStack.push(intStack2);
		Assert.assertTrue(stackOfStack.peek() instanceof Stack);
	}
	
	@Test 
	public void validatingIterator(){
		Stack<Integer> numStack = new Stack<Integer>();
		numStack.push(1);
		numStack.push(2);
		numStack.push(3);
		numStack.push(4);
		Iterator<Integer> stackIterator = numStack.iterator();
		System.out.println("Validating Iterator");
		while(stackIterator.hasNext()){
			System.out.println(stackIterator.next());
		}
		Assert.assertFalse(stackIterator.hasNext());
	}
	

}
