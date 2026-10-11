
import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        solve(s, 0, 0, "", ans);
        return ans;
    }

    void solve(String s, int index, int parts, String ip,
               List<String> ans) {
        if (parts == 4 && index == s.length()) {
            ans.add(ip.substring(0, ip.length() - 1));
            return;
        }

        if (parts == 4 || index == s.length())
            return;

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);
            int num = Integer.parseInt(part);

            if (num > 255 || (len > 1 && part.charAt(0) == '0'))
                continue;

            solve(s, index + len, parts + 1, ip + part + ".", ans);
        }
    }
}
