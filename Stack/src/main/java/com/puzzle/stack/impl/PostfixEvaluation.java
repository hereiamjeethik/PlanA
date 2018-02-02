package com.puzzle.stack.impl;

import com.puzzle.stack.array.Stack;

public class PostfixEvaluation {

	public int postfixEvaluation(char[] array){
		Stack<String> myStack = new Stack<String>();
		int position =0;
		while(position < array.length){
			switch(array[position]){
			case '*':
			case '/':
			case '+':
			case '-':
				int v2 = Integer.parseInt(myStack.pop());
				int v1 = Integer.parseInt(myStack.pop());
				if(array[position] == '*'){
					myStack.push(v1*v2+"");
				}else if(array[position] == '/'){
					myStack.push(v1/v2+"");
				}else if(array[position] == '+'){
					myStack.push(v1+v2+"");
				}else if(array[position] == '-'){
					myStack.push(v1-v2+"");
				}
				break;
			default:
				myStack.push(array[position]+"");
				break;
				
			}
			position++;
		}
		return Integer.parseInt(myStack.peek());
	}
	
	public static void main(String[] args) {
		String postfix = "231*+9-";
		System.out.println(new PostfixEvaluation().postfixEvaluation(postfix.toCharArray()));

	}

}
