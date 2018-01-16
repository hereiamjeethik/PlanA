package linkedlist.singlylinkedlist;

public class TwoNode {
	private int data;
	private TwoNode right, down;
	
	public TwoNode(){
		
	}
	
	public TwoNode(int data, TwoNode right, TwoNode down){
		this.data = data;
		this.right = right;
		this.down = down;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TwoNode getRight() {
		return right;
	}

	public void setRight(TwoNode right) {
		this.right = right;
	}

	public TwoNode getDown() {
		return down;
	}

	public void setDown(TwoNode down) {
		this.down = down;
	}
	
	

}
