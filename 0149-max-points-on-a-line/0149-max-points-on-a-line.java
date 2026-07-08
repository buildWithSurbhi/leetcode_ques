import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;

        if (n <= 2) return n;

        int result = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int max = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                int g = gcd(dx, dy);

                dx /= g;
                dy /= g;

                // Normalize sign
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    dy = 1; // vertical line
                } else if (dy == 0) {
                    dx = 1; // horizontal line
                }

                String slope = dy + "/" + dx;

                map.put(slope, map.getOrDefault(slope, 0) + 1);
                max = Math.max(max, map.get(slope));
            }

            result = Math.max(result, max + 1);
        }

        return result;
    }

    private int gcd(int a, int b) {
        if (b == 0) return Math.abs(a);
        return gcd(b, a % b);
    }
}