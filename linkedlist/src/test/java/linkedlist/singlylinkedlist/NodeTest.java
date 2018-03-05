package linkedlist.singlylinkedlist;

import org.junit.*;
import org.junit.Test;

public class NodeTest {
	
	@Test
	public void testEquals(){
		Node<Integer> node1 = new Node<Integer>();
		Node<Integer> node2 = new Node<Integer>();
		node1.setItem(1);
		node2.setItem(1);
		Assert.assertTrue(node1.equals(node2));
	}
	
	@Test
	public void testCompare(){
		Node<Integer> node1 = new Node<Integer>();
		Node<Integer> node2 = new Node<Integer>();
		node1.setItem(1);
		node2.setItem(1);
		Assert.assertTrue(node1.compareTo(node2) == 0);
	}
}
