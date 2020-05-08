package com.zxt.bianchengzhimei;

/**
 * 
 * @Description: 用程序来控制CPU的使用率（sine曲线），CPU的使用率：在任务管理器的一个刷新周期内，CPU忙（执行应用程序）的时间和刷新周期总时间的比率
 *
 * @author： zxt
 *
 * @time: 2018年6月25日 下午10:43:50
 *
 */
public class CPUUseRatioSine {
	
	/**
	 * 把0-2Pi之间的弧度等分成200份进行抽样，计算每个抽样点的振幅，然后每隔300ms的时间取下一个抽样点，并让CPU工作对应振幅的时间
	 */
	
	// 抽样点数量
	private static int SAMPLING_COUNT = 200;
	// 每个抽样点对应的时间片
	private static int TOTAL_AMPLITUDE = 300;
	
	
	public static void main(String[] args) {
		double[] busySpan = new double[SAMPLING_COUNT];
		// 振幅基准线
		int amplitude = TOTAL_AMPLITUDE / 2;
		// 弧度与弧度的增量
		double radin = 0.0;
		double radinIncrement = 2.0 / (double) SAMPLING_COUNT;
		
		// 200个抽样点，每次应该工作的时间
		for(int i = 0; i < SAMPLING_COUNT; i++) {
			busySpan[i] = amplitude + Math.sin(radin * Math.PI) * amplitude;
			radin += radinIncrement;
		}
		
		long startTime = 0;
		for(int j = 0 ; ; j++) {
			startTime = System.currentTimeMillis();
			while( (System.currentTimeMillis() - startTime) <= busySpan[j % SAMPLING_COUNT] ) {
				// 工作
			}
			
			// 休眠
			try {
				Thread.sleep((long) (TOTAL_AMPLITUDE - busySpan[j % SAMPLING_COUNT]));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
