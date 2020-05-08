package com.zxt.bianchengzhimei;

/**
 * 
 * @Description: 用程序来控制CPU的使用率（固定值），CPU的使用率：在任务管理器的一个刷新周期内，CPU忙（执行应用程序）的时间和刷新周期总时间的比率
 *
 * @author： zxt
 *
 * @time: 2018年6月25日 下午10:43:50
 *
 */
public class CPUUseRatio {
	
	// 工作时间
	private static long busyTime = 10;
	// 空闲时间
	private static long idleTime = busyTime; // 使用率为50%
	
	// 实际上这个比率很难控制，其他程序使用，多核CPU等，但是可以看出一条大致的直线
	
	public static void main(String[] args) {
		long startTime = 0;
		
		while(true) {
			startTime = System.currentTimeMillis();
			while( (System.currentTimeMillis() - startTime) <= busyTime ) {
				// 工作
			}
			
			// 休眠
			try {
				Thread.sleep(idleTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
