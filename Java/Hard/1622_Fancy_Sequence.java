/*
Problem: Fancy Sequence
Problem No: 1622
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Design
- Math
- Modular Arithmetic
- Lazy Transformation

----------------------------------
Problem Statement:
----------------------------------
Design a data structure that supports the following operations:

append(val)   → add value at the end
addAll(inc)   → add inc to all elements
multAll(m)    → multiply all elements by m
getIndex(idx) → return value at index idx

All operations are modulo 1e9 + 7.

Constraints:
Up to 100000 operations.

----------------------------------
Key Challenge:
----------------------------------
If we update every element on addAll/multAll,
each operation becomes O(n).

With up to 1e5 operations → Too slow.

----------------------------------
Key Idea (Lazy Transformation):
----------------------------------
Maintain two global values:

mul → global multiplication factor
add → global addition factor

Current value formula:

realValue = storedValue * mul + add

----------------------------------
Append Trick:
----------------------------------
When appending val, we reverse the transformation.

storedValue = (val - add) * modInverse(mul)

So when we apply the formula later,
we get the correct value.

----------------------------------
Mathematics:
----------------------------------
Modular inverse is used:

inv(x) = x^(MOD-2) % MOD

Using Fermat's Little Theorem.

----------------------------------
Operations Complexity:
----------------------------------

append     → O(log MOD)
addAll     → O(1)
multAll    → O(1)
getIndex   → O(1)

----------------------------------
Time Complexity:
----------------------------------
Total ≈ O(Q log MOD)

----------------------------------
Space Complexity:
----------------------------------
O(N)

----------------------------------
Solution:
----------------------------------
*/
class Fancy {

    static final long MOD = 1000000007;

    List<Long> arr;
    long mul;
    long add;

    public Fancy() {
        arr = new ArrayList<>();
        mul = 1;
        add = 0;
    }

    public void append(int val) {

        long inv = modInverse(mul);

        long stored = ((val - add) % MOD + MOD) % MOD;
        stored = (stored * inv) % MOD;

        arr.add(stored);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {

        if (idx >= arr.size())
            return -1;

        long val = arr.get(idx);

        return (int)((val * mul % MOD + add) % MOD);
    }

    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    private long modPow(long base, long exp) {

        long res = 1;

        while (exp > 0) {

            if ((exp & 1) == 1)
                res = res * base % MOD;

            base = base * base % MOD;
            exp >>= 1;
        }

        return res;
    }
}
