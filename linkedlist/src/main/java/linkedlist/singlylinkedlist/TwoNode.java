package linkedlist.singlylinkedlist;

public class TwoNode {
	private int data;
	private TwoNode next, greater;
	
	public TwoNode(){
		
	}
	
	public TwoNode(int data, TwoNode next, TwoNode greater){
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

	public TwoNode getNext() {
		return next;
	}

	public void setNext(TwoNode next) {
		this.next = next;
	}

	public TwoNode getGreater() {
		return greater;
	}

	public void setGreater(TwoNode greater) {
		this.greater = greater;
	}
	
	

}
