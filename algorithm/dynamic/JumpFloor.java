package dynamic;

/**
 * @author 陈包佳
 * @version 1.0
 * @date 2020/10/21 22:19
 */
public class JumpFloor {
    public int JumpFloor(int target) {
        int[] result = new int[target+1];
        if (target == 1)return 1;
        if (target == 2)return 2;
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= target; i++){
            result[i] = result[i-1] + result[i-2];
        }
        return result[target];
    }
}
