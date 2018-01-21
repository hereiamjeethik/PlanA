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
			temp.setPrev(newNode);
		}else{
			prev.setNext(newNode);
			newNode.setPrev(prev);
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
