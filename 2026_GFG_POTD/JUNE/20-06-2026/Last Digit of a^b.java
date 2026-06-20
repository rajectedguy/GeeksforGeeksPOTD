class Solution {
    public int getLastDigit(String a, String b) {
        if(b.equals("0")) return 1;
        if(a.equals("0")) return 0;
        int num1 = a.charAt(a.length() - 1) - '0';
        int num2 = b.charAt(b.length() - 1) - '0';
        if(b.length() >= 2) {
            int len = b.length();
            num2 = Integer.valueOf(b.substring(len - 2, len));
        }
        int mod = num2 % 4;
        num2 = mod == 0 ? 4 : mod;
        int res = (int)Math.pow(num1, num2);
        return res % 10;
    }
};