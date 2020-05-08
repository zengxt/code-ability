package com.zxt.jianzhi;

/**
 * 
 * @Description: ͳ��һ�����������������г��ֵĴ�����
 *
 * @author�� zxt
 *
 * @time: 2018��8��27�� ����9:44:55
 *
 */
public class �����������в������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {1, 2, 3, 3, 3, 3, 4, 5};
		System.out.println(getFirstK(data, 3, 0, data.length - 1));
		System.out.println(getLastK(data, 3, 0, data.length - 1));
		
		System.out.println(getNumberOfK(data, 3));
	}
	
	/**
	 * 
	 * @Description��ǿ����������������⣬һ����Ҫʹ�ö��ֲ����������ֱ�ӱ�����ʱ�临�Ӷȿ��ܲ�����Ҫ��
	 * 
	 * @param data
	 * @param k
	 * @return
	 */
	public static int getNumberOfK(int[] data, int k) {
		int number = 0;
		
		if(data != null && data.length > 0) {
			int first = getFirstK(data, k, 0, data.length - 1);
			int last = getLastK(data, k, 0, data.length - 1);
			
			if(first != -1 && last != -1) {
				number = last - first + 1;
			}
		}
		
		return number;
	}
	
	/**
	 * 
	 * @Description������k�����������е�һ�γ��ֵ�λ�ã����������û�и����֣��򷵻�-1
	 * 
	 * @param data
	 * @param k
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getFirstK(int[] data, int k, int start, int end) {
		if(start > end) {
			return -1;
		}
		
		int middleIndex = (start + end) / 2;
		int middleValue = data[middleIndex];
		while(start <= end) {
			// ��ǰ����Ϊk���������ǰһ��ҲΪk�Ļ������������
			if(middleValue == k) {
				if((middleIndex > 0 && data[middleIndex - 1] != k) || middleIndex == 0) {
					return middleIndex;
				} else {
					end = middleIndex - 1;
				}
				
			} else if(middleValue > k) {
				end = middleIndex - 1;
			} else {
				start = middleIndex + 1;
			}
			
			middleIndex = (start + end) / 2;
			middleValue = data[middleIndex];
		}
		
		return -1;
	}
	
	/**
	 * 
	 * @Description������k���������������һ�γ��ֵ�λ�ã����������û�и����֣��򷵻�-1
	 * 
	 * @param data
	 * @param k
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getLastK(int[] data, int k, int start, int end) {
		if(start > end) {
			return -1;
		}
		
		int middleIndex = (start + end) / 2;
		int middleValue = data[middleIndex];
		while(start <= end) {
			// ��ǰ����Ϊk��������ĺ�һ��ҲΪk�Ļ������������
			if(middleValue == k) {
				if((middleIndex < data.length - 1 && data[middleIndex + 1] != k) || middleIndex == data.length - 1) {
					return middleIndex;
				} else {
					start = middleIndex + 1;
				}
				
			} else if(middleValue > k) {
				end = middleIndex - 1;
			} else {
				start = middleIndex + 1;
			}
			
			middleIndex = (start + end) / 2;
			middleValue = data[middleIndex];
		}
		
		return -1;
	}

}
