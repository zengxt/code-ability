package com.zxt.jianzhi.����;

/**
 * 
 * @Description: ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת������һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء� 
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 *
 * @author�� zxt
 *
 * @time: 2018��3��6�� ����8:34:33
 *
 */
public class MinNumber {

	public static void main(String[] args) {
		// �����������Ȼ��������ģ�������һ���̶��ϻ�������ģ�����ʹ�ö��ֲ��ҷ�
		int[] array = {3, 4, 5, -1, 1, 2};
		
		System.out.println(minNumberInRotateArray(array));
	}
	
	public static int minNumberInRotateArray(int [] array) {
		int length = array.length;
		
        if(length == 0) {
            return 0;
        }
        
        int p1 = 0;
        int p2 = length - 1;
        int indexMid = p1;
        while(array[p1] >= array[p2]) {
        	if(p2 - p1 == 1) {
        		indexMid = p2;
        		break;
        	}
        	
        	indexMid = (p1 + p2) / 2;
        	// ���p1, indexMid, p2λ�õ�Ԫ�ص�ֵ��ͬ����ô��ʱ�޷���һ����С���ҷ�Χ��ֻ��ʹ��˳����ҵķ�ʽ
        	if(array[p1] == array[p2] && array[p1] == array[indexMid]) {
        		return minInOrder(array, p1, p2);
        	}
        	
        	if(array[p1] <= array[indexMid]) {
        		p1 = indexMid;
        	} else if(array[indexMid] <= array[p2]) {
        		p2 = indexMid;
        	}
        }
        
        return array[indexMid];
    }
	
	public static int minInOrder(int[] array, int index1, int index2) {
		int min = array[index1];
		for(int i = index1; i <= index2; i++) {
			if(min > array[i]) {
				min = array[i];
			}
		}
		
		return min;
	}
	
	public static int minNumberInRotateArray2(int [] array) {
		int length = array.length;
		
        if(length == 0) {
            return 0;
        }
        
        for(int i = 0; i < length - 1; i++) {
			if(array[i] > array[i + 1]) {
				return array[i + 1];
			}
		}
        
        return array[0];
	}
}