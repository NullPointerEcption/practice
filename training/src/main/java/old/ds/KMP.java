package old.ds;

public class KMP {
	public static void main(String[] args) {
		String s1 = "bbc abcdab abcdabcdabde";
		String s2 = "abcdabd";

		boolean res;
		// res = isChildStrBF(s1, s2);

		res = kmp(s1, s2);

		System.out.println(res);
	}

	/**
	 * brute force 最原始的 暴力比对算法
	 * 
	 * @param target
	 * @param pattern
	 */
	public static boolean isChildStrBF(String target, String pattern) {
		boolean result = false;

		char[] s1CharArr = target.toCharArray();
		char[] s2CharArr = pattern.toCharArray();

		int i = 0, startIndex = 0, j = 0;
		while (i < s1CharArr.length) {

			if (s1CharArr[i] == s2CharArr[0]) {

				startIndex = i;
				while (i < s1CharArr.length - 1 && j < s2CharArr.length - 1) {
					i++;
					j++;
					if (s1CharArr[i] != s2CharArr[j]) {
						break;
					}
				}

				if (j == s2CharArr.length - 1) {
					result = true;
					break;
				} else {
					j = 0;
					i = startIndex;
				}
			}

			i++;
		}
		System.out.println(result ? "是子串:" + "从targetStr下标[" + startIndex + "]开始匹配" : "不是子串");

		return result;
	}

	/**
	 * 使用KMP算法计算出 pattern字符串是否在target字符串当中
	 * 
	 * @param target
	 *            目标串
	 * @param pattern
	 *            模式串
	 */
	private static boolean kmp(String target, String pattern) {

		int[] partialMatchTable = createPartialMatchTable(pattern);

		char[] targetCharArr = target.toCharArray();
		char[] patterncharArr = pattern.toCharArray();
		int matchCharCounts = 0;// 记录下已经匹配的字符的个数

		int i = 0, j = 0, moveCounts = 0;
		while (i < targetCharArr.length) {

			// 如果当前主串和子串的字符匹配上了 那么比较下一个字符是否匹配
			if (targetCharArr[i] == patterncharArr[j]) {
				matchCharCounts++;
				i++;
				j++;
			}
			// 如果子串的第一个元素都不和珠串的元素相等 那么就拿主串的下一个元素进行比较
			else if (j == 0) {
				i++;
			}
			// 如果子串不是在第一个元素的位置而是在其他位置进行了失配，那么进行移位操作
			else {
				// 移动位数 = 已匹配的字符数 - 对应的部分匹配值
				// 对应匹配值 指的是最后一个字符的对应匹配值 j是失配的位置 所以这里是partialMatchTable[j - 1]
				moveCounts = matchCharCounts - partialMatchTable[j - 1];
				j = j - moveCounts;
				matchCharCounts = matchCharCounts - moveCounts;
			}

			// 如果匹配成功了 直接返回true了
			if (j == patterncharArr.length) {
				return true;
			}

		}
		return false;

	}

	/**
	 * 根据 pattern 字符串 创造出对应的部分匹配表
	 * 
	 * @param pattern
	 * @return
	 */
	private static int[] createPartialMatchTable(String pattern) {

		int patternLen = pattern.length();
		int[] matchTable = new int[patternLen];

		int i = 0;
		int matchValue = 0;
		while (i < patternLen) {
			if (i == 0) {
				matchValue = 0;
			} else {
				matchValue = calcMatchValue(pattern.substring(0, i + 1));
			}

			matchTable[i] = matchValue;
			i++;
		}

		return matchTable;
	}

	/**
	 * 根据 subStr 字符串 来计算出对应的部分匹配值
	 * 
	 * @param subStr
	 * @return
	 */
	private static int calcMatchValue(String subStr) {

		int length = subStr.length();
		String preFixStr = subStr.substring(0, length - 1);
		String suffFixStr = subStr.substring(1);

		while (preFixStr.length() > 0 && suffFixStr.length() > 0) {
			if (preFixStr.equals(suffFixStr)) {
				return preFixStr.length();
			}

			if (preFixStr.length() == 1 && suffFixStr.length() == 1) {
				break;
			}
			preFixStr = preFixStr.substring(0, preFixStr.length() - 1);
			suffFixStr = suffFixStr.substring(1, suffFixStr.length());
		}

		return 0;
	}

}
