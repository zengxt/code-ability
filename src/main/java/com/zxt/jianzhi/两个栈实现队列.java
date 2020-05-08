package com.zxt.jianzhi;

import java.util.Stack;

/**
 * 
 * @Description: 使用两个栈来实现队列数据结构（主要是队列的入队与出对操作）
 *
 * @author： zxt
 *
 * @time: 2018年6月20日 下午2:23:38
 *
 */
public class 两个栈实现队列 {
	
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
	
	public static void main(String[] args) {
		// 通过两个栈来实现队列，一个用来存入队的元素，一个用来存出队的元素
		两个栈实现队列 queue = new 两个栈实现队列();
		queue.push(3);
		queue.push(2);
		queue.push(1);
		
		System.out.println(queue.pop());
		
		queue.push(4);
		System.out.println(queue.pop());
	}
	
	
    /**
     * 
     * @Description:向队列尾部添加一个元素
     * 
     * @param node
     */
    public void push(int node) {
    	stack1.push(node);
    }
    
    /**
     * 
     * @Description:从队列头部删除一个元素
     * 
     * @return
     */
    public int pop() {
    	
    	// 如果stack2中没有元素，则将stack1中的元素依次弹出并压入stack2中，两次顺序反转就和原来的顺序一样
    	if(stack2.isEmpty()) {
    		while(!stack1.isEmpty()) {
    			stack2.push(stack1.pop());
    		}
    	}
    	
    	// 如果stack2中为空，表示队列为空，无法再出队
    	if(stack2.isEmpty()) {
    		System.out.println("queue is empty!");
    		System.exit(0);
    	}
    	
		return stack2.pop();
    }

}
