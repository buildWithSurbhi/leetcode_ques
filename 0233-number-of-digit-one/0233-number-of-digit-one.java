class Solution {
    public int countDigitOne(int n) {
        int count = 0;

        for (long place = 1; place <= n; place *= 10) {

            long higher = n / (place * 10);
            long current = (n / place) % 10;
            long lower = n % place;

            if (current == 0) {
                count += higher * place;
            } 
            else if (current == 1) {
                count += higher * place + lower + 1;
            } 
            else {
                count += (higher + 1) * place;
            }
        }

        return count;
    }
}