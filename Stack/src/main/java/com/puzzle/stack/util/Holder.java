package com.puzzle.stack.util;

public class Holder<Item> {
	private Item item;
	private int spanLength;
	
	public Holder(){
		
	}
	
	public Holder(Item newItem, int spanLength){
		item = newItem;
		this.spanLength = spanLength;
	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getSpanLength() {
		return spanLength;
	}
	public void setSpanLength(int spanLength) {
		this.spanLength = spanLength;
	}
	
	

}
