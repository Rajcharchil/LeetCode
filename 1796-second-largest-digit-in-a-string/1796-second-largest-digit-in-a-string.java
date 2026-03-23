class Solution {
    public int secondHighest(String s) {
        int larg = -1;
        int Slarg = -1;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int digit = c - '0';
                if (digit > larg) {
                    Slarg = larg;
                    larg = digit;
                } else if (digit < larg && digit > Slarg) {
                    Slarg = digit;
                }
            }
        }

        return Slarg;
    }
}