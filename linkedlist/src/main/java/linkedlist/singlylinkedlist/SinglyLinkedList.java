/**
 * 
 */
package linkedlist.singlylinkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author hereiamkarthik@gmail.com
 * TODO 1: Do the Iterator.
 * TODO 2: Do the Thread-Safe code.
 * TODO 3: write unit test cases for all the functions and cases.
 * TODO 4: There is a bug in the code, which needs to be fixed
 * TODO : Recursively finding whether the list is palindrome or not
 *
 */
public class SinglyLinkedList<T> implements Iterable<T> {
	private Node<T> head;
	
	/**
	 * This method returns the head of the linked list
	 * @return
	 */
	public Node<T> getList(){
		return head;
	}
	
	/**
	 * @param newNode, position
	 * newNode is the node to be inserted in the specified position
	 * 
	 * Cases Covered as part of insertion are
	 * 1.	insert at the head
	 * 2.	insert at the middle
	 * 3. 	insert at the end
	 * 4.	insert by giving a position which is very high than the actual length of the list
	 * 
	 */
	public Node<T> insertNode(Node<T> newNode, int position){
		System.out.println("Inserting node "+newNode.getItem()+" in position "+position);
		if(head == null){
			head = newNode;
		}else{
			if(position >= 0){
				int currPos = 0; Node<T> currNode = head, prevNode = null;
				while(currPos < position && currNode != null){
					prevNode = currNode;
					currNode = currNode.getNext();
					currPos++;
				}
				if(currPos == position){
					if(currNode != null){
						Node<T> temp=currNode;
						if(prevNode == null){
							head = newNode;
							newNode.setNext(temp);
						}else{
							prevNode.setNext(newNode);
						}
						newNode.setNext(temp);
					}else{
						prevNode.setNext(newNode);
					}
				}else{
					prevNode.setNext(newNode);
				}
				
			}else{
				throw new RuntimeException("position cannot be in negative");
			}
		}
		
		return head;
	}
	
	
	/**
	 * @param t
	 * 
	 * t is the key that needs to be deleted
	 * 
	 * This method doesn't check for the duplicates. 
	 * Cases that are handled as part of the deletion are
	 * 1.	Delete the node in head
	 * 2.	Delete the node in middle
	 * 3.	Delete the node is tail
	 * 
	 */
	public void deleteNodeUsingKey(T t){
		System.out.println("Deleting node "+t);
		Node<T> currNode = head, prevNode = null;
		while(currNode != null){
			if(currNode.getItem().equals(t)){
				if(prevNode == null){
					head = currNode.getNext();
				}else{
					prevNode.setNext(currNode.getNext());
				}
				return;
			}else{
				prevNode = currNode;
				currNode = currNode.getNext();
			}
		}
	}
	
	/**
	 * @param t, deleteAll, deleteFirst, deleteLast, deleteMiddle, deleteOdd
	 * t is the key that needs to be deleted
	 * if deleteAll is set to true, then delete all the duplicates
	 * if deleteFirst is set to true, it will delete the first node 
	 * if deleteLast is set to true, it will delete the last node
	 * if deleteMiddle is set to true, it will delete the middle node
	 * if deleteOdd is set to true, then it will delete all the odd duplicates
	 * if all are set to false, then deleteEven, then it will delete all the even duplicates
	 * 
	 * This method checks for the duplicates and it handles the below cases
	 * 1.	Remove the first element of the duplicates
	 * 2.	Remove the last element of the duplicates
	 * 3.	Remove the middle element of the duplicates
	 * 4.	Remove the odd/even number of duplicate elements
	 * 		a.	collect all the duplicates and remove only the elements that are occurred in odd/even numbers
	 * 
	 * TODO : removing middle element of all the duplicates
	 */
	public void deleteDuplicateNodeUsingKey(T t, boolean deleteAll, boolean deleteFirst, boolean deleteLast, boolean deleteMiddle, boolean deleteOdd){
		Node<T> currNode = head, prevNode = null, prevToLastNode = null;
		if(deleteAll){
			while(currNode != null){
				if(currNode.getItem().equals(t)){
					if(prevNode == null){
						head = currNode.getNext();
					}else{
						prevNode.setNext(currNode.getNext());
					}
					currNode = currNode.getNext();
				}else{
					prevNode = currNode;
					currNode = currNode.getNext();
				}
			}
			System.out.println("Deleting All the duplicated element "+t);
			return;
		}else if(deleteFirst){
			deleteNodeUsingKey(t);
			System.out.println("Deleting the first duplicated element "+t);
			return;
		}else if(deleteLast){
			while(currNode != null){
				if(currNode.getItem().equals(t)){
					prevToLastNode = prevNode;
					prevNode = currNode;
					currNode = currNode.getNext();
				}else{
					prevNode = currNode;
					currNode = currNode.getNext();
				}
			}
			if(prevToLastNode == null){
				head = head.getNext();
			}else{
				Node<T> nodeToBeDeleted = prevToLastNode.getNext();
				if(nodeToBeDeleted == null){ // node to be deleted is never be null, but if we have only one node.
					prevToLastNode.setNext(null);
				}else{
					prevToLastNode.setNext(nodeToBeDeleted.getNext());
				}
				
			}
			System.out.println("Deleting the last duplicated element "+t);
			
			return;
		}else if(deleteOdd){
			boolean odd = false;
			while(currNode != null){
				if(currNode.getItem().equals(t)){
					if(odd){
						if(prevNode == null){
							head = currNode.getNext();
						}else{
							prevNode.setNext(currNode.getNext());
						}
						currNode = currNode.getNext();
						odd = false;
					}else{
						odd = true;
						prevNode = currNode;
						currNode = currNode.getNext();
					}
				}else{
					prevNode = currNode;
					currNode = currNode.getNext();
				}
			}
			System.out.println("Deleting the odd duplicated element "+t);
			return;
		}else{
			boolean even = true;
			while(currNode != null){
				if(currNode.getItem().equals(t)){
					if(even){
						if(prevNode == null){
							head = currNode.getNext();
						}else{
							prevNode.setNext(currNode.getNext());
						}
						currNode = currNode.getNext();
						even = false;
					}else{
						even = true;
						prevNode = currNode;
						currNode = currNode.getNext();
					}
				}else{
					prevNode = currNode;
					currNode = currNode.getNext();
				}
			}
			System.out.println("Deleting the even duplicated element "+t);
			return;
		}
	}
	
