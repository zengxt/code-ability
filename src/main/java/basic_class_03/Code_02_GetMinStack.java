package basic_class_03;

import java.util.Stack;

/**
 * 
 * @Description: ʵ��O(1)ʱ�临�Ӷȷ���ջ�ṹ����Сֵ
 *
 * @author�� zxt
 *
 * @time: 2018��11��9�� ����11:21:25
 *
 */
public class Code_02_GetMinStack {
	
	public static class MyStack {
		// ���ջ����
		private Stack<Integer> stackData;
		// ������ݵ���Сֵ
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
