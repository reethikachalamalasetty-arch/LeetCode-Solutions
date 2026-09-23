import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < words.length) {

            // Find how many words can fit in this line
            int j = i;
            int lineLength = 0;

            while (j < words.length) {
                int newLength = lineLength + words[j].length();

                // Add one space between words
                if (j > i) {
                    newLength++;
                }

                if (newLength > maxWidth) {
                    break;
                }

                lineLength = newLength;
                j++;
            }

            int numberOfWords = j - i;

            StringBuilder line = new StringBuilder();

            // Last line OR only one word
            if (j == words.length || numberOfWords == 1) {

                for (int k = i; k < j; k++) {
                    if (k > i) {
                        line.append(" ");
                    }
                    line.append(words[k]);
                }

                // Add spaces at the end
                while (line.length() < maxWidth) {
                    line.append(" ");
                }

            } else {

                // Fully justified line
                int totalWordsLength = 0;

                for (int k = i; k < j; k++) {
                    totalWordsLength += words[k].length();
                }

                int totalSpaces = maxWidth - totalWordsLength;
                int gaps = numberOfWords - 1;

                int spacesPerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        // Give extra spaces to left gaps
                        int spaces = spacesPerGap;

                        if (k - i < extraSpaces) {
                            spaces++;
                        }

                        for (int s = 0; s < spaces; s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());

            i = j;
        }

        return result;
    }
}