	/**
	 * @param position
	 * position is denoting the position of the elements that needs to be deleted.
	 * 
	 */
	public void deleteNodeUsingPosition(int position){
		int currPos = 0;
		Node<T> currNode = head, prevNode = null;
		while(currPos < position && currNode != null){
			prevNode = currNode;
			currNode = currNode.getNext();
			currPos++;
		}
		if(currPos == position){
			if(currNode != null){
				if(prevNode == null){
					head = currNode.getNext();
				}else{
					prevNode.setNext(currNode.getNext());
				}
			}else{
				throw new RuntimeException("Position is greater than the length of the list");
			}
			
		}else{
			throw new RuntimeException("Position is greater than the length of the list");
		}
	}
	
	
	
	/**
	 * This method finds the length of the list iteratively.
	 */
	public int getLengthIteratively(){
		if(head == null){
			return 0;
		}else{
			Node<T> currNode = head; int count = 0;
			while(currNode != null){
				currNode= currNode.getNext();
				count++;
			}
			return count;
		}
	}
	
	/**
	 * This method finds length of the list recursively.
	 */
	public int getLengthRecursively(){
		Node<T> currNode = head;
		int count = 0;
		count = getLength(currNode);
		return count;
	}
	
	/**
	 * Recursive code to find the length
	 * 
	 */
	private int getLength(Node<T> currNode){
		if(currNode == null){
			return 0;
		}else{
			return 1+getLength(currNode.getNext());
		}
	}
	
	/**
	 * This method searches the element in the list iteratively
	 * @param t is the value to be searched 
	 * @return Node is the Node that has the value that we are searching
	 */
	public Node<T> searchIteratively(T t){
		System.out.println("Searching iteratively the value: "+t);
		Node<T> currNode = head;
		if(currNode == null){
			return null;
		}else{
			while(currNode != null){
				if(currNode.getItem().equals(t)){
					return currNode;
				}else{
					currNode = currNode.getNext();
				}
			}
			
			return null;
		}
	}
	
	/**
	 * This method searches the element in the list recursively
	 * @param t
	 * @return
	 */
	public Node<T> searchRecursively(T t){
		System.out.println("Searching iteratively the value: "+t);
		Node<T> currNode = head;
		return search(currNode,t);
	}
	
	/**
	 * This is the recursive call to search an element
	 * @param currNode
	 * @param value
	 * @return
	 */
	private Node<T> search(Node<T> currNode, T value){
		if(currNode == null){
			return null;
		}else{
			if(currNode.getItem().equals(value)){
				return currNode;
			}else{
				return search(currNode.getNext(), value);
			}
		}
	}
	
