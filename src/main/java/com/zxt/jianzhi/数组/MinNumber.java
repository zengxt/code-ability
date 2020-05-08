package com.zxt.jianzhi.数组;

/**
 * 
 * @Description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @author： zxt
 *
 * @time: 2018年3月6日 下午8:34:33
 *
 */
public class MinNumber {

	public static void main(String[] args) {
		// 这里的数组虽然不是有序的，但是在一定程度上还是有序的，考虑使用二分查找法
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
        	// 如果p1, indexMid, p2位置的元素的值相同，那么此时无法进一步缩小查找范围，只能使用顺序查找的方式
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