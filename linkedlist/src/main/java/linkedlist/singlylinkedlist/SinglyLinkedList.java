/**
 * 
 */
package linkedlist.singlylinkedlist;

import java.util.Iterator;

/**
 * @author hereiamkarthik@gmail.com
 * TODO 1: Do the Iterator.
 * TODO 2: Do the Thread-Safe code.
 * TODO 3: write unit test cases for all the functions and cases.
 *
 */
public class SinglyLinkedList<T> implements Iterable<T> {
	private Node<T> head;
	
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
		}
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
		sll.deleteNodeUsingKey(5); // delete the tail element
		sll.printList();
		Node<Integer> node6 = new Node<Integer>(3);
		sll.insertNode(node6, 0);
		Node<Integer> node7 = new Node<Integer>(3);
		sll.insertNode(node7, 9);
		Node<Integer> node8 = new Node<Integer>(3);
		sll.insertNode(node8, 3);
		Node<Integer> node9 = new Node<Integer>(3);
		sll.insertNode(node9, 3);
		sll.printList();
		sll.deleteDuplicateNodeUsingKey(3, false, true, false, false, false); // deleting the first duplicated element
		sll.printList();
		sll.insertNode(node6, 0);
		sll.printList();
		sll.deleteDuplicateNodeUsingKey(3, false, false, true, false, false); // deleting the last duplicated element
		sll.printList();
		sll.insertNode(node7, 9);
		sll.printList();
		sll.deleteDuplicateNodeUsingKey(3, true, false, false, false, false); // deleting all the duplicated element
		sll.printList();
	}





	public Iterator<T> iterator() {
		return null;
	}

}
