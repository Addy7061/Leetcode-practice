
import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        int[] newParent = parent.clone();
        int[] last = new int[26];
        Arrays.fill(last, -1);

        // Find new parents using DFS
        dfs(0, children, s, last, newParent);

        // Build modified tree
        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[newParent[i]].add(i);
        }

        int[] ans = new int[n];

        // Calculate subtree sizes
        calculate(0, tree, ans);

        return ans;
    }

    private void dfs(int node, List<Integer>[] children,
                     String s, int[] last, int[] newParent) {

        int c = s.charAt(node) - 'a';
        int previous = last[c];

        if (node != 0 && previous != -1) {
            newParent[node] = previous;
        }

        last[c] = node;

        for (int child : children[node]) {
            dfs(child, children, s, last, newParent);
        }

        last[c] = previous;
    }

    private int calculate(int node, List<Integer>[] tree, int[] ans) {
        int size = 1;

        for (int child : tree[node]) {
            size += calculate(child, tree, ans);
        }

        ans[node] = size;
        return size;
    }
}
