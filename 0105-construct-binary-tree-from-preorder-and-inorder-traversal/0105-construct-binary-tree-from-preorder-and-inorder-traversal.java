import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }
    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        int mid = inorderMap.get(rootValue);
        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}