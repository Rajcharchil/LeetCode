class Solution {
    public int divide(int numerator, int denominator) {
        if (numerator == Integer.MIN_VALUE && denominator == -1) return Integer.MAX_VALUE;

        boolean negativeResult = (numerator < 0) ^ (denominator < 0);

        long magnitudeTop = Math.abs((long) numerator);
        long magnitudeBot = Math.abs((long) denominator);

        long accumulated = 0;
        long remaining   = magnitudeTop;

        while (remaining >= magnitudeBot) {
            long chunk    = magnitudeBot;
            long shiftVal = 1;

            while (remaining >= (chunk << 1)) {
                chunk    <<= 1;
                shiftVal <<= 1;
            }

            remaining   -= chunk;
            accumulated += shiftVal;
        }

        long finalResult = negativeResult ? -accumulated : accumulated;
        return (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, finalResult));
    }
}