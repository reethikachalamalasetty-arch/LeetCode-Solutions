class Solution {

    public String intToRoman(int num) {
        int[] values = getValues();
        String[] symbols = getSymbols();

        return convertToRoman(num, values, symbols);
    }

    // Contribution 1: Store Roman numeral values
    private int[] getValues() {
        return new int[]{
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        };
    }

    // Contribution 2: Store Roman numeral symbols
    private String[] getSymbols() {
        return new String[]{
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        };
    }

    // Contribution 3: Convert integer into Roman numeral
    private String convertToRoman(int num, int[] values, String[] symbols) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {

            while (num >= values[i]) {
                num = num - values[i];
                result.append(symbols[i]);
            }
        }

        return result.toString();
    }
}