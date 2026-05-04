class Solution {
    public boolean isBinaryPalindrome(int n) {
        if (n == 0) return true; 
        int l = 31 - Integer.numberOfLeadingZeros(n), r = 0;
        while (l > r) {
            int lb = ((n >> l--) & 1), rb = ((n >> r++) & 1);
            if (lb != rb) return false;
        }
        return true;
    }
}