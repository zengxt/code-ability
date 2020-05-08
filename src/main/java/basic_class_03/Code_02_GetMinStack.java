package basic_class_03;

import java.util.Stack;

/**
 * 
 * @Description: 实现O(1)时间复杂度返回栈结构的最小值
 *
 * @author： zxt
 *
 * @time: 2018年11月9日 上午11:21:25
 *
 */
public class Code_02_GetMinStack {
	
	public static class MyStack {
		// 存放栈数据
		private Stack<Integer> stackData;
		// 存放数据的最小值
		private Stack<Integer> stackMin;

		public MyStack() {
			this.stackData = new Stack<Integer>();
			this.stackMin = new Stack<Integer>();
		}

		public void push(int newNum) {
			if (this.stackMin.isEmpty()) {
				this.stackMin.push(newNum);
			} else if (newNum <= this.getmin()) {
				this.stackMin.push(newNum);
			}
			this.stackData.push(newNum);
		}

		public int pop() {
			if (this.stackData.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			this.stackMin.pop();
			return this.stackData.pop();
		}

		public int getmin() {
			if (this.stackMin.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			return this.stackMin.peek();
		}
	}

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(3);
		System.out.println(stack.getmin());
		stack.push(4);
		System.out.println(stack.getmin());
		stack.push(1);
		System.out.println(stack.getmin());
		System.out.println(stack.pop());
		System.out.println(stack.getmin());
	}
}
