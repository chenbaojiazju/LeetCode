//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 741 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<char[]> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            board.add(row);
        }
        backtrack(board, 0, n);
        return res;
    }

    public void backtrack(List<char[]> board, int row, int n) {
        if (row == board.size()) {
            res.add(format(board));
            return;
        }
        char[] curRow = board.get(row);
        for (int col = 0; col < curRow.length; col++) {
            if (!isValid(board, row, col, n)) continue;
            curRow[col] = 'Q';
            backtrack(board, row + 1, n);
            curRow[col] = '.';
        }
    }

    public List<String> format(List<char[]> board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.size(); i++) {
            res.add(new String(board.get(i)));
        }
        return res;
    }

    public boolean isValid(List<char[]> board, int row, int col, int n) {
        int leftCol = col - 1;
        int rightCol = col + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (board.get(i)[col] == 'Q') return false;
            if (rightCol < n && 'Q' == (board.get(i)[rightCol])) {

                return false;
            }
            if (leftCol >= 0 && 'Q' == (board.get(i)[leftCol])) return false;
            leftCol--;
            rightCol++;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
