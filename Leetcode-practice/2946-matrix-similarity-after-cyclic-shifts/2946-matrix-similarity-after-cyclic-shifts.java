class Solution {
    public boolean areSimilar(int[][] mat, int k) {

        int m = mat.length, n = mat[0].length;

        k = k % n; // important optimization

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int expected;

                if (i % 2 == 0) {
                    // even row → left shift
                    expected = mat[i][(j + k) % n];
                } else {
                    // odd row → right shift
                    expected = mat[i][(j - k + n) % n];
                }

                if (mat[i][j] != expected)
                    return false;
            }
        }

        return true;
    }
}