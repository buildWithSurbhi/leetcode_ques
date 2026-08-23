class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<int[]> events = new ArrayList<>();

        // Create start and end events
        for (int[] b : buildings) {
            int left = b[0];
            int right = b[1];
            int height = b[2];

            // Negative height = start
            events.add(new int[]{left, -height});

            // Positive height = end
            events.add(new int[]{right, height});
        }

        // Sort by x-coordinate
        // If same x:
        //   start events (-height) come first
        //   for same type, smaller value first
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // Max heap
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        // Ground level
        pq.add(0);

        // Store how many times each height occurs
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        List<List<Integer>> result = new ArrayList<>();

        int previousHeight = 0;

        for (int[] event : events) {

            int x = event[0];
            int h = event[1];

            if (h < 0) {
                // Building starts
                int height = -h;

                pq.add(height);
                count.put(height, count.getOrDefault(height, 0) + 1);

            } else {
                // Building ends
                int height = h;

                count.put(height, count.get(height) - 1);
            }

            // Remove heights which are no longer active
            while (!pq.isEmpty() && count.getOrDefault(pq.peek(), 0) == 0) {
                pq.poll();
            }

            int currentHeight = pq.peek();

            // Skyline height changed
            if (currentHeight != previousHeight) {
                result.add(Arrays.asList(x, currentHeight));
                previousHeight = currentHeight;
            }
        }

        return result;
    }
}