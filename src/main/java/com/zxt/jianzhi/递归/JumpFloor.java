package com.zxt.jianzhi.递归;

/**
 * 
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @author： zxt
 *
 * @time: 2018年4月15日 下午8:50:59
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
