package linkedlist.singlylinkedlist;

public class TwoPointerNode {
	private int data;
	private TwoPointerNode next, greater;
	
	public TwoPointerNode(){
		
	}
	
	public TwoPointerNode(int data, TwoPointerNode next, TwoPointerNode greater){
		this.data = data;
		this.next = next;
		this.greater = greater;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TwoPointerNode getNext() {
		return next;
	}

	public void setNext(TwoPointerNode next) {
		this.next = next;
	}

	public TwoPointerNode getGreater() {
		return greater;
	}

	public void setGreater(TwoPointerNode greater) {
		this.greater = greater;
	}
	
	

}
