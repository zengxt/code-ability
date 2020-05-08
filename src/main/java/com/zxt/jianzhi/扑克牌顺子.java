package com.zxt.jianzhi;

/**
 * 
 * @Description: LL今天心情特别好，因为他去买了一副扑克牌，发现里面居然有2个大王，2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌，想测测自己的手气，看看能不能抽到顺子，如果抽到的话，他决定去买体育彩票，嘿嘿！！
 * “红心A，黑桃3，小王，大王，方片5”，“Oh My God!”不是顺子.....LL不高兴了，他想了想，决定大\小 王可以看成任何数字，并且A看作1，J为11，Q为12，K为13。
 * 上面的5张牌就可以变成“1，2，3，4，5”(大小王分别看作2和4)，“So Lucky!”。LL决定去买体育彩票啦。 
 * 现在，要求你使用这幅牌模拟上面的过程，然后告诉我们LL的运气如何，如果牌能组成顺子就输出true，否则就输出false。为了方便起见，你可以认为大小王是0。
 *
 * @author： zxt
 *
 * @time: 2018年10月5日 下午8:49:04
 *
 */
public class 扑克牌顺子 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 3, 2, 5, 4};
		System.out.println(isContinuous(numbers));
	}
	
	/**
	 * 
	 * @Description：由于一副牌中最多只有14个面值（0-13），因此可以定义一个长度为14的数组来排序5个牌，统计其中0的个数，以及相邻牌之间的间隔大小
	 * 
	 * @param numbers
	 * @return
	 */
	public static boolean isContinuous(int [] numbers) {
		if(numbers == null || numbers.length < 1) {
			return false;
		}
		
		int[] times = new int[14];
		for(int i = 0; i < numbers.length; i++) {
			times[numbers[i]]++;
		}
		
		// 0的个数
		int numberOfZero = times[0];
		// 间隔的个数（间隔可以通过0的转换来填补，所以当 numberOfZero > numberOfGap时，数组就还是连续的）
		int numberOfGap = 0;
		int pre = -1;
		// 注意这里j是牌的面值，times[j]是该面值出现的次数
		for(int j = 1; j < times.length; j++) {
			// 出现了对子，则肯定不是顺子
			if(times[j] > 1) {
				return false;
			}
			
			if(times[j] != 0) {
				if(pre == -1) {
					pre = j;
				} else {
					numberOfGap += j - pre - 1;
					pre = j;
				}
			}
			
			if(numberOfGap > numberOfZero) {
				return false;
			}
		}
		
		return numberOfZero >= numberOfGap;
    }
}
