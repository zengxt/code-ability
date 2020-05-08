package �ַ���;

import java.util.ArrayList;

/**
 * 
 * @Description: ����һ���ַ�������������п��ܵ��ַ���ϣ� ���磺abc �����������:a, b, c, ab, ac, bc, abc
 *
 * @author�� zxt
 *
 * @time: 2018��5��3�� ����11:32:49
 *
 */
public class �ַ������ַ���������� {

	public static void main(String[] args) {
		String str = "abc";
		ArrayList<String> list = new ArrayList<String>();
		
		// ������ת��ΪStringBuffer����ΪStringBuffer�����޸ģ���String������
		// allCombination(new StringBuffer(str), list);
		
		// Ҫ��һ���ַ������ַ���������ϣ����Ӵ��ĳ���Ӧ�ô� 1 �� �ַ���������
		for(int i = 1; i <= str.length(); i++) {
			StringBuffer temp = new StringBuffer();
			combinationAll(new StringBuffer(str), list, 0, i, temp);
		}
		
		System.out.println(list);
	}
	
	/**
	 * 
	 * @Description:����˼·���õ�һ���ַ�������������Լ�  abc�� Ȼ������ȥ���ַ�����һ���ַ��õ���ab��ac��bc����ȥ��һ�����õ���a��b��c���޷���ȥ
	 * 
	 * @param sb
	 * @param list
	 * @return
	 */
	public static void allCombination(StringBuffer sb, ArrayList<String> list) {
		if(sb.length() == 0) {
			return ;
			
		} else {
			if(!list.contains(sb.toString())) {
				list.add(sb.toString());
			}
		}
		
		for(int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			sb.deleteCharAt(i);
			
			allCombination(sb, list);
			
			//��i��ɾ�������i�����
			sb.insert(i, c);
		}
	}
	
	/**
	 * 
	 * @Description:��һ��˼·��ͬ�����õݹ���⡣���Կ����󳤶�Ϊn���ַ�����m���ַ�����ϣ���ΪC(n,m)��
	 * 				ԭ����Ľ⼴ΪC(n, 1), C(n, 2),...C(n, n)���ܺ͡�
	 * 				������C(n, m)���ӵ�һ���ַ���ʼɨ�裬ÿ���ַ������������Ҫô��ѡ�У�Ҫô����ѡ�У������ѡ�У��ݹ����C(n-1, m-1)��
	 * 				���δ��ѡ�У��ݹ����C(n-1, m)���������ַ�ʽ��n��ֵ������٣��ݹ����ֹ����n=0��m=0��
	 * 
	 * @param sb
	 * @param list
	 * @param index����ǰ��Ҫ�������Ԫ�أ�ѡ��  or ��ѡ��
	 * @param subLength�����ַ����ĳ���
	 * @param temp����ǰѡ�е��ַ�����
	 */
	public static void combinationAll(StringBuffer sb, ArrayList<String> list, 
			int index, int subLength, StringBuffer temp) {

		// ѡ����ַ������Ⱥ�Ҫ��ĳ���һ��
		if(0 == subLength && !list.contains(temp.toString())) {
			list.add(temp.toString());
			return ;
		}
	
		// sbΪ�ջ��� �ж��������е��ַ�  (  �������������ж���Ҫ�ĳɣ� (index == sb.length() && 0 != subLength) )
		// ��Ϊ�п���ѡ�������һ���ַ���Ȼ�����������������......
		if(sb.length() == 0 || index == sb.length()) {
			return ;
		}

		// ���ܵ�ǰ�ַ��Ƿ�ѡ����һ��Ҫ�жϵ��ַ�����
		// ѡ��ǰ�ַ�
		temp.append(sb.charAt(index));
		combinationAll(sb, list, index + 1, subLength - 1, temp);
		temp.deleteCharAt(temp.length() - 1);

		// ��ѡ��ǰ�ַ�
		combinationAll(sb, list, index + 1, subLength, temp);
	}
}
