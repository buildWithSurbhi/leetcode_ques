class Solution {
    public int calculate(String s) {
        int result = 0;
        int last = 0;
        int num = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Build the number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // Process operator or last character
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {

                if (op == '+') {
                    result += last;
                    last = num;
                }
                else if (op == '-') {
                    result += last;
                    last = -num;
                }
                else if (op == '*') {
                    last = last * num;
                }
                else if (op == '/') {
                    last = last / num;
                }

                op = ch;
                num = 0;
            }
        }

        return result + last;
    }
}