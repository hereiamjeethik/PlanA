package linkedlist.singlylinkedlist;

public class Node<T> implements Comparable<T> {
	private T t;
	private Node<T> next;
	
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
