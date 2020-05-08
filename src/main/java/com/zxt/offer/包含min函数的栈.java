package com.zxt.offer;

import java.util.Stack;

/**
 * 
 * @Description: ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min������(����Ҫ��min��push��pop��ʱ�临�Ӷȶ���O(1))
 *
 * @author�� zxt
 *
 * @time: 2018��7��9�� ����9:12:17
 *
 */
public class ����min������ջ {
	
	// ����ջ��ѹ���뵯�����Լ���Сֵ������ʱ�临�Ӷȶ���Ҫ��1�����ֻ�������µĴ洢�ռ䣬�ÿռ任ʱ��
	private Stack<Integer> data_stack = new Stack<Integer>();
	// ����ջ����Сֵ��һ��ջ�����ǵ���ֵ��ԭ������ջ�е�����Сֵ��ջ��ʣ��Ԫ����СֵҲ��Ҫ���£������Ҫ����һ����Сֵ����
	private Stack<Integer> min_stack = new Stack<Integer>();
	
	public static void main(String[] args) {
		����min������ջ myStack = new ����min������ջ();
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
		
		// ��ջ�ĵ�һ��Ԫ�أ���ô��СֵҲ������
		// value <= min_stack.peek()��ʹ�õ��ڵ�ԭ����������ջ������Сֵ������Сֵ���ظ������������󣬻��ܱ�֤������С
		if(min_stack.isEmpty() || value <= min_stack.peek()) {
			min_stack.push(value);
		}
	}
	
	public int pop() {
		// ������ջջ��Ԫ�ؼ���Сֵ���򵯳�����ջջ����ͬʱ������Сֵջջ���ĵ�ǰ��Сֵ����Сֵջ����ջ������ʣ��Ԫ�ص���Сֵ
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
