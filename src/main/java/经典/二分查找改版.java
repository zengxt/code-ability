package 经典;

import java.util.Scanner;

/**
 * 
 * @Description: 二分查找：要求，找到返回数组下标，找不到返回数组中大于查找目标的最小数字的下标
 *
 * @author： zxt
 *
 * @time: 2018年5月5日 上午10:23:17
 *
 */
public class 二分查找改版 {

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
        
        // start  或者   end + 1
        return start;
    }
    
    /**
     * 
     * @Description：查找第一个等于或者大于key的元素，也就是说等于查找key值的元素有好多个，返回这些元素最左边的元素下标；
     * 				 如果没有等于key值的元素，则返回大于key的最左边元素下标。
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
