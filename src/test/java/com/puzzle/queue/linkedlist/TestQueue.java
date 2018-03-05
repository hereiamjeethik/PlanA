package com.puzzle.queue.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class TestQueue {
	
	@Test
	public void validateEnQueue(){
		Queue<Integer> myQueue = new Queue<Integer>();
		myQueue.enQueue(1);
		myQueue.enQueue(2);
		myQueue.enQueue(3);
		myQueue.enQueue(4);
		Assert.assertTrue(myQueue.getFront().equals(1));
		myQueue.deQueue();
		Assert.assertTrue(myQueue.getFront().equals(2));
	}
	
	@Test
	public void validateDeQueue(){
		Queue<Integer> myQueue = new Queue<Integer>();
		myQueue.enQueue(1);
		Assert.assertTrue(myQueue.getFront().equals(1));
		myQueue.deQueue();
		Assert.assertTrue(myQueue.isEmpty() == true);
	}

}
