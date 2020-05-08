package com.zxt.test2017;

import java.util.Scanner;

/**
 * 
 * @Description: 题目描述：二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。
 * 每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
 * 对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根。
 * 小易想知道最多可以放多少块蛋糕在网格盒子里。
 * 
 * 输入描述:每组数组包含网格长宽W,H，用空格分割.(1 ≤ W、H ≤ 1000)
 * 输出描述:输出一个最多可以放的蛋糕数
 * 
 * 示例1
 * 输入
 * 3 2
 * 输出
 * 4
 *
 * @author： zxt
 *
 * @time: 2018年7月25日 上午10:31:50
 *
 */
public class 不要二 {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			int w = scanner.nextInt();
			int h = scanner.nextInt();
			
			/**
			 * 每四行四列为一个周期pattern相同（每个4行4列可以放8个蛋糕）
			 * 1 1 x x 1 1 x x 1 1
			 * 1 1 x x 1 1 x x 1 1
			 * x x 1 1 x x 1 1 x x
			 * x x 1 1 x x 1 1 x x
			 * 1 1 x x 1 1 x x 1 1
			 * 1 1 x x 1 1 x x 1 1
			 */
			// 先定义一个数组，表示出了整块之后剩余行列中可以放置蛋糕的数量
			int[][] last = {{1, 2, 2, 2}, {2, 4, 4, 4}, {2, 4, 5, 6}, {2, 4, 6, 8}};
			
			// 有规则整块的数量
			int blocks = (w / 4) * (h / 4);
			int result = blocks * 8;
			
			if(w % 4 != 0) {
				// 剩余行（整块下方）中蛋糕数量
				result += (w % 4) * 2 * (h / 4);
			}
			
			if(h % 4 != 0) {
				// 剩余列（整块右方）中蛋糕数量
				result += (h % 4) * 2 * (w / 4);
			}
			
			if(w % 4 != 0 && h % 4 != 0) {
				// 整块对角剩余行列蛋糕数量
				result += last[w % 4 - 1][h % 4 - 1];
			}
			
			System.out.println(result);
		}

	}

}
