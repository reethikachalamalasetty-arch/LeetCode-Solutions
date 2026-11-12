
class Solution {
    public int sumNumbers(TreeNode root) {
        return calculateSum(root, 0);
    }

    public int calculateSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return sum;
        }

        return calculateSum(root.left, sum) +
               calculateSum(root.right, sum);
    }
}
