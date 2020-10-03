/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * @author 陈包佳
 * @version 1.0
 * @date 2020/10/3 20:09
 */
public class KthLargest {

    private int ans, count;

    private int kthLargest(TreeNode root, int k) {
        int t = size(root.right);
        if (t == k-1) {
            return root.val;
        }
        if (t > k-1) {
            return kthLargest(root.right, k);
        }
        return kthLargest(root.left, k - t - 1);
    }

    private int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    /**
     * 利用in-order
     */
    public int kthLargest1(TreeNode root, int k) {
        inOrder(root, k);
        return ans;
    }

    private void inOrder(TreeNode root, int k) {
        if (root.right != null) {
            inOrder(root.right, k);
        }
        if ( ++count == k) {
            ans = root.val;
            return;
        }
        if (root.left != null) {
            inOrder(root.left, k);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}