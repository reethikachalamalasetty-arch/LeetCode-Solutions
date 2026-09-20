class Solution {
    public boolean isNumber(String s) {
        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        boolean digitAfterE = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                digitSeen = true;

                if (eSeen) {
                    digitAfterE = true;
                }

            } else if (c == '.') {
                // Decimal point cannot appear after e/E
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;

            } else if (c == 'e' || c == 'E') {
                // e/E must occur only once and after at least one digit
                if (eSeen || !digitSeen) {
                    return false;
                }

                eSeen = true;
                digitAfterE = false;

            } else if (c == '+' || c == '-') {
                // Sign is valid only at the beginning or immediately after e/E
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }

            } else {
                return false;
            }
        }

        return digitSeen && digitAfterE;
    }
}
