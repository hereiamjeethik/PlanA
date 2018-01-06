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
		sll.deleteNodeUsingKey(1);
		sll.printList();
		sll.insertNode(node1, 2);
		sll.printList();
		Node<Integer> node2 = new Node<Integer>(2);
		sll.insertNode(node2, 0); // insert into head when there is a node
		sll.printList();
		sll.deleteNodeUsingKey(2);
		sll.printList();
		sll.insertNode(node2, 0);
		sll.printList();
		Node<Integer> node3 = new Node<Integer>(3);
		sll.insertNode(node3, 1); // insert into middle
		sll.printList();
		sll.deleteNodeUsingKey(3);
		sll.printList();
		sll.insertNode(node3, 1);
		sll.printList();
		Node<Integer> node4 = new Node<Integer>(4);
		sll.insertNode(node4, 3); // insert into tail and there are no next nodes
		sll.printList();
		Node<Integer> node5 = new Node<Integer>(5);
		sll.insertNode(node5, 10); // insert into tail and the position is high
		sll.printList();
		sll.deleteNodeUsingKey(5);
		sll.printList();

	}





	public Iterator<T> iterator() {
		return null;
	}

}
