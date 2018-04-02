package interview.other;

import java.lang.reflect.Field;

/**
 * 使用反射，交换两个数
 */
public class Swap {
	private static int a = 500;

	public static void main(String[] args) throws Exception {
		Integer n1 = new Integer(5);
		Integer n2 = new Integer(7);

		System.out.println(n1 + "," + n2);

		swap(n1, n2);

		System.out.println(n1 + "," + n2);

	}

	private static void swap(Integer p1, Integer p2) throws Exception {
		Integer temp = p1.intValue();

		Field f_value = Integer.class.getDeclaredField("value");
		f_value.setAccessible(true);// 强制获取私有变量

		Field f_modifiers = Field.class.getDeclaredField("modifiers");
		f_modifiers.setAccessible(true);
		System.out.println(f_value.getModifiers());
		f_modifiers.setInt(f_value, 2);

		f_value.set(p1, p2.intValue());
		f_value.set(p2, temp.intValue());

	}

}
