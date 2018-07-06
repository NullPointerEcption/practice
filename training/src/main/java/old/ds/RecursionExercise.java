package old.ds;

/**
 * 递归练习
 * 
 * @author Administrator
 *
 */
public class RecursionExercise {
	public static void main(String[] args) {

		RecursionExercise main = new RecursionExercise();
		System.out.println(main.fibonacci(5));
		System.out.println(main.recursiveStr("abvDEF"));
	}

	/**
	 * 斐波那契数列
	 * 
	 * @param num
	 * @return
	 */
	public int fibonacci(int num) {
		if (num == 0 || num == 1) {
			return 1;
		}
		return fibonacci(num - 1) + fibonacci(num - 2);
	}

	public String recursiveStr(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		return s.charAt(s.length() - 1) + recursiveStr(s.substring(0, s.length() - 1));
	}

}
