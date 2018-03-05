package com.puzzle.stack.linkedlist;

import java.util.Iterator;

import linkedlist.singlylinkedlist.Node;
import linkedlist.singlylinkedlist.SinglyLinkedList;

public class Stack <Item> implements Iterable<Item>{
	private Node<Item> top;
	private SinglyLinkedList<Item> list = new SinglyLinkedList<Item>();
	
	public boolean isEmpty(){
		if(top == null){
			return true;
		}else{
			return false;
		}
	}
	
	public void push(Item newItem){
		Node<Item> newNode = new Node<Item>(newItem);
		list.insertNode(newNode, 0);
		top = list.getList();
	}
	
	public Item pop(){
		if(isEmpty()){
			System.out.println("The stack is empty, so we cannot pop further");
			return null;
		}else{
			Node<Item> topNode = list.getList();
			topNode.setNext(null);
			list.deleteNodeUsingPosition(0);
			top = list.getList();
			return topNode.getItem();
		}
	}
	
	public Item peek(){
		if(isEmpty()){
			System.out.println("The Stack is empty, so we don't have any peek");
			return null;
		}else{
			Node<Item> topNode = list.getList();
			return topNode.getItem();
		}
	}

	public Iterator<Item> iterator() {
		Iterator<Item> listIterator = new Iterator<Item>() {
			Node<Item> tempTop = top;
			public boolean hasNext() {
				if(tempTop == null){
					return false;
				}else{
					return true;
				}
				
			}

			public Item next() {
				Node<Item> returnItem = tempTop;
				tempTop = tempTop.getNext();
				return returnItem.getItem();
			}

			public void remove() {
				// TODO Auto-generated method stub
				
			}
		};
		return listIterator;
	}
	
	
}
