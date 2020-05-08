package com.zxt.jianzhi;

import java.util.Stack;

/**
 * 
 * @Description: ʹ������ջ��ʵ�ֶ������ݽṹ����Ҫ�Ƕ��е��������Բ�����
 *
 * @author�� zxt
 *
 * @time: 2018��6��20�� ����2:23:38
 *
 */
public class ����ջʵ�ֶ��� {
	
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
	
	public static void main(String[] args) {
		// ͨ������ջ��ʵ�ֶ��У�һ����������ӵ�Ԫ�أ�һ����������ӵ�Ԫ��
		����ջʵ�ֶ��� queue = new ����ջʵ�ֶ���();
		queue.push(3);
		queue.push(2);
		queue.push(1);
		
		System.out.println(queue.pop());
		
		queue.push(4);
		System.out.println(queue.pop());
	}
	
	
    /**
     * 
     * @Description:�����β�����һ��Ԫ��
     * 
     * @param node
     */
    public void push(int node) {
    	stack1.push(node);
    }
    
    /**
     * 
     * @Description:�Ӷ���ͷ��ɾ��һ��Ԫ��
     * 
     * @return
     */
    public int pop() {
    	
    	// ���stack2��û��Ԫ�أ���stack1�е�Ԫ�����ε�����ѹ��stack2�У�����˳��ת�ͺ�ԭ����˳��һ��
    	if(stack2.isEmpty()) {
    		while(!stack1.isEmpty()) {
    			stack2.push(stack1.pop());
    		}
    	}
    	
    	// ���stack2��Ϊ�գ���ʾ����Ϊ�գ��޷��ٳ���
    	if(stack2.isEmpty()) {
    		System.out.println("queue is empty!");
    		System.exit(0);
    	}
    	
		return stack2.pop();
    }

}
