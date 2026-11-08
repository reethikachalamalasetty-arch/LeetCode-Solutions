
class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMax(root);
        return maxSum;
    }

    public int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, findMax(root.left));
        int right = Math.max(0, findMax(root.right));

        int currentSum = root.val + left + right;

        maxSum = Math.max(maxSum, currentSum);

        return root.val + Math.max(left, right);
    }
}
