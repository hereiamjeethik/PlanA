package linkedlist.doublylinkedlist;

/**
 * @author karengas
 *
 * @param <T>
 */
public class DoublyLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	
	
	public Node<T> getHead() {
		return head;
	}


	public void setHead(Node<T> head) {
		this.head = head;
	}


	public Node<T> getTail() {
		return tail;
	}


	public void setTail(Node<T> tail) {
		this.tail = tail;
	}
	
	/**
	 * Insert a doubly linked node is the given position
	 * @param newNode
	 * @param position
	 */
	public void insertAtPosition(Node<T> newNode, int position){
		Node<T> curr = getHead();
		int currPos = 0;
		Node<T> prev= null;
		while(curr != null && currPos < position-1){
			prev= curr;
			curr = curr.getNext();
			currPos++;
		}
		if(currPos == position-1){
			Node<T> temp = curr.getNext();
			curr.setNext(newNode);
			newNode.setPrev(curr);
			newNode.setNext(temp);
			if(temp != null){
				temp.setPrev(newNode);
			}
			
		}else{
			if(prev==null){
				this.setHead(newNode);
			}else{
				prev.setNext(newNode);
				newNode.setPrev(prev);
			}
			
		}
	}
	
	/**
	 * This method prints the list
	 */
	public void printList(){
		System.out.println("Printing the list of nodes");
		Node <T> curr = getHead();
		while(curr != null){
			System.out.print(curr.getItem()+" <--> ");
			curr = curr.getNext();
		}
		System.out.println("");
	}
	
	/**
	 * This method prints the list
	 */
	public void printList(Node<T> head){
		System.out.println("Printing the list of nodes");
		Node <T> curr = head;
		while(curr != null){
			System.out.print(curr.getItem()+" <--> ");
			curr = curr.getNext();
		}
		System.out.println("");
	}
	
	/**
	 * This method will delete the node in the linked list using the given key
	 */
	public void deleteNodeUsingKey(T t){
		System.out.println("Deleting the node "+t+" from the list");
		Node<T> curr = getHead();
		while(curr != null){
			if(curr.getItem().equals(t)){
				if(curr.getPrev() == null){
					this.setHead(curr.getNext());
					if(curr.getNext() != null){
						curr.getNext().setPrev(null);
					}
				}else{
					Node<T> temp = curr.getPrev();
					Node<T> next = curr.getNext();
					temp.setNext(next);
					if(next != null){
						next.setPrev(temp);
					}
				}
				return;
			}else{
				curr = curr.getNext();
			}
		}
	}

	/**
	 * This method reverses the linked list
	 */
	public void reverseList(){
		Node<T> curr = getHead();
		while(curr != null){
			Node<T> prev = curr.getPrev();
			Node<T> next = curr.getNext();
			curr.setNext(prev);
			curr.setPrev(next);
			if(prev == null){
				setTail(curr);
			}
			
			if(next == null){
				setHead(curr);
			}
			curr = curr.getPrev();
		}
	}

	/**
	 * swap the nodes from both the ends in a given position
	 * @param position
	 */
	public void swapKthNodeFromBothEnds(int position){
		System.out.println("Swapping "+position+"th node from both the ends");
		Node<T> currStart = getHead();
		Node<T> currEnd = getTail();
		int count = 0;
		while(currStart != null && currEnd != null  && count < position){
			currStart = currStart.getNext();
			currEnd = currEnd.getPrev();
			count++;
		}
		if(count == position){
			if(currStart == currEnd){
				return;
			}else{
				if(currStart.getNext() == currEnd){
					Node<T> temp1 = currStart.getPrev();
					Node<T> temp2 = currEnd.getNext();
					temp1.setNext(currEnd);
					currEnd.setPrev(temp1);
					currStart.setNext(temp2);
					temp2.setPrev(currStart);
					currStart.setPrev(currEnd);
					currEnd.setNext(currStart);
				}else if(currStart.getPrev() == currEnd){
					Node<T> temp1 = currStart.getNext();
					Node<T> temp2 = currEnd.getPrev();
					temp2.setNext(currStart);
					currStart.setPrev(temp2);
					temp1.setPrev(currEnd);
					currEnd.setNext(temp1);
					currStart.setNext(currEnd);
					currEnd.setPrev(currStart);
					
				}else if(currEnd.getNext() == null){
					Node<T> temp1 = currEnd.getPrev();
					Node<T> temp2 = currStart.getNext();
					currStart.setPrev(temp1);
					temp1.setNext(currStart);
					currEnd.setNext(temp2);
					temp2.setPrev(currEnd);
					currStart.setNext(null);
					currEnd.setPrev(null);
					setHead(currEnd);
					setTail(currStart);
				}else{
					Node<T> temp1 = currEnd.getNext();
					Node<T> temp2 = currStart.getPrev();
					temp1.setPrev(currStart);
					currStart.setNext(temp1);
					temp2.setNext(currEnd);
					currEnd.setPrev(temp2);
					currEnd.setNext(null);
					currStart.setPrev(null);
					setTail(currEnd);
					setHead(currStart);
				}
				return;
			}
		}else{
			System.out.println("There are not enough nodes in the list");
			return;
		}
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.insertAtPosition(new Node(1), 0);
		dll.insertAtPosition(new Node(2), 1);
		dll.insertAtPosition(new Node(3), 2);
		dll.insertAtPosition(new Node(4), 3);
		dll.insertAtPosition(new Node(5), 4);
		dll.insertAtPosition(new Node(6), 5);
		
		dll.printList();
		dll.deleteNodeUsingKey(2);
		dll.printList();
		dll.deleteNodeUsingKey(1);
		dll.printList();
		dll.deleteNodeUsingKey(6);
		dll.printList();
		dll.reverseList();
		dll.printList();
		dll.swapKthNodeFromBothEnds(0);
		dll.printList();
		dll.swapKthNodeFromBothEnds(1);
		dll.printList();
		dll.swapKthNodeFromBothEnds(2);
		dll.printList();
		dll.swapKthNodeFromBothEnds(3);
		dll.printList();
	}

}
