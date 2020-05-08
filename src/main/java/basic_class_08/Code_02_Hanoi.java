package basic_class_08;

/**
 * 
 * @Description: 汉诺塔问题
 *
 * @author： zxt
 *
 * @time: 2018年11月23日 上午10:20:05
 *
 */
public class Code_02_Hanoi {

	public static void hanoi(int n) {
		if (n > 0) {
			func(n, n, "left", "mid", "right");
		}
	}

	public static void func(int rest, int down, String from, String help, String to) {
		if (rest == 1) {
			System.out.println("move " + down + " from " + from + " to " + to);
		} else {
			func(rest - 1, down - 1, from, to, help);
			func(1, down, from, help, to);
			func(rest - 1, down - 1, help, from, to);
		}
	}

	public static void main(String[] args) {
		int n = 3;
		hanoi(n);
	}
}
