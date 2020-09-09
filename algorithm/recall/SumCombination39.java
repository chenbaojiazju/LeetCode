package recall;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * @author 陈包佳
 * @version 1.0
 * @date 2020/9/9 22:36
 */
public class SumCombination39 {

    public SumCombination39() {}

    public static void main(String[] args) {
        int[] candidates = new int[]{3,2,6,7};
        int target = 7;
//        new SumCombination39().combinationSum(candidates, target);

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] == 2) {
                continue;
            }
            System.out.println(candidates[i]);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //1.记录结果的数据结构
        List<List<Integer>> res = new ArrayList<>();
        //2.回溯算法处理candidates，记录回溯路径，满足条件的路径记录结果集：路径和结果集作为传参

        Arrays.sort(candidates);
        ArrayDeque<Integer> path = new ArrayDeque<>();
        dfs(0, target, candidates.length, candidates, res, path);
        System.out.println(res);
        return res;
    }

    private void dfs(int begin, int target, int len, int[] candidates, List<List<Integer>> res, ArrayDeque<Integer> path) {
        //1.处理回溯的终止条件

        //1.1当目标值小于0
        if (target < 0) {
            return;
        }

        //1.2当目标值满足条件
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        //2.循环获取数组中的元素，对应分支的不同
        for (int i = begin; i < len; i++) {
            //2.1剪枝处理，当排序后的数组，较小数处理已小于零，后续的数据不需处理
            if (target-candidates[i] < 0) {
                //直接跳出所有循环
                break;
            }
            //2.1记录选择的数
            path.addLast(candidates[i]);

            dfs(i, target-candidates[i], len, candidates, res, path);

            //2.3在递归结束后，需要清空记录的一次路径结果
            path.removeLast();
        }

    }
}
