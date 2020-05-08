package com.zxt.bianchengzhimei;

/**
 * 
 * @Description: �ó���������CPU��ʹ���ʣ�sine���ߣ���CPU��ʹ���ʣ��������������һ��ˢ�������ڣ�CPUæ��ִ��Ӧ�ó��򣩵�ʱ���ˢ��������ʱ��ı���
 *
 * @author�� zxt
 *
 * @time: 2018��6��25�� ����10:43:50
 *
 */
public class CPUUseRatioSine {
	
	/**
	 * ��0-2Pi֮��Ļ��ȵȷֳ�200�ݽ��г���������ÿ��������������Ȼ��ÿ��300ms��ʱ��ȡ��һ�������㣬����CPU������Ӧ�����ʱ��
	 */
	
	// ����������
	private static int SAMPLING_COUNT = 200;
	// ÿ���������Ӧ��ʱ��Ƭ
	private static int TOTAL_AMPLITUDE = 300;
	
	
	public static void main(String[] args) {
		double[] busySpan = new double[SAMPLING_COUNT];
		// �����׼��
		int amplitude = TOTAL_AMPLITUDE / 2;
		// �����뻡�ȵ�����
		double radin = 0.0;
		double radinIncrement = 2.0 / (double) SAMPLING_COUNT;
		
		// 200�������㣬ÿ��Ӧ�ù�����ʱ��
		for(int i = 0; i < SAMPLING_COUNT; i++) {
			busySpan[i] = amplitude + Math.sin(radin * Math.PI) * amplitude;
			radin += radinIncrement;
		}
		
		long startTime = 0;
		for(int j = 0 ; ; j++) {
			startTime = System.currentTimeMillis();
			while( (System.currentTimeMillis() - startTime) <= busySpan[j % SAMPLING_COUNT] ) {
				// ����
			}
			
			// ����
			try {
				Thread.sleep((long) (TOTAL_AMPLITUDE - busySpan[j % SAMPLING_COUNT]));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
