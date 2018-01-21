package linkedlist.singlylinkedlist;

public class CircularLinkedList<T> {
	private Node<T> head;
	
	public Node getList(){
		return this.head;
	}
	
	public void setList(Node head){
		this.head = head;
	}
	
	/**
	 * Iterating over the circular singly linked list and printing it.
	 */
	public void printCircularList(){
		Node curr = head;
		if(curr != null){
			System.out.print(curr.getItem() +" --> ");
			curr = curr.getNext();
		}
		while(curr != head){
			System.out.print(curr.getItem() + " --> ");
			curr = curr.getNext();
		}
		System.out.println("");
	}
	
	/**
	 * Iterating over the circular singly linked list and printing it.
	 */
	public void printCircularList(Node head){
		Node curr = head;
		if(curr != null){
			System.out.print(curr.getItem() +" --> ");
			curr = curr.getNext();
		}
		while(curr != head){
			System.out.print(curr.getItem() + " --> ");
			curr = curr.getNext();
		}
		System.out.println("");
	}
	
	/**
	 * Split a Circular Linked List into two halves
	 */
	public void splitCircularListby2(Node head){
		Node curr = head, fPrev = null, sPrev = null, fPtr = head, sPtr = head;
		if(fPtr.getNext() == head){
			System.out.println("Only one node is there in the list, hence cannot split");
			return;
		}else{
			fPrev = fPtr;
			fPtr = fPtr.getNext();
			sPrev = sPtr.getNext();
			sPtr = sPtr.getNext().getNext();
			while(sPtr != head && sPtr.getNext() != head){
				fPrev = fPtr;
				fPtr = fPtr.getNext();
				sPrev = sPrev.getNext().getNext();
				sPtr = sPtr.getNext().getNext();
			}
			
			if(sPtr == head){
				sPrev.setNext(fPtr);
				fPrev.setNext(head);
				printCircularList(head);
				printCircularList(fPtr);
			}else{
				sPtr.setNext(fPtr);
				fPrev.setNext(head);
				printCircularList(head);
				printCircularList(fPtr);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		// Circular Linked list
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node1);
		CircularLinkedList<Integer> cll = new CircularLinkedList<Integer>();
		cll.printCircularList(node1);
		cll.splitCircularListby2(node1);
		cll.printCircularList(node1);
		node2.setNext(node3);
		
		Node node5 = new Node(5);
		node4.setNext(node5);
		node5.setNext(node1);
		cll.printCircularList(node1);
		cll.splitCircularListby2(node1);

	}

}
