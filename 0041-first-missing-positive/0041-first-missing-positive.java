import java.util.HashSet;

class Solution {
    public int firstMissingPositive(int[] nums) {

        // Step 1: Store all positive numbers in a HashSet
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }

        // Step 2: Start checking from 1
        int answer = 1;

        // Step 3: Keep increasing answer while it exists
        while (set.contains(answer)) {
            answer++;
        }

        // Step 4: The first number that doesn't exist is our answer
        return answer;
    }
}
