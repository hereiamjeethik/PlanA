package linkedlist.singlylinkedlist;

/*
 * This class is for singly linked list nodes
 */
public class Node<T> implements Comparable<T> {
	private T t;
	private Node<T> next;
	
	public Node(){
		
	}
	public Node(T t){
		this.t = t;
	}
	
	public void setItem(T t){
		this.t = t;
	}
	public T getItem(){
		return t;
	}
	public void setNext(Node<T> next){
		this.next=next;
	}
	public Node<T> getNext(){
		return next;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * This comparator will compare the nodes t values alone
	 */
	public int compareTo(Object node) {
		if(node instanceof Node){
			if(this.t.equals(((Node) node).t)){
				return 0;
			}else{
				return 1;
			}
		}else{
			return -1;
		}
		
	}
	
	@Override
	public boolean equals(Object node) {
		if(node instanceof Node){
			if(this.t.equals(((Node) node).t)){
				return true;
			}
		}
		return false;
	}
	
}
