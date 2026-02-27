/*
Problem: Minimum Operations to Equalize Binary String
Problem No: 3666
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- BFS
- Math
- Parity
- Graph Traversal
- Greedy

------------------------------------------------
Problem Statement:
------------------------------------------------
You are given a binary string s and integer k.

In one operation:
Choose exactly k different indices and flip them.

Return minimum operations required to make
all characters equal to '1'.
If impossible → return -1.

------------------------------------------------
Core Idea:
------------------------------------------------
Instead of tracking the entire string,
track only:

→ Number of zeros (z)

Each operation changes zero count as:

z → z + k - 2*i

Where:
i = number of chosen zero indices in operation

Because:
- i zeros become ones
- (k - i) ones become zeros

So we BFS over possible zero counts.

------------------------------------------------
Important Observations:
------------------------------------------------
1) If z == 0 → answer is 0.
2) If k == n:
      Only full flip allowed.
      If all zeros → 1 step.
      Else impossible.
3) Parity matters:
      New zero count must match parity of (z + k).

------------------------------------------------
Optimization:
------------------------------------------------
Use:
- BFS over zero count
- TreeSet to efficiently find valid next states
- Separate sets for even and odd zero counts

------------------------------------------------
Time Complexity:
------------------------------------------------
O(n log n)

Space Complexity:
------------------------------------------------
O(n)

------------------------------------------------
*/
class Solution {

    public int minOperations(String s, int k) {

        int n = s.length();
        int zeros = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }

        if (zeros == 0) return 0;

        if (k == n) {
            return (zeros == n) ? 1 : -1;
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        TreeSet<Integer> even = new TreeSet<>();
        TreeSet<Integer> odd = new TreeSet<>();

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) even.add(i);
            else odd.add(i);
        }

        queue.offer(zeros);
        visited[zeros] = true;

        if (zeros % 2 == 0) even.remove(zeros);
        else odd.remove(zeros);

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int curr = queue.poll();

                if (curr == 0) return steps;

                int lowI = Math.max(0, k - (n - curr));
                int highI = Math.min(k, curr);

                int minZeros = curr + k - 2 * highI;
                int maxZeros = curr + k - 2 * lowI;

                TreeSet<Integer> set =
                        ((curr + k) % 2 == 0) ? even : odd;

                Integer next = set.ceiling(minZeros);

                while (next != null && next <= maxZeros) {

                    visited[next] = true;
                    queue.offer(next);
                    set.remove(next);

                    next = set.ceiling(minZeros);
                }
            }

            steps++;
        }

        return -1;
    }
}
