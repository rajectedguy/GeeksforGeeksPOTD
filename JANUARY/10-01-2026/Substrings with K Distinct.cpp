class Solution {
  public:
    int countSubstr(string& s, int k) {
        // // code here
    
        vector<int> freq1(26, 0), freq2(26, 0);
        int cnt1 = 0, cnt2 = 0;
        int m = 0, n = 0;
        int ans = 0;
    
        for (int i = 0; i < s.size(); i++) {
    
            if (freq1[s[i] - 'a']++ == 0)
                cnt1++;
    
            if (freq2[s[i] - 'a']++ == 0)
                cnt2++;
    
            while (cnt1 > k) {
                if (--freq1[s[m] - 'a'] == 0)
                    cnt1--;
                m++;
            }
    
            while (cnt2 > k - 1) {
                if (--freq2[s[n] - 'a'] == 0)
                    cnt2--;
                n++;
            }
    
            ans += (m - n);
        }
    
        return ans;

        
    }
}