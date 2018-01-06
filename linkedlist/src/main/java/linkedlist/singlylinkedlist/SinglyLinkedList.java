/**
 * 
 */
package linkedlist.singlylinkedlist;

import java.util.Iterator;

/**
 * @author karengas
 *
 */
public class SinglyLinkedList<T> implements Iterable<T> {
	private Node<T> head;
	
	/**
	 * @param newNode, position
	 * newNode is the node to be inserted in the specified position
	 * 
	 */
	public Node<T> insertNode(Node<T> newNode, int position){
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
	
	public void printList(){
		Node<T> currNode = head;
		System.out.println("Printing the list of nodes");
		if(currNode == null){
			System.out.print("no nodes");
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
		Node<Integer> node2 = new Node<Integer>(2);
		sll.insertNode(node2, 0); // insert into head when there is a node
		sll.printList();
		Node<Integer> node3 = new Node<Integer>(3);
		sll.insertNode(node3, 1); // insert into middle
		sll.printList();
		Node<Integer> node4 = new Node<Integer>(4);
		sll.insertNode(node4, 3); // insert into tail and there are no next nodes
		sll.printList();
		Node<Integer> node5 = new Node<Integer>(5);
		sll.insertNode(node5, 10); // insert into tail and the position is high
		sll.printList();

	}





	public Iterator<T> iterator() {
		// TODO Need to implement this iterator
		return null;
	}

}
