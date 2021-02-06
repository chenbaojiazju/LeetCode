package array;

import java.util.*;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * @author 陈包佳
 * @version 1.0
 * @date 2020/10/3 19:04
 */
public class TwoSum {

    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.size();
    }

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<char[]> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            board.add(row);
        }
        backtrack(board, 0);
        return res;
    }

    public void backtrack(List<char[]> board, int row) {
        if (row == board.size()) {
            res.add(format(board));
            return;
        }
        char[] curRow = board.get(row);
        for (int col = 0; col < curRow.length; col++) {
            if (!isValid(board, row, col)) continue;
            curRow[col] = 'Q';
            backtrack(board, row + 1);
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

    public boolean isValid(List<char[]> res, int row, int col) {
        int n = res.size();
        int leftCol = col - 1;
        int rightCol = col + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (res.get(i)[col] == 'Q') return false;
            if (rightCol < 8 && 'Q' == (res.get(i)[rightCol])) return false;
            if (leftCol >= 0 && 'Q' == (res.get(i)[leftCol])) return false;
            leftCol--;
            rightCol++;
        }
        return true;
    }



    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] != a) continue;
                result[0] = i;
                result[1] = j;
            }
        }
        return result;
    }

    /**
     * 利用hash减少时间复杂度
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
