class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;
        
        int[] lps = computeLPS(combined);
        
        // Length of longest palindromic prefix
        int longestPrefix = lps[combined.length() - 1];
        
        // Remaining suffix that is not part of palindrome
        String suffix = s.substring(longestPrefix);
        
        // Add reversed suffix in front
        return new StringBuilder(suffix).reverse().toString() + s;
    }
    
    private int[] computeLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0;
        
        for (int i = 1; i < n; i++) {
            while (len > 0 && str.charAt(i) != str.charAt(len)) {
                len = lps[len - 1];
            }
            if (str.charAt(i) == str.charAt(len)) {
                len++;
            }
            lps[i] = len;
        }
        return lps;
    }
}
