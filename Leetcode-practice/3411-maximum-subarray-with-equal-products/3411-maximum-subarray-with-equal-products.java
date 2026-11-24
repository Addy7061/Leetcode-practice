
class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            long gcd = nums[i];
            long lcm = nums[i];

            for (int j = i; j < n; j++) {
                int num = nums[j];

                prod *= num;
                gcd = findGCD(gcd, num);
                lcm = (lcm / findGCD(lcm, num)) * num;

                if (prod == lcm * gcd) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private long findGCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
