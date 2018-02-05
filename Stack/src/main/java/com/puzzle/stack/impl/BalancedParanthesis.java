package com.puzzle.stack.impl;

import com.puzzle.stack.array.Stack;

public class BalancedParanthesis {

	private Stack<Character> myStack = new Stack<Character>();
	
	public boolean isBalancedParanthesis(char[] array){
		int position = 0;
		while(position < array.length){
			switch(array[position]){
				case '(':
					myStack.push('(');
					break;
				case '{':
					myStack.push('{');
					break;
				case '[':
					myStack.push('[');
					break;
				case ')':
					if(myStack.isEmpty()){
						return false;
					}else{
						if(myStack.pop() != '('){
							return false;
						}
					}
					break;
				case ']':
					if(myStack.isEmpty()){
						return false;
					}else{
						if(myStack.pop() != '['){
							return false;
						}
					}
					break;
				case '}':
					if(myStack.isEmpty()){
						return false;
					}else{
						if(myStack.pop() != '{'){
							return false;
						}
					}
					break;
				
			}
			position++;
		}
		return myStack.isEmpty()?true:false;
	}
	public static void main(String[] args) {
		String expression = "[[{()}]](){}[]";
		System.out.println("Is this string '"+ expression +"' a Balance paranthesis");
		BalancedParanthesis obj = new BalancedParanthesis();
		System.out.println(obj.isBalancedParanthesis(expression.toCharArray()));
		String expression2 = "[[{()}]](){}[[]()(]";
		System.out.println("Is this string '"+ expression2 +"' a Balance paranthesis");
		System.out.println(obj.isBalancedParanthesis(expression2.toCharArray()));
		
	}

}