	/**
	 * swap nodes in the list without swapping data
	 * @param t1
	 * @param t2
	 * 
	 * Cases that are handled is
	 * 1.	One of the node is head
	 * 2.	One of the node is tail
	 * 3.	If only 2 nodes are there
	 * 4.	if nodes are adjacent to each other
	 * 5.	if nodes are not adjacent
	 */
	public void swap(T t1, T t2){
		System.out.println("Swapping "+t1+" "+t2);
		Node<T> currNode = head, prevNode = null, firstPrevNode = null, secondPrevNode = null;
		boolean isFirstNode = true;
		while(currNode != null){
			if(currNode.getItem().equals(t1) || currNode.getItem().equals(t2)){
				if(isFirstNode){
					firstPrevNode = prevNode;
					isFirstNode = false;
				}else{
					secondPrevNode = prevNode;
					break;
				}
			}
			prevNode = currNode;
			currNode = currNode.getNext();
		}
		if(firstPrevNode != null){   // first node is not the head
			if(secondPrevNode.equals(firstPrevNode.getNext())){
				firstPrevNode.setNext(secondPrevNode.getNext());
				secondPrevNode.setNext(secondPrevNode.getNext().getNext());
				firstPrevNode.getNext().setNext(secondPrevNode);
			}else{
				Node<T> temp1 = firstPrevNode.getNext();
				Node<T> temp2 = temp1.getNext();
				Node<T> temp3 = secondPrevNode.getNext();
				Node<T> temp4 = temp3.getNext();
				
				firstPrevNode.setNext(temp3);
				temp3.setNext(temp2);
				secondPrevNode.setNext(temp1);
				temp1.setNext(temp4);
			}
		}else{  // first node is the head
			if(secondPrevNode.equals(head)){
				head = secondPrevNode.getNext();
				secondPrevNode.setNext(head.getNext());
				head.setNext(secondPrevNode);
			}else{
				Node<T> temp1 = head;
				Node<T> temp2 = temp1.getNext();
				Node<T> temp3 = secondPrevNode.getNext();
				Node<T> temp4 = temp3.getNext();
				
				head = temp3;
				temp3.setNext(temp2);
				secondPrevNode.setNext(temp1);
				temp1.setNext(temp4);
				
			}
		}
	}
	
	/**
	 * This method returns the Node at the given position
	 * 
	 * @param position, this specifies the position of the node that needs to be returned
	 * @return Node, the Node in position given is returned.
	 */
	public Node<T> getNthNode(int position){
		int currPos = 0;
		Node<T> currNode = head;
		if(currNode == null || position > getLength(currNode)){
			return null;
		}else{
			while(currNode != null && currPos < position){
				currNode = currNode.getNext();
				currPos++;
			}
			System.out.println("The Node "+currNode+ " is in position "+position);
			return currNode;
		}
		
	}
	
	/**
	 * This method returns the middle of the given list
	 * 
	 * @param firstMiddle, it is true, if you want the first node of the middle. in case of even numbered list
	 * @return
	 */
	public Node<T> getMiddleNodeFromList(boolean firstMiddle){
		
		Node<T> oneStepPtr = head, twoStepPtr = head;
		while(twoStepPtr != null && twoStepPtr.getNext() != null){
			twoStepPtr = twoStepPtr.getNext().getNext();
			if(firstMiddle && twoStepPtr == null){
				System.out.println("First Middle Element of the list is "+oneStepPtr);
				return oneStepPtr;
			}else if(firstMiddle){
				oneStepPtr = oneStepPtr.getNext();
			}else{
				oneStepPtr = oneStepPtr.getNext();
			}
		}
		System.out.println("Middle Element of the list is "+oneStepPtr);
		return oneStepPtr;
	}
	
	/**
	 * 
	 * @param position, the position of element from end
	 * @return the Node at position from the end
	 */
	public Node<T> getNthNodeFromEnd(int position){
		Node<T> currNode = head, ptrNode = null;
		int currPos = 0;
		while(currNode != null){
			if(currPos >= position){
				if(ptrNode == null){
					ptrNode=head;
				}else{
					ptrNode=ptrNode.getNext();
				}
			}
			currPos++;
			currNode = currNode.getNext();
		}
		System.out.println(position+"th Node from the End is :"+ptrNode);
		return ptrNode;
	}
	
	/***
	 * This method returns the number of occurrences of a key in the list
	 * 
	 * @param t
	 * @return
	 */
	public int getNumberOfKeyOccurrence(T t){
		Node<T> currNode = head;
		int count = 0;
		while(currNode != null){
			if(currNode.getItem().equals(t)){
				count++;
			}
			currNode = currNode.getNext();
		}
		System.out.println(t+" occurred "+count+" time(s)");
		return count;
	}
	
	
	/**
	 * This method reverses the linked list iteratively
	 */
	public void reverseList(){
		System.out.println("Reversing the linked list");
		Node<T> currNode = head, prevNode = null, nextNode = null;
		while(currNode != null){
			nextNode = currNode.getNext();
			currNode.setNext(prevNode);
			prevNode = currNode;
			if(nextNode == null){
				head = currNode;
				return;
			}else{
				currNode = nextNode;
			}
		}
	}
	
	
	/**
	 * This method reverses the linked list recursively
	 */
	public void reverseRecursively(){
		System.out.println("Reversing the list recursively");
		Node<T> currNode = head;
		if(currNode != null){
			reverse(currNode);
			currNode.setNext(null);
		}
	}
	
