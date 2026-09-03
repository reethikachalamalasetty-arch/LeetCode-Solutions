import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(candidates);

        // Step 2: Start backtracking
        findCombinations(candidates, target, 0,
                         new ArrayList<>(), result);

        return result;
    }

    private void findCombinations(int[] candidates,
                                  int target,
                                  int start,
                                  List<Integer> current,
                                  List<List<Integer>> result) {

        // If target becomes 0, we found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every number from start
        for (int i = start; i < candidates.length; i++) {

            // Skip duplicate numbers at the same level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Because array is sorted
            // if current number is greater than target,
            // all numbers after it will also be greater.
            if (candidates[i] > target) {
                break;
            }

            // Choose the current number
            current.add(candidates[i]);

            // Move to i + 1
            // because every element can be used only once
            findCombinations(
                candidates,
                target - candidates[i],
                i + 1,
                current,
                result
            );

            // Remove the last element
            // and try another possibility
            current.remove(current.size() - 1);
        }
    }
}
