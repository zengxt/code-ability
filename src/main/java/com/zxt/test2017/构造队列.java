package com.zxt.test2017;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @Description: 小明同学把1到n这n个数字按照一定的顺序放入了一个队列Q中。现在他对队列Q执行了如下程序：
 * while(!Q.empty())              //队列不空，执行循环
 * {
 * 		int x=Q.front();         //取出当前队头的值x
 * 		Q.pop();                 //弹出当前队头
 * 		Q.push(x);               //把x放入队尾
 * 		x = Q.front();           //取出这时候队头的值
 * 		printf("%d\n",x);        //输出x
 * 		Q.pop();                 //弹出这时候的队头
 * }
 * 做取出队头的值操作的时候，并不弹出当前队头。
 * 
 * 小明同学发现，这段程序恰好按顺序输出了1,2,3,...,n。现在小明想让你构造出原始的队列，你能做到吗？
 * 
 * 输入描述:第一行一个整数T（T ≤ 100）表示数据组数，每组数据输入一个数n（1 ≤ n ≤ 100000），输入的所有n之和不超过200000。
 * 
 * 输出描述:对于每组数据，输出一行，表示原始的队列。数字之间用一个空格隔开，不要在行末输出多余的空格.
 * 
 * 示例1
 * 输入
 * 4
 * 1
 * 2
 * 3
 * 10
 * 
 * 输出
 * 1
 * 2 1
 * 2 1 3
 * 8 1 6 2 10 3 7 4 9 5
 *
 * @author： zxt
 *
 * @time: 2018年8月19日 下午3:12:43
 *
 */
public class 构造队列 {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		for(int i = 0; i < num; i++) {
			int n = scanner.nextInt();
			
			int[] result = getQueue(n);
			for(int j = 0; j < result.length; j++) {
				if(j != result.length - 1) {
					System.out.print(result[j] + " ");
				} else {
					System.out.println(result[j]);
				}
			}
			
			ArrayList<Integer> result2 = getQueue2(n);
			for(int j = 0; j < result2.size(); j++) {
				if(j != result2.size() - 1) {
					System.out.print(result2.get(j) + " ");
				} else {
					System.out.println(result2.get(j));
				}
			}
			
		}
	}
	
	/**
	 * 
	 * @Description：由于出队的序列为将队头放到队尾，然后输出队头，循环操作。因此下一次要出队的元素总是在第二个位置，因此每次间隔一个空位填充元素即可
	 * 
	 * @param n
	 * @return
	 */
	public static int[] getQueue(int n) {
		int[] result = new int[n];
		
		if(n == 1) {
			result[0] = 1;
			
		} else {
			int data = 1;
			int index = 0;
			int times = n;
			boolean flag = false;
			while(times != 0) {
				
				// 间隔一个0
				while(!flag) {
					if(result[index] == 0) {
						flag = true;
					}
					index = (index + 1) % n;
				}
				while(result[index] != 0) {
					index = (index + 1) % n;
				}
				flag = false;
				
				result[index] = data++;
				times--;
			}
		}
		
		return result;
	}
	
	/**
	 * 
	 * @Description：出队顺序，队头元素放到到队尾，然后出队，重新构造的话就完全反过来，每次入队，入队后，将队尾元素放到队头，并且序列也要反过来
	 * 
	 * @param n
	 * @return
	 */
	public static ArrayList<Integer> getQueue2(int n) {
		// 用一个数组来模拟队列，数组下标为0表示队头
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i = n; i > 0; i--) {
			result.add(0, i);
			result.add(0, result.remove(result.size() - 1));
		}
		
		return result;
	}

}
