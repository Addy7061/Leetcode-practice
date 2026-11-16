import java.util.*;

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

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */