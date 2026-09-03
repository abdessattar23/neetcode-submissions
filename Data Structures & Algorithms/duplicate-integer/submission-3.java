class Solution {
    public boolean hasDuplicate(int[] nums) {
    int cap = Integer.highestOneBit(Math.max(4, nums.length * 2) - 1) << 1;
    int mask = cap - 1;
    int[] table = new int[cap];
    boolean hasZero = false;

    for (int n : nums) {
        if (n == 0) {
            if (hasZero) return true;
            hasZero = true;
            continue;
        }
        int h = (n * 0x9E3779B1) >>> 1 & mask;
        while (table[h] != 0) {
            if (table[h] == n) return true;
            h = (h + 1) & mask;
        }
        table[h] = n;
    }
    return false;
}
}