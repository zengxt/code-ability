package com.zxt.jianzhi;

/**
 * 
 * @Description: ���ȣ���С������Χ��һ����Ȧ��Ȼ�������ָ��һ����m���ñ��Ϊ0��С���ѿ�ʼ������ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸裬Ȼ���������Ʒ�����������ѡ���
 * ���Ҳ��ٻص�Ȧ�У���������һ��С���ѿ�ʼ������0...m-1����....������ȥ....ֱ��ʣ�����һ��С���ѣ����Բ��ñ��ݣ������õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��
 * ������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
 *
 * @author�� zxt
 *
 * @time: 2018��10��5�� ����9:36:05
 *
 */
public class ԲȦ�����ʣ�µ����� {
	
	public static void main(String[] args) {
		System.out.println(LastRemaining_Solution_Array(5, 3));
	}
	
	/**
	 * 
	 * @Description����һ��������ģ�⻷
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
					// ����
					array[index] = -1;
					out++;
					// ���¼���
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
	 * @Description����һ��ѭ��������ģ�⻷
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
		// ����ѭ������
		temp.next = head;
		
		LinkNode p = null;
		while(n != 1) {
			p = head;
			// ���ҵ���m���ڵ��ǰ��
			for(int i = 1; i < m - 1; i++) {
				p = p.next;
			}
			
			// ɾ����m���ڵ�
			p.next = p.next.next;
			// ����ͷ���
			head = p.next;
			n--;
		}
		
		return head.value;
    }
	
	/**
	 * 
	 * @Description��Լɪ�����⣬ֱ��ʹ����ѧ�Ƶ�
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
