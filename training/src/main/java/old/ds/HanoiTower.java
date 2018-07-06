package old.ds;

/**
 * 汉诺塔
 * 
 * @author Administrator
 *
 */
public class HanoiTower {

	private static long count = 0;

	/**
	 * 移动汉诺塔 由x借助y移动到z 打印总共的步骤
	 * 
	 * @param num
	 *            多少层
	 * @param x
	 *            原来的塔
	 * @param y
	 *            中间塔(借助塔)
	 * @param z
	 *            目标塔
	 */
	public static void move(int num, char x, char y, char z) {
		// 只要移动一个
		if (num == 1) {
			// System.out.println("从" + x + "移动到" + z);
			moveProc(x, z);
		} else {
			// 1.将n-1个移动到y上
			move(num - 1, x, z, y);
			// 2.将第n个移动到z上
			// System.out.println("从" + x + "移动到" + z);
			moveProc(x, z);
			// 3.将y上的n-1个移动到z上
			move(num - 1, y, x, z);
		}
	}

	private static void moveProc(char x, char z) {
		count++;
		System.out.println("从" + x + "移动到" + z);
	}

	public static void main(String[] args) {
		// move(10, 'X', 'Y', 'Z');
		// System.out.println("共计" + count + "步");
		System.out.println(Math.pow(2, 32) - 1);
	}

}
