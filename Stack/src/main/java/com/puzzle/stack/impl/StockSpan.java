package com.puzzle.stack.impl;

import com.puzzle.stack.array.Stack;
import com.puzzle.stack.util.Holder;

public class StockSpan {

	public void getSpan(int[] array){
		Stack<Holder<Integer>> myStack = new Stack<Holder<Integer>>();
		int position=0;
		while(position < array.length){
			if(myStack.isEmpty()){
				myStack.push(new Holder<Integer>(array[position],1));
				System.out.println(array[position]+" --> "+1);
			}else{
				if(myStack.peek().getItem() > array[position]){
					myStack.push(new Holder<Integer>(array[position],1));
					System.out.println(array[position]+" --> "+1);
				}else{
					int spanLength = 1;
					while(!myStack.isEmpty()){
						if(myStack.peek().getItem() > array[position]){
							break;
						}else{
							spanLength = spanLength + myStack.pop().getSpanLength();
						}
					}
					myStack.push(new Holder<Integer>(array[position],spanLength));
					System.out.println(array[position]+" --> "+spanLength);
				}
			}
			position++;
		}
		
		
	}
	
	public static void main(String[] args) {
		StockSpan span = new StockSpan();
		int[] array = {100,80,60,70,60,75,85,102};
		span.getSpan(array);

	}

}
