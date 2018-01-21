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
	}

}
