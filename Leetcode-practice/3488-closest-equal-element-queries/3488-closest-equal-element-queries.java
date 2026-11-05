import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // value -> indices list
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int q : queries) {
            int val = nums[q];
            List<Integer> list = map.get(val);

            // only one occurrence
            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            // binary search
            int pos = Collections.binarySearch(list, q);

            int m = list.size();
            int prev = list.get((pos - 1 + m) % m);
            int next = list.get((pos + 1) % m);

            int d1 = Math.abs(q - prev);
            int d2 = Math.abs(q - next);

            // circular distance
            d1 = Math.min(d1, n - d1);
            d2 = Math.min(d2, n - d2);

            ans.add(Math.min(d1, d2));
        }

        return ans;
    }
}