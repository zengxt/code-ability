package com.zxt.offer;

import java.util.Stack;

/**
 * 
 * @Description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数。(并且要求：min、push、pop的时间复杂度都是O(1))
 *
 * @author： zxt
 *
 * @time: 2018年7月9日 下午9:12:17
 *
 */
public class 包含min函数的栈 {
	
	// 由于栈的压入与弹出，以及最小值函数的时间复杂度都需要是1，因此只能引入新的存储空间，用空间换时间
	private Stack<Integer> data_stack = new Stack<Integer>();
	// 保存栈的最小值用一个栈而不是单个值，原因在于栈中弹出最小值后，栈的剩余元素最小值也需要更新，因此需要保存一个最小值序列
	private Stack<Integer> min_stack = new Stack<Integer>();
	
	public static void main(String[] args) {
		包含min函数的栈 myStack = new 包含min函数的栈();
		myStack.push(1);
		myStack.push(3);
		myStack.push(4);
		System.out.println(myStack.min());
		
		System.out.println(myStack.pop());
		System.out.println(myStack.min());
		
		myStack.push(0);
		System.out.println(myStack.min());
		
		System.out.println(myStack.pop());
		System.out.println(myStack.min());
	}
	
	public void push(int value) {
		data_stack.push(value);
		
		// 入栈的第一个元素（那么最小值也是它）
		// value <= min_stack.peek()，使用等于的原因在于若入栈的是最小值，且最小值有重复，当它弹出后，还能保证它是最小
		if(min_stack.isEmpty() || value <= min_stack.peek()) {
			min_stack.push(value);
		}
	}
	
	public int pop() {
		// 若数据栈栈顶元素即最小值，则弹出数据栈栈顶的同时弹出最小值栈栈顶的当前最小值，最小值栈的新栈顶则是剩余元素的最小值
		if(data_stack.peek() == min_stack.peek()) {
			min_stack.pop();
		}
		
		return data_stack.pop();
	}
	
	public int top() {
		return data_stack.peek();
	}
	
	public int min() {
		return min_stack.peek();
	}
}
