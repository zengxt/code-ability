package com.zxt.jianzhi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @Description: 两个队列实现栈
 *
 * @author： zxt
 *
 * @time: 2018年6月20日 下午3:08:50
 *
 */
public class 两个队列实现栈 {

	Queue<Integer> queue1 = new LinkedList<Integer>();
	Queue<Integer> queue2 = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		// 由于队列只能先进先出，所以
		两个队列实现栈 stack = new 两个队列实现栈();
		
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		stack.push(6);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println(stack.pop());
	}
	
	/**
	 * 
	 * @Description：向栈中压入一个元素（由于队列只能先进先出，所以两个队列也无法将元素的顺序反转）
	 * 
	 * @param node
	 */
	public void push(int node) {
		if(queue2.size() != 0) {
			queue2.offer(node);
			
		} else {
			queue1.offer(node);
		}
	}
	
	/**
	 * 
	 * @Description：从栈中弹出一个元素(每次出栈，将有元素队列中的元素移到另一个空队列，剩下的一个队尾元素就是刚刚压入栈的元素)
	 * 
	 * @return
	 */
	public int pop() {
		// 没有元素，无法出栈
		if(queue1.size() == 0 && queue2.size() == 0) {
			System.out.println("stack is empty!");
    		System.exit(0);
		}
		
		if(queue2.size() != 0) {
			while(queue2.size() != 1) {
				queue1.offer(queue2.poll());
			}
			
			return queue2.poll();
			
		} else {
			while(queue1.size() != 1) {
				queue2.offer(queue1.poll());
			}
			
			return queue1.poll();
		}
		
	}
}
