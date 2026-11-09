
import java.util.*;

class Solution {
    public List<List<String>> findLadders(
        String beginWord, String endWord, List<String> wordList) {

        List<List<String>> result = new ArrayList<>();

        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) {
            return result;
        }

        Map<String, List<String>> parents = new HashMap<>();
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        boolean found = false;

        while (!queue.isEmpty() && !found) {

            int size = queue.size();
            Set<String> levelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();
                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {

                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == original) continue;

                        chars[j] = c;
                        String next = new String(chars);

                        if (dict.contains(next) &&
                            !visited.contains(next)) {

                            parents.putIfAbsent(
                                next, new ArrayList<>());

                            parents.get(next).add(word);

                            if (levelVisited.add(next)) {
                                queue.offer(next);
                            }

                            if (next.equals(endWord)) {
                                found = true;
                            }
                        }
                    }

                    chars[j] = original;
                }
            }

            visited.addAll(levelVisited);
        }

        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);

            dfs(endWord, beginWord, parents, path, result);
        }

        return result;
    }

    private void dfs(
        String word,
        String beginWord,
        Map<String, List<String>> parents,
        List<String> path,
        List<List<String>> result) {

        if (word.equals(beginWord)) {
            List<String> ans = new ArrayList<>(path);
            Collections.reverse(ans);
            result.add(ans);
            return;
        }

        if (!parents.containsKey(word)) {
            return;
        }

        for (String parent : parents.get(word)) {
            path.add(parent);

            dfs(parent, beginWord, parents, path, result);

            path.remove(path.size() - 1);
        }
    }
}
