class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // One node is null, but the other is not
        if (p == null || q == null) {
            return false;
        }

        // Compare values and recursively compare subtrees
        return p.val == q.val
            && isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }
}