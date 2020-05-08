package ����;

import java.util.Scanner;

/**
 * 
 * @Description: ���ֲ��ң�Ҫ���ҵ����������±꣬�Ҳ������������д��ڲ���Ŀ�����С���ֵ��±�
 *
 * @author�� zxt
 *
 * @time: 2018��5��5�� ����10:23:17
 *
 */
public class ���ֲ��Ҹİ� {

	private static Scanner in;

	public static void main(String[] args) {
        in = new Scanner(System.in);
        
        String[] str = in.nextLine().split(" ");
        int[] arr = new int[str.length];
        for(int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        
        while(in.hasNext()) {
        	int value = in.nextInt();
            
            System.out.println(binSearch(arr, 0, arr.length, value));
            System.out.println(findFirstEqualLarger(arr, value));
        }
    }
    
    public static int binSearch(int[] arr, int start, int end, int value) {
        if(arr.length == 0 || value < arr[0]) {
            return 0;
        }
        
        if(value > arr[arr.length - 1]) {
            return arr.length;
        }
        
        int mid = (start + end) / 2;
        if(start <= end) {
            if(value == arr[mid]) {
                return mid;
            }
            
            if(value < arr[mid]) {
                return binSearch(arr, start, mid - 1, value);
            } else {
                return binSearch(arr, mid + 1, end, value);
            }
        }
        
        // start  ����   end + 1
        return start;
    }
    
    /**
     * 
     * @Description�����ҵ�һ�����ڻ��ߴ���key��Ԫ�أ�Ҳ����˵���ڲ���keyֵ��Ԫ���кö����������ЩԪ������ߵ�Ԫ���±ꣻ
     * 				 ���û�е���keyֵ��Ԫ�أ��򷵻ش���key�������Ԫ���±ꡣ
     * 
     * @param array
     * @param key
     * @return
     */
    public static int findFirstEqualLarger(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
