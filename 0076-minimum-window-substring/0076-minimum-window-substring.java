class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] freq = new int[128];

        // Store required character frequencies
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0;
        int right = 0;
        int required = t.length();

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            // Character is needed
            if (freq[c] > 0) {
                required--;
            }

            freq[c]--;
            right++;

            // Window contains all characters of t
            while (required == 0) {
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);
                freq[leftChar]++;

                if (freq[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
}