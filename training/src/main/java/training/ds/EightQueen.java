package training.ds;

/**
 * 在8*8的棋盘上 放置8个皇后 要求每一行每一列 每一斜列（正斜、反斜）都只能有一个皇后 也就是说每一行肯定只能有一个皇后
 * 
 * @author Administrator
 *
 */
public class EightQueen {
	private static int count = 1;

	public static void main(String[] args) {
		float a = 8.0f;
		float i = 68f;
		System.out.println(a);
		System.out.println(0.20f - 0.11f);
		Chess chess = new Chess();
		putInRow(0, chess);
	}

	/**
	 * 找寻当前行可以放置皇后的点
	 * 
	 * @param rowIndex
	 *            哪一行
	 * @param chess
	 *            棋盘
	 */
	public static void putInRow(int rowIndex, Chess chess) {
		// 已经到了最后一行了
		if (rowIndex >= chess.getRowSize()) {
			System.out.println("棋盘" + count++);
			System.out.println(chess);
		} else {
			int[] currentRow = chess.getChess()[rowIndex];

			for (int colIndex = 0; colIndex < currentRow.length; colIndex++) {

				// 先将这一行 以及其下面的所有行 全都置为0
				chess.clearBelowRow(rowIndex);

				if (chess.canBePut(rowIndex, colIndex)) {
					// 如果这一行可以放置，那么进入下一行进行放置
					chess.downPiece(rowIndex, colIndex);
					putInRow(rowIndex + 1, chess);
				}
			}

			// 如果执行到这里,表示当前行无法放置“皇后”
			// 也就说明上一行放置了“皇后”的位置这时会导致下面的行无法再进行放置
			// 因此上一行“皇后”的位置需要被重新放置

		}
	}
}

/**
 * 棋盘类 8*8格的棋盘 每个位置上1代表可以存放 0代表不可以存放
 * 
 * @author Administrator
 *
 */
class Chess {

	private int rowSize = 8;
	private int colSize = 8;
	private int[][] chess;

	public int getRowSize() {
		return rowSize;
	}

	public int getColSize() {
		return colSize;
	}

	public int[][] getChess() {
		return chess;
	}

	public Chess() {
		this.chess = new int[rowSize][colSize];
	}

	/**
	 * 将rowIndex开始的以下的所有的行都清空
	 * 
	 * @param rowIndex
	 */
	public void clearBelowRow(int rowIndex) {

		for (int i = rowIndex; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				chess[i][j] = 0;
			}
		}

	}

	/**
	 * 重新初始化棋盘 将所有棋子清空
	 */
	public void clear() {

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				chess[i][j] = 0;
			}
		}
	}

	/**
	 * 落子 将皇后放置在rowIndex行colIndex列上
	 * 
	 * @param rowIndex
	 *            行
	 * @param colIndex
	 *            列
	 */
	public void downPiece(int rowIndex, int colIndex) {
		this.chess[rowIndex][colIndex] = 1;
	}

	/**
	 * 判断第i行 第j列 是否可以被放置
	 * 
	 * @param i
	 *            行的index
	 * @param j
	 *            列的index
	 * @return 是否可以被放置
	 */
	public boolean canBePut(int rowIndex, int colIndex) {
		// 0.如果该位置已经被放置过了
		if (chess[rowIndex][colIndex] == 1)
			return false;
		// 1.判断第rowIndex行的每个元素是否有被放置过的
		for (int i = 0; i < colSize; i++) {
			if (chess[rowIndex][i] == 1) {
				return false;
			}
		}

		// 2. 判断第colIndex列的每个元素是否有被放置过的
		for (int i = 0; i < rowSize; i++) {
			if (chess[i][colIndex] == 1) {
				return false;
			}
		}

		// 3.判断对角线是否有被放置过的
		int i1 = rowIndex, j1 = colIndex;

		// 3.1 往左上方 和 右下方
		while (i1 > 0 && j1 > 0) {
			i1--;
			j1--;
			if (chess[i1][j1] == 1) {
				return false;
			}
		}
		i1 = rowIndex;
		j1 = colIndex;
		while (i1 < rowSize - 1 && j1 < colSize - 1) {
			i1++;
			j1++;
			if (chess[i1][j1] == 1) {
				return false;
			}
		}

		// 3.2 往右上方 和 左下方
		i1 = rowIndex;
		j1 = colIndex;
		while (i1 > 0 && j1 < colSize - 1) {
			i1--;
			j1++;
			if (chess[i1][j1] == 1) {
				return false;
			}
		}
		i1 = rowIndex;
		j1 = colIndex;
		while (i1 < rowSize - 1 && j1 > 0) {
			i1++;
			j1--;
			if (chess[i1][j1] == 1) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				sb.append(chess[i][j]).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
