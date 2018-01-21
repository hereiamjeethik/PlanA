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
	
	public void printList(){
		Node <T> curr = getHead();
		while(curr != null){
			System.out.print(curr.getItem()+" <--> ");
			curr = curr.getNext();
		}
		System.out.println("");
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
	}

}
