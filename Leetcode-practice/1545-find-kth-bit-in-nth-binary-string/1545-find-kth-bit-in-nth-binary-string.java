class Solution {
    public char findKthBit(int n, int k) {
        return solve(n, k);
    }
    
    private char solve(int n, int k) {
        if (n == 1) return '0';
        
        int len = (1 << n) - 1;        // length of Sn
        int mid = (len + 1) / 2;       // middle position
        
        if (k == mid) return '1';
        
        if (k < mid) {
            return solve(n - 1, k);
        } else {
            // mirrored position
            int mirroredPos = len - k + 1;
            char bit = solve(n - 1, mirroredPos);
            // invert the bit
            return (bit == '0') ? '1' : '0';
        }
    }
}