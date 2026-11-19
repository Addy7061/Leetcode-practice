class Solution {
    public boolean checkOnesSegment(String s) {
        // If "01" appears, it means a new segment of 1s starts again later
        return !s.contains("01");
    }
}