package ������;

/**
 * 
 * @Description: ����һ�ö��������жϸö������Ƿ���ƽ���������(������������ڵ���������������������1)
 *
 * @author�� zxt
 *
 * @time: 2018��8��29�� ����11:22:04
 *
 */
public class �Ƿ�ƽ������� {
	// ��̬����ֻ��������ص�ʱ���ʼ��һ�Σ�����������ʼ�����Ҳ�ᱻ���ԣ���ı侲̬������ֵ֮���´���������ɲ������Ĭ��ֵ�ˡ�
	private boolean isBalanced = true;
	
	// ����ķ�����ֱ�ӵ������������ȵĴ��룬�ֱ��������ÿ���ڵ��������������ȣ��ж����ǵ��������Ƿ�Ϊ1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		�Ƿ�ƽ������� charge = new �Ƿ�ƽ�������();
		System.out.println(charge.isBalanced(root));
	}
	
	public boolean isBalanced(TreeNode root) {
		getDepth(root);
		return isBalanced;
    }
	
	/**
	 * 
	 * @Description�������������˳����������Է�ֹ�ظ����ʽڵ�
	 * 
	 * @param root
	 * @return
	 */
	public int getDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int left = getDepth(root.getLeft());
		int right = getDepth(root.getRight());
		if(Math.abs(left - right) > 1) {
			isBalanced = false;
		}
		
		return 1 + (left > right ? left : right);
	}

}
