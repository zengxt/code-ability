package com.zxt.jianzhi.�ݹ�;

/**
 * 
 * @Description: һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
 *
 * @author�� zxt
 *
 * @time: 2018��4��15�� ����8:50:59
 *
 */
public class JumpFloor {

	public static void main(String[] args) {
		System.out.println(jumpFloor(5));
	}
	
	public static int jumpFloor(int target) {
		if(target == 1) {
			return 1;
		}
		
		if(target == 2) {
			return 2;
		}
		
		return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

}
