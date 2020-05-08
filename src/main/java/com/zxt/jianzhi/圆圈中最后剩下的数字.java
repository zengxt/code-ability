package com.zxt.jianzhi;

/**
 * 
 * @Description: 首先，让小朋友们围成一个大圈。然后，他随机指定一个数m，让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌，然后可以在礼品箱中任意的挑选礼物，
 * 并且不再回到圈中，从他的下一个小朋友开始，继续0...m-1报数....这样下去....直到剩下最后一个小朋友，可以不用表演，并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * @author： zxt
 *
 * @time: 2018年10月5日 下午9:36:05
 *
 */
public class 圆圈中最后剩下的数字 {
	
	public static void main(String[] args) {
		System.out.println(LastRemaining_Solution_Array(5, 3));
	}
	
	/**
	 * 
	 * @Description：用一个数组来模拟环
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static int LastRemaining_Solution_Array(int n, int m) {
		if(n < 1 || m < 1) {
			return -1;
		}
		
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = i;
		}
		
		int out = 0;
		int index = 0;
		int gap = 0;
		while(out != n -1) {
			if(array[index] != -1) {
				gap++;
				if(gap == m) {
					// 出局
					array[index] = -1;
					out++;
					// 重新计数
					gap = 0;
				}
			}
			
			index = (++index) % n;
		}
		
		int result = 0;
		for(int i = 0; i < n; i++) {
			if(array[i] != -1) {
				result = array[i];
				break;
			}
		}
		return result;
    }
	
	/**
	 * 
	 * @Description：用一个循环链表来模拟环
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static int LastRemaining_Solution_List(int n, int m) {
		if(n < 1 || m < 1) {
			return -1;
		}
		
		LinkNode head = new LinkNode(0);
		LinkNode pNode = head;
		LinkNode temp = null;
		for(int i = 1; i < n; i++) {
			temp = new LinkNode(i);
			pNode.next = temp;
			pNode = pNode.next;
		}
		// 构成循环链表
		temp.next = head;
		
		LinkNode p = null;
		while(n != 1) {
			p = head;
			// 先找到第m个节点的前驱
			for(int i = 1; i < m - 1; i++) {
				p = p.next;
			}
			
			// 删除第m个节点
			p.next = p.next.next;
			// 更新头结点
			head = p.next;
			n--;
		}
		
		return head.value;
    }
	
	/**
	 * 
	 * @Description：约瑟夫环问题，直接使用数学推导
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static int LastRemaining_Solution_Math(int n, int m) {
		if(n < 1 || m < 1) {
			return -1;
		}
		
		
		return m;
        
    }
}

class LinkNode {
	int value;
	LinkNode next;
	
	public LinkNode(int value) {
		this.value = value;
		this.next = null;
	}
}
