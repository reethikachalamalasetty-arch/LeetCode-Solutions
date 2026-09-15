class Solution {
    public String getPermutation(int n, int k) {
        // Factorials: factorial[i] = i!
        int[] factorial = new int[n + 1];
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // Store available numbers
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        StringBuilder result = new StringBuilder();

        // Convert k to 0-based indexing
        k--;

        for (int i = n; i >= 1; i--) {
            int blockSize = factorial[i - 1];

            // Find which block contains the k-th permutation
            int index = k / blockSize;

            result.append(numbers.get(index));
            numbers.remove(index);

            k = k % blockSize;
        }

        return result.toString();
    }
}
