
import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        findPaths(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void findPaths(TreeNode root, int targetSum,
                           List<Integer> path,
                           List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        targetSum -= root.val;

        if (root.left == null && root.right == null && targetSum == 0) {
            result.add(new ArrayList<>(path));
        } else {
            findPaths(root.left, targetSum, path, result);
            findPaths(root.right, targetSum, path, result);
        }

        path.remove(path.size() - 1);
    }
}
