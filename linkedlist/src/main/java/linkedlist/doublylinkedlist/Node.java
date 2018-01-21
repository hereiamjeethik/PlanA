/**
 * 
 */
package linkedlist.doublylinkedlist;

/**
 * @author karengas
 *
 */
public class Node<T> {
	private T t;
	private Node<T> next;
	private Node<T> prev;
	
	public Node(){
		
	}
	
	public Node(T t){
		this.t = t;
	}
	
	public Node(T t, Node<T> next, Node<T> prev){
		this.t = t;
		this.next = next;
		this.prev = prev;
	}

	public T getItem() {
		return t;
	}

	public void setItem(T t) {
		this.t = t;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> getPrev() {
		return prev;
	}

	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	
}
