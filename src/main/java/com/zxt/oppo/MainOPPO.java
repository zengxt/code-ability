package com.zxt.oppo;
import java.util.HashSet;
import java.util.Random;

public class MainOPPO {

	public static void main(String[] args) {
		// ����10�����ظ�������
		HashSet<Integer> set = new HashSet<Integer>();
		Random random = new Random();
		while(set.size() != 10) {
			int temp = random.nextInt(1000);
			set.add(temp);
		}
		int[] data = new int[10];
		int index = 0;
		for(Integer value : set) {
			data[index++] = value;
		}
		
		System.out.println("���������������ݣ�");
		for(int i = 0; i < data.length; i++) {
			if(i != data.length - 1) {
				System.out.print(data[i] + " ");
			} else {
				System.out.println(data[i]);
			}
		}
		
		// ���ݷ�ת
		int temp = 0;
		for(int i = 0; i < data.length; i++) {
			temp = 0;
			int currData = data[i];
			while(currData != 0) {
				temp += currData % 10;
				currData /= 10;
				temp *= 10;
			}
			
			data[i] = temp / 10;
		}
		
		System.out.println("�����ת������ݣ�");
		for(int i = 0; i < data.length; i++) {
			if(i != data.length - 1) {
				System.out.print(data[i] + " ");
			} else {
				System.out.println(data[i]);
			}
		}
		
		// ����
		boolean flag = false;
		for(int i = 0; i < data.length - 1; i++) {
			flag = false;
			for(int j = 0; j < data.length - i - 1; j++) {
				if(data[j] < data[j + 1]) {
					int cur = data[j];
					data[j] = data[j + 1];
					data[j + 1] = cur;
					flag = true;
				}
			}
			
			if(!flag) {
				break;
			}
		}
		System.out.println("��ת����������ݣ�");
		for(int i = 0; i < data.length; i++) {
			if(i != data.length - 1) {
				System.out.print(data[i] + " ");
			} else {
				System.out.println(data[i]);
			}
		}
	}
}