	/**
	 * This is a private method to reverse
	 * @param currNode
	 * @return
	 */
	private Node<T> reverse(Node<T> currNode){
		if(currNode.getNext() == null){
			head = currNode;
			return currNode;
		}else{
			Node<T> prevNode = reverse(currNode.getNext());
			prevNode.setNext(currNode);
			return currNode;
		}
	}
	
	/**
	 * This method returns true when there is a cyscle, otherwise false.
	 * @return boolean
	 */
	public boolean isCyclicList(){
		System.out.println("Checking for Cycle in the list");
		Node<T> currNode = head,oneStepPtr = head,twoStepPtr = head;
		while(twoStepPtr != null && twoStepPtr.getNext() != null){
			oneStepPtr = oneStepPtr.getNext();
			twoStepPtr = twoStepPtr.getNext().getNext();
			if(oneStepPtr == twoStepPtr){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * TODO: need to understand why generic is not working here
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static SinglyLinkedList<Integer> mergeSortedList (SinglyLinkedList<Integer> list1, SinglyLinkedList<Integer> list2){
		System.out.println("Merging the Sorted linked list iteratively");
		SinglyLinkedList<Integer> mergedList = new SinglyLinkedList<Integer>();
		if(list1 == null){
			return mergedList = list2;
		}else if(list2 == null){
			return mergedList = list1;
		}else{
			Node<Integer> curr1 = list1.getList();
			Node<Integer> curr2 = list2.getList();
			while(curr1 != null && curr2 != null){
				if(curr1.getItem() > curr2.getItem()){
					mergedList.insertNode(new Node<Integer>(curr2.getItem()), Integer.MAX_VALUE);
					curr2 = curr2.getNext();
				}else{
					mergedList.insertNode(new Node<Integer>(curr1.getItem()), Integer.MAX_VALUE);
					curr1= curr1.getNext();
				}
			}
			
			if(curr1 == null){
				while(curr2 != null){
					mergedList.insertNode(new Node<Integer>(curr2.getItem()), Integer.MAX_VALUE);
					curr2 = curr2.getNext();
				}
			}else{
				while(curr1 != null){
					mergedList.insertNode(new Node<Integer>(curr1.getItem()), Integer.MAX_VALUE);
					curr1 = curr1.getNext();
				}
			}
		}
		
		return mergedList;
	}
	
	/**
	 * This method returns the merged linked list of 2 sorted list
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Node<Integer> mergeSortedListRecursively(Node<Integer> head1, Node<Integer> head2){
		if(head1 == null){
			return head2;
		}else if(head2 == null){
			return head1;
		}else{
			if(head1.getItem() < head2.getItem()){
				head1.setNext(mergeSortedListRecursively(head1.getNext(), head2));
				return head1;
			}else{
				head2.setNext(mergeSortedListRecursively(head1, head2.getNext()));
				return head2;
			}
		}
	}
	
	/**
	 * This method inserts a node in the sorted linked list and preserves the sorting after insertion
	 * @param head
	 * @param newNode
	 * @return
	 */
	public Node<Integer> sortedInsertion(Node<Integer> head, Node<Integer> newNode){
		System.out.println("Inserting the value : "+newNode.getItem()+" in the sorted list");
		Node<Integer> currNode = head, prevNode = null;
		while(currNode != null){
			if(currNode.getItem() > newNode.getItem()){
				if(prevNode == null){
					newNode.setNext(currNode);
					return newNode;
				}else{
					prevNode.setNext(newNode);
					newNode.setNext(currNode);
					return head;
				}
			}else{
				prevNode = currNode;
				currNode = currNode.getNext();
			}
		}
		return head;
	}
	
	/**
	 * This method checks whether the given list is palindrome or not
	 * @return
	 */
	public boolean isPalindrom(){
		System.out.println("Checking whether the list is palindrom or not");
		Node<T>  oneStepPtr = head, twoStepPtr = head;
		List<Integer> list = new ArrayList<Integer>();
		if(head == null){
			return true;
		}else{
			list.add((Integer)oneStepPtr.getItem());
			while(twoStepPtr != null && twoStepPtr.getNext() != null){
				oneStepPtr = oneStepPtr.getNext();
				twoStepPtr = twoStepPtr.getNext().getNext();
				list.add((Integer)oneStepPtr.getItem());
			}
			if(twoStepPtr == null){
				list.remove(list.size()-1);
			}
			
			for(int i=list.size()-1;i>=0;i--){
				if(list.remove(i).equals(oneStepPtr.getItem())){
					oneStepPtr = oneStepPtr.getNext();
				}
			}
			if(oneStepPtr == null && list.isEmpty()){
				return true;
			}else{
				return false;
			}
		}
	}
	
	/**
	 * This method returns Node where the 2 linked list intersect
	 * @param sll1
	 * @param sll2
	 * @return
	 */
	public Node<T> getIntersectionOf2List(SinglyLinkedList<T> sll1, SinglyLinkedList<T> sll2){
		int len1 = sll1.getLengthIteratively();
		int len2 = sll2.getLengthIteratively();
		Node<T> curr1 = sll1.getList();
		Node<T> curr2 = sll2.getList();
		if(len1 > len2){
			int diff = len1-len2;
			int i=0;
			while(i<diff){
				curr1 = curr1.getNext();
				i++;
			}
		}else if(len1 < len2){
			int diff = len2-len1;
			int i=0;
			while(i<diff){
				curr2 = curr2.getNext();
				i++;
			}
		}
		
		while(curr1 != null && curr2 != null){
			if(curr1 == curr2){
				return curr1;
			}else{
				curr1 = curr1.getNext();
				curr2 = curr2.getNext();
			}
		}
		System.out.println("There is no intersection points");
		return null;
	}
	
	public void printList(){
		Node<T> currNode = head;
		System.out.println("Printing the list of nodes");
		if(currNode == null){
			System.out.println("no nodes");
		}else{
			while(currNode != null){
				System.out.print(currNode.getItem()+" --> ");
				currNode= currNode.getNext();
			}
			System.out.println("");
		}
		
		
	}
	
	public void printList(Node<T> head){
		Node<T> currNode = head;
		System.out.println("Printing the list of nodes");
		if(currNode == null){
			System.out.println("no nodes");
		}else{
			while(currNode != null){
				System.out.print(currNode.getItem()+" --> ");
				currNode= currNode.getNext();
			}
			System.out.println("");
		}
		
		
	}
	
	/**
	 * print the list in a reverse order
	 * @param head
	 */
	public void printReverse(Node<T> head){
		System.out.println("Printing the list in reverse order");
		if(head == null){
			System.out.println("no nodes");
		}else{
			System.out.println(printReverseRecursive(head)+" --> ");
		}
	}
	
	/**
	 * Private method to print the method in reverse order
	 * @param currNode
	 * @return
	 */
	private Node<T> printReverseRecursive(Node<T> currNode){
		if(currNode.getNext() == null){
			return currNode;
		}else{
			Node<T> node = printReverseRecursive(currNode.getNext());
			System.out.print(node+" --> ");
			return currNode;
		}
	}
	
	/**
	 * This method removes duplicates from sorted linked list
	 */
	public void removeDuplicatedFromSortedList(Node<T> head){
		System.out.println("Removing Duplicates from sorted linked list");
		Node<T> currNode = head;
		while(currNode != null){
			if(currNode.getNext() == null) return;
			else{
				if(currNode.getItem().equals(currNode.getNext().getItem())){
					currNode.setNext(currNode.getNext().getNext());
				}else{
					currNode = currNode.getNext();
				}
			}
			
		}
	}
	
	/**
	 * This method removes the duplicates from unsorted linked list
	 * @param head
	 */
	public void removeDuplicateFromUnsortedList(Node<Integer> head){
		System.out.println("Removing the Duplicates from unsorted linked list");
		Node<Integer> currNode = head, prevNode = null;
		Map<Integer, Boolean> mapData = new HashMap<Integer, Boolean>();
		while(currNode != null){
			if(mapData.get(currNode.getItem()) == null){
				mapData.put(currNode.getItem(), true);
				prevNode = currNode;
				currNode = currNode.getNext();
			}else{
				prevNode.setNext(currNode.getNext());
				currNode = currNode.getNext();
			}
		}
	}
	
	/**
	 * This method will swap the list pairwise
	 * @param head
	 */
	public void pairwiseSwapping(Node<T> head){
		System.out.println("Pairwise swapping the list");
		Node<T> currNode = head, prevNode = null, nextNode = null, temp = null;
		while(currNode != null){
			nextNode = currNode.getNext();
			if(nextNode != null){
				temp = nextNode.getNext();
			}else{
				return;
			}
			
			if(prevNode == null){
				this.head = nextNode;
				nextNode.setNext(currNode);
				currNode.setNext(temp);
				prevNode = currNode;
				currNode = temp;
			}else{
				prevNode.setNext(nextNode);
				nextNode.setNext(currNode);
				currNode.setNext(temp);
				prevNode = currNode;
				currNode = temp;
			}
		}
	}
	
	/**
	 * This method will recursively swap the elements pairwise
	 * @param head
	 */
	public void pairwiseSwappingRecursively(Node<T> head){
		System.out.println("Recursively swapping the list pairwise");
		if(head != null && head.getNext() != null){
			this.head = pairwiseSwappingRecursively(head, head.getNext());
		}
	}
	
	/**
	 * This method is the utility for recursion
	 * @param currNode
	 * @param nextNode
	 * @return
	 */
	private Node<T> pairwiseSwappingRecursively(Node<T> currNode, Node<T> nextNode){
		if(currNode == null || nextNode == null ){
			return currNode;
		}else{
			if(nextNode.getNext() != null){
				Node<T> node = pairwiseSwappingRecursively(nextNode.getNext(), nextNode.getNext().getNext());
				nextNode.setNext(currNode);
				currNode.setNext(node);
				return nextNode;
			}else{
				nextNode.setNext(currNode);
				currNode.setNext(null);
				return nextNode;
			}
		}
	}
	
	/**
	 * This method removes the last element and move it to front
	 * @param head
	 */
	public void moveLastNodeToFirst(Node<T> head){
		System.out.println("Moving the Last element to the front");
		Node<T> currNode=head, prevNode = null;
		if(currNode != null){
			while(currNode.getNext() != null){
				prevNode = currNode;
				currNode = currNode.getNext();
			}
			 prevNode.setNext(null);
			 currNode.setNext(head);
			 this.head = currNode;
		}
	}
	
	/**
	 * Intersection of two sorted linked list
	 * @param head1
	 * @param head2
	 * @return
	 */
	public Node<Integer> intersectionOfList(Node<Integer> head1, Node<Integer> head2){
		System.out.println("Intersection of 2 sorted linked list");
		Node<Integer> curr1 = head1;
		Node<Integer> curr2 = head2;
		Node<Integer> newCurr = null, newHead = null;
		while(curr1 != null && curr2 != null){
			if(curr1.getItem().equals(curr2.getItem())){
				if(newCurr != null){
					newCurr.setNext(new Node(curr1.getItem()));
					newCurr = newCurr.getNext();
				}else{
					newCurr = new Node(curr1.getItem());
					newHead = newCurr;
				}
				curr1=curr1.getNext();
				curr2=curr2.getNext();
			}else if(curr1.getItem() < curr2.getItem()){
				curr1=curr1.getNext();
			}else{
				curr2=curr2.getNext();
			}
		}
		return newHead;
	}
	
	/**
	 * This method deleted the alternate note in the linked list
	 */
	public void deleteAlternateNode(){
		System.out.println("Deleting alternate nodes in linked list");
		Node<T> currNode = head;
		while(currNode != null && currNode.getNext() != null){
			currNode.setNext(currNode.getNext().getNext());
			currNode = currNode.getNext();
		}
	}
	
	/**
	 * This nodes deletes the alternate node recursively
	 * @param currNode
	 */
	public Node<T> deleteAlternateNodeRecursively(Node<T> currNode){
		if(currNode == null){
			return null;
		}else if(currNode.getNext() == null){
			return currNode;
		}else{
			currNode.setNext(deleteAlternateNodeRecursively(currNode.getNext().getNext()));
			return currNode;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> node1 = new Node<Integer>(1);
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.insertNode(node1, 2); // insert into head when there are no node
		sll.printList();
		sll.deleteNodeUsingKey(1); // delete the head node, when only that element is available
		sll.printList();
		sll.insertNode(node1, 2);
		sll.printList();
		Node<Integer> node2 = new Node<Integer>(2);
		sll.insertNode(node2, 0); // insert into head when there is a node
		sll.printList();
		sll.deleteNodeUsingKey(2); // delete the head node when there are many elements available
		sll.printList();
		sll.insertNode(node2, 0);
		sll.printList();
		Node<Integer> node3 = new Node<Integer>(3);
		sll.insertNode(node3, 1); // insert into middle
		sll.printList();
		sll.deleteNodeUsingKey(3); // delete the middle element
		sll.printList();
		sll.insertNode(node3, 1);
		sll.printList();
		Node<Integer> node4 = new Node<Integer>(4);
		sll.insertNode(node4, 3); // insert into tail and there are no next nodes
		sll.printList();
		Node<Integer> node5 = new Node<Integer>(5);
		sll.insertNode(node5, 10); // insert into tail and the position is high
		sll.printList();
		
		
		System.out.println(sll.getNthNodeFromEnd(0));
		System.out.println(sll.getNthNodeFromEnd(4));
		
		sll.deleteNodeUsingKey(5); // delete the tail element
		
		
		sll.printList();
		sll.swap(2, 1);  // swapping head node with other node
		sll.printList();
		sll.swap(1, 3);  // swapping head and its next node
		sll.printList();
		sll.swap(3, 4);  //  swapping head and tail node
		sll.printList();
		sll.swap(2, 1);  //  swapping adjacent nodes  
		sll.printList();
		sll.swap(3, 2);  //   swapping non adjacent nodes
		sll.printList();
		
		System.out.println(sll.getMiddleNodeFromList(true));
		System.out.println(sll.getMiddleNodeFromList(false));
		
		
		Node<Integer> node6 = new Node<Integer>(3);
		sll.insertNode(node6, 0);
		Node<Integer> node7 = new Node<Integer>(3);
		sll.insertNode(node7, 9);
		Node<Integer> node8 = new Node<Integer>(3);
		sll.insertNode(node8, 3);
		Node<Integer> node9 = new Node<Integer>(3);
		sll.insertNode(node9, 3);
		
		
		System.out.println("length of the list in iterative way : "+sll.getLengthIteratively());  // get the length of the list iteratively
		System.out.println("length of the list in recursive way : "+sll.getLengthRecursively());  // get the length of the list recursively
		
		
		Node searchedNode1 = sll.searchIteratively(4);  // search an element iteratively
		System.out.println(searchedNode1);
		Node searchedNode2 = sll.searchRecursively(1);  // search an element recursively
		System.out.println(searchedNode2);
		sll.printList();
		
		System.out.println(sll.getNumberOfKeyOccurrence(3));
		System.out.println(sll.getNumberOfKeyOccurrence(8));
		
		System.out.println(sll.getNthNode(5));   // get the nth node
		System.out.println(sll.getNthNode(6));
		System.out.println(sll.getNthNode(1));
		System.out.println(sll.getNthNode(0));
		
		
		sll.deleteDuplicateNodeUsingKey(3, false, true, false, false, false); // deleting the first duplicated element
		sll.printList();
		sll.insertNode(node6, 0);
		sll.printList();
		sll.deleteDuplicateNodeUsingKey(3, false, false, true, false, false); // deleting the last duplicated element
		sll.printList();
		sll.insertNode(node7, 9);
		sll.printList();
		sll.deleteDuplicateNodeUsingKey(3, false, false, false, false, true); // deleting odd duplicated elements
		sll.printList();
		Node<Integer> node10 = new Node<Integer>(3);
		sll.insertNode(node10, 2);
		Node<Integer> node11 = new Node<Integer>(3);
		sll.insertNode(node11, 2);
		sll.printList();
		
		sll.reverseList();
		sll.printList();
		sll.reverseRecursively();
		sll.printList();
		
		
		sll.deleteDuplicateNodeUsingKey(3, false, false, false, false, false); // deleting even duplicated elements
		sll.printList();
		
		sll.reverseList();
		sll.printList();
		sll.reverseRecursively();
		sll.printList();
		
		
		sll.deleteDuplicateNodeUsingKey(3, true, false, false, false, false); // deleting all the duplicated element
		sll.printList();
		
		sll.reverseList();
		sll.printList();
		sll.reverseRecursively();
		sll.printList();
		
		
		sll.deleteNodeUsingPosition(1);  // deleting the middle element
		sll.printList();
		sll.swap(4, 2);
		sll.printList();
		
		sll.reverseList();
		sll.printList();
		sll.printReverse(sll.getList());
		sll.reverseRecursively();
		sll.printList();
		System.out.println(sll.isCyclicList());
		
		
		sll.deleteNodeUsingPosition(1); // deleting the tail element
		sll.printList();
		System.out.println(sll.getNthNode(2));
		try{
			sll.deleteNodeUsingPosition(1); // deleting the element position that is not there in the list
		}catch(RuntimeException e){
			// do nothing
		}
		sll.printList();
		sll.reverseList();
		sll.printList();
		sll.reverseRecursively();
		sll.printList();
		System.out.println(sll.isCyclicList());
		System.out.println(sll.isPalindrom());
		
		sll.printList();
		sll.deleteNodeUsingPosition(0); // deleting the head element
		sll.printList();
		
		
		System.out.println("length of the list in iterative way : "+sll.getLengthIteratively());
		System.out.println("length of the list in recursive way : "+sll.getLengthRecursively());
		
		
		Node searchedNode3 = sll.searchIteratively(4);
		System.out.println(searchedNode3);
		Node searchedNode4 = sll.searchRecursively(1);
		System.out.println(searchedNode4);
		
		SinglyLinkedList<Integer> sll2 = new SinglyLinkedList<Integer>();
		Node<Integer> nodex = new Node<Integer>(10);
		Node nodey = new Node(11);
		Node nodez = new Node(12);
		nodex.setNext(nodey);
		nodey.setNext(nodez);
		nodez.setNext(nodex);
		sll2.insertNode(nodex, 0);
		System.out.println(sll2.isCyclicList());
		
		
		SinglyLinkedList<Integer> sll3 = new SinglyLinkedList<Integer>();
		Node nodea = new Node(1);
		Node nodeb = new Node(3);
		Node nodec = new Node(5);
		sll3.insertNode(nodea, 0);
		sll3.insertNode(nodeb, 1);
		sll3.insertNode(nodec, 2);
		sll3.printList();
		sll3.printList(sll3.sortedInsertion(sll3.getList(),new Node(3)));
		
		SinglyLinkedList<Integer> sll4 = new SinglyLinkedList<Integer>();
		Node nodei = new Node(2);
		Node nodej = new Node(4);
		Node nodek = new Node(7);
		sll4.insertNode(nodei, 0);
		sll4.insertNode(nodej, 1);
		sll4.insertNode(nodek, 2);
		sll4.printList();
		SinglyLinkedList<Integer> sll5 = mergeSortedList(sll3, sll4);
		sll5.printList();
		sll5.removeDuplicatedFromSortedList(sll5.getList());
		sll5.printList();
		
		sll5.printReverse(sll5.getList());
		sll5.printList(sll5.sortedInsertion(sll5.getList(), new Node(6)));
		
		Node<Integer> head = mergeSortedListRecursively(sll3.getList(), sll4.getList());
		System.out.println("Merging sorted linked list recursively");
		sll5.printList(head);
		
		System.out.println(sll5.isPalindrom());
		
		SinglyLinkedList<Integer> sll6 = new SinglyLinkedList<Integer>();
		sll6.insertNode(new Node(1), 0);
		sll6.insertNode(new Node(2), 1);
		sll6.insertNode(new Node(1), 2);
		sll6.printList();
		System.out.println(sll6.isPalindrom());
		sll6.insertNode(new Node(2), 1);
		sll6.printList();
		System.out.println(sll6.isPalindrom());
		sll6.insertNode(new Node(3), 2);
		sll6.printList();
		sll6.printReverse(sll6.getList());
		System.out.println(sll6.isPalindrom());
		
		System.out.println(sll4.getIntersectionOf2List(sll5, sll6));
		SinglyLinkedList<Integer> sll7 = new SinglyLinkedList<Integer>();
		Node nodep = new Node(1);
		Node nodeq = new Node(2);
		Node noder = new Node(3);
		sll7.insertNode(nodep,0);
		sll7.insertNode(nodeq, 1);
		sll7.insertNode(noder, 2);
		
		SinglyLinkedList<Integer> sll8 = new SinglyLinkedList<Integer>();
		Node nodem = new Node(0);
		sll8.insertNode(nodeq, 0);
		
		
		System.out.println(sll4.getIntersectionOf2List(sll7, sll8));
		
		SinglyLinkedList<Integer> sll9 = new SinglyLinkedList<Integer>();
		Node nodea1 = new Node(1);
		Node nodea2 = new Node(2);
		Node nodea3 = new Node(2);
		Node nodea4 = new Node(3);
		Node nodea5 = new Node(4);
		Node nodea6 = new Node(4);
		Node nodea7 = new Node(4);
		sll9.insertNode(nodea1, 0);
		sll9.insertNode(nodea2, 1);
		sll9.insertNode(nodea3, 2);
		sll9.insertNode(nodea4, 3);
		sll9.insertNode(nodea5, 4);
		sll9.insertNode(nodea6, 5);
		sll9.insertNode(nodea7, 6);
		
		sll9.printList();
		sll9.printReverse(sll9.getList());
		SinglyLinkedList sll10 = sll9;
		sll9.removeDuplicatedFromSortedList(sll9.getList());
		sll9.printList();
		
		System.out.println("Code to delete the duplicate from unsorted list");
		sll10.insertNode(new Node(0), 3);
		sll10.insertNode(new Node(0), 1);
		sll10.insertNode(new Node(0), 5);
		sll10.insertNode(new Node(1), 4);
		sll10.printList();
		sll10.pairwiseSwapping(sll10.getList());
		sll10.printList();
		sll10.pairwiseSwappingRecursively(sll10.getList());
		sll10.printList();
		sll10.removeDuplicateFromUnsortedList(sll10.getList());
		sll10.printList();
		
		
		System.out.println("Swapping the nodes pairwise");
		sll10.printList();
		sll10.pairwiseSwapping(sll10.getList());
		sll10.printList();
		sll10.pairwiseSwappingRecursively(sll10.getList());
		sll10.printList();
		
		
		sll10.moveLastNodeToFirst(sll10.getList());
		sll10.printList();
		
		SinglyLinkedList<Integer> slla1 = new SinglyLinkedList<Integer>();
		slla1.insertNode(new Node(1), 0);
		slla1.insertNode(new Node(3), 1);
		slla1.insertNode(new Node(4), 2);
		slla1.insertNode(new Node(5), 3);
		slla1.insertNode(new Node(9), 4);
		
		SinglyLinkedList<Integer> slla2 = new SinglyLinkedList<Integer>();
		slla2.insertNode(new Node(3), 0);
		slla2.insertNode(new Node(5), 1);
		slla2.insertNode(new Node(7), 2);
		
		slla1.printList(slla1.intersectionOfList(slla1.getList(), slla2.getList()));
		slla1.printList();
		slla1.deleteAlternateNode();
		slla1.printList();
		System.out.println("Deleting alternative node recursively");
		slla1.printList(slla1.deleteAlternateNodeRecursively(slla1.getList()));
		
		
		

	}





	public Iterator<T> iterator() {
		return null;
	}

}
