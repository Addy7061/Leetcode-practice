/*
Problem: Separate Squares II
Problem No: 3454
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Binary Search
- Geometry
- Sweep Line
- Interval Merging

----------------------------------
Problem Statement:
----------------------------------
You are given a list of axis-aligned squares.
Each square is defined by its bottom-left corner (x, y)
and side length l.

Find the minimum y-coordinate of a horizontal line such that
the total area covered by squares above the line is equal to
the total area covered by squares below the line.

Overlapping areas must be counted only once.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use Binary Search on the y-coordinate since the answer is continuous.
2. For a given horizontal line y = mid:
   - Each square contributes a horizontal strip below the line.
   - The height of the strip is:
       clamp(mid - square.bottom, 0, square.side)
   - Each strip contributes an x-interval [x, x + side].
3. Merge overlapping x-intervals to compute union width.
4. Area below the line = mergedWidth × height.
5. Compare with half of total union area and adjust binary search.
6. After sufficient precision, return the minimum y.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n log n log R)
Space Complexity: O(n)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public double separateSquares(int[][] squares) {
        // Step 1: Collect unique x-coordinates for coordinate compression
        Set<Integer> xCoords = new TreeSet<>();
        for (int[] s : squares) {
            xCoords.add(s[0]);
            xCoords.add(s[0] + s[2]);
        }
        List<Integer> sortedX = new ArrayList<>(xCoords);
        Map<Integer, Integer> xMap = new HashMap<>();
        for (int i = 0; i < sortedX.size(); i++) {
            xMap.put(sortedX.get(i), i);
        }

        // Step 2: Create sweep-line events
        List<Event> events = new ArrayList<>();
        for (int[] s : squares) {
            int x1 = s[0];
            int y1 = s[1];
            int l = s[2];
            int x2 = x1 + l;
            int y2 = y1 + l;
            // Add two events: start (delta +1) and end (delta -1)
            events.add(new Event(y1, 1, x1, x2));
            events.add(new Event(y2, -1, x1, x2));
        }
        // Sort events by y-coordinate
        events.sort(Comparator.comparingDouble(e -> e.y));

        // Step 3 & 4: Sweep the plane and calculate total area
        SegmentTree tree = new SegmentTree(sortedX);
        double totalArea = 0;
        double prevY = events.get(0).y;
        
        // Store the strips to use later for binary search/interpolation
        List<Strip> strips = new ArrayList<>();

        for (Event event : events) {
            double currentY = event.y;
            double dy = currentY - prevY;
            if (dy > 0 && tree.getCoveredWidth() > 0) {
                strips.add(new Strip(prevY, currentY, tree.getCoveredWidth()));
                totalArea += dy * tree.getCoveredWidth();
            }

            // Update segment tree count for the current event's x-range
            int xStartIdx = xMap.get(event.x1);
            int xEndIdx = xMap.get(event.x2);
            tree.update(xStartIdx, xEndIdx - 1, event.delta);
            prevY = currentY;
        }

        // Step 5: Find the line that divides the area in half using interpolation
        double halfArea = totalArea / 2.0;
        double accumulatedArea = 0;

        for (Strip strip : strips) {
            double stripArea = strip.height * strip.width;
            if (accumulatedArea + stripArea >= halfArea) {
                // The split line is within this strip
                double remainingAreaNeeded = halfArea - accumulatedArea;
                return strip.yStart + (remainingAreaNeeded / strip.width);
            }
            accumulatedArea += stripArea;
        }
        
        return strips.get(strips.size() - 1).yEnd; // Should not reach here with valid input
    }
}

// Helper classes for Event, Strip, and SegmentTree follow below
class Event {
    double y;
    int delta;
    int x1, x2;
    Event(double y, int delta, int x1, int x2) {
        this.y = y;
        this.delta = delta;
        this.x1 = x1;
        this.x2 = x2;
    }
}

class Strip {
    double yStart, yEnd, width, height;
    Strip(double yStart, double yEnd, double width) {
        this.yStart = yStart;
        this.yEnd = yEnd;
        this.width = width;
        this.height = yEnd - yStart;
    }
}

class SegmentTree {
    int n;
    int[] count;
    long[] coveredWidth;
    List<Integer> xs;

    SegmentTree(List<Integer> xs) {
        this.xs = xs;
        this.n = xs.size() - 1;
        this.count = new int[4 * n];
        this.coveredWidth = new long[4 * n];
    }

    void update(int i, int j, int val) {
        update(0, 0, n - 1, i, j, val);
    }

    void update(int node, int start, int end, int l, int r, int val) {
        if (start > end || start > r || end < l) return;
        if (l <= start && end <= r) {
            count[node] += val;
        } else {
            int mid = (start + end) / 2;
            update(2 * node + 1, start, mid, l, r, val);
            update(2 * node + 2, mid + 1, end, l, r, val);
        }
        recalculateCoveredWidth(node, start, end);
    }

    void recalculateCoveredWidth(int node, int start, int end) {
        if (count[node] > 0) {
            coveredWidth[node] = xs.get(end + 1) - xs.get(start);
        } else if (start == end) {
            coveredWidth[node] = 0;
        } else {
            coveredWidth[node] = coveredWidth[2 * node + 1] + coveredWidth[2 * node + 2];
        }
    }

    long getCoveredWidth() {
        return coveredWidth[0];
    }
}
