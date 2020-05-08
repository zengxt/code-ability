package com.zxt.jianzhi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @Description: ��������ʵ��ջ
 *
 * @author�� zxt
 *
 * @time: 2018��6��20�� ����3:08:50
 *
 */
public class ��������ʵ��ջ {

	Queue<Integer> queue1 = new LinkedList<Integer>();
	Queue<Integer> queue2 = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		// ���ڶ���ֻ���Ƚ��ȳ�������
		��������ʵ��ջ stack = new ��������ʵ��ջ();
		
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
	 * @Description����ջ��ѹ��һ��Ԫ�أ����ڶ���ֻ���Ƚ��ȳ���������������Ҳ�޷���Ԫ�ص�˳��ת��
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
	 * @Description����ջ�е���һ��Ԫ��(ÿ�γ�ջ������Ԫ�ض����е�Ԫ���Ƶ���һ���ն��У�ʣ�µ�һ����βԪ�ؾ��Ǹո�ѹ��ջ��Ԫ��)
	 * 
	 * @return
	 */
	public int pop() {
		// û��Ԫ�أ��޷���ջ
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
