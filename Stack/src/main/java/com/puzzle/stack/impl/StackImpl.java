package com.puzzle.stack.impl;

import java.util.Iterator;

import com.puzzle.stack.array.Stack;

public class StackImpl {
	
	public int postfix(char[] array, int position, char append, Stack<Character> myStack){
		while(position < array.length){
			switch(array[position]){
			case '*':
			case '/':
			case '%':
				if(myStack.peek() == '+' || myStack.peek() == '-'){
					char temp = myStack.pop();
					if(array[position + 1] != '('){
						myStack.push(array[position + 1]);
						myStack.push(array[position]);
						myStack.push(temp);
					}else{
						int prevPosition = position;
						position = position + 2;
						position = postfix(array, position, array[prevPosition], myStack);
						myStack.push(temp);
					}
				}else{
					myStack.push(array[position]);
				}
				break;
			
			case '+':
			case '-':
				myStack.push(array[position]);
				break;
			
			case '(':
				if(position == 0){
					position = postfix(array, position+1, '.', myStack);
				}else{
					char temp = myStack.pop();
					position = position +1;
					position = postfix(array, position, temp, myStack);
				}
				break;
			
			case ')':
				myStack.push(append);
				return position;
			
			default:
				if(myStack.isEmpty()){
					myStack.push(array[position]);
				}else{
					char temp = myStack.peek();
					if(temp != '+' && temp != '-' && temp != '*' && temp != '/' && temp != '%'){
						myStack.push(array[position]);
					}
					else{
						temp = myStack.pop();
						myStack.push(array[position]);
						myStack.push(temp);
					}
				}
				break;
			}
			position ++;
		}
		Iterator<Character> stackIterator = myStack.iterator();
		while(stackIterator.hasNext()){
			System.out.println(stackIterator.next());
		}
		return Integer.MAX_VALUE;
	}
	
	public static void main(String[] args) {
		String testString = "c*(a+b)-d/(e-f)";
		StackImpl obj = new StackImpl();
		Stack<Character> myStack = new Stack<Character>();
		obj.postfix(testString.toCharArray(), 0, '.', myStack);

	}

}
