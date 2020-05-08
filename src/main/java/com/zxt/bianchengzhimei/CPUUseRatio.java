package com.zxt.bianchengzhimei;

/**
 * 
 * @Description: �ó���������CPU��ʹ���ʣ��̶�ֵ����CPU��ʹ���ʣ��������������һ��ˢ�������ڣ�CPUæ��ִ��Ӧ�ó��򣩵�ʱ���ˢ��������ʱ��ı���
 *
 * @author�� zxt
 *
 * @time: 2018��6��25�� ����10:43:50
 *
 */
public class CPUUseRatio {
	
	// ����ʱ��
	private static long busyTime = 10;
	// ����ʱ��
	private static long idleTime = busyTime; // ʹ����Ϊ50%
	
	// ʵ����������ʺ��ѿ��ƣ���������ʹ�ã����CPU�ȣ����ǿ��Կ���һ�����µ�ֱ��
	
	public static void main(String[] args) {
		long startTime = 0;
		
		while(true) {
			startTime = System.currentTimeMillis();
			while( (System.currentTimeMillis() - startTime) <= busyTime ) {
				// ����
			}
			
			// ����
			try {
				Thread.sleep(idleTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
