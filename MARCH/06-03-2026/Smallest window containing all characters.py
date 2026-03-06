from collections import Counter
class Solution:
    def minWindow(self, s, p):
        need = Counter(p)
        window = {}
        
        have = 0
        need_count = len(need)
        
        left = 0
        min_len = float("inf")
        result = ""
        
        for right in range(len(s)):
            char = s[right]
            window[char] = window.get(char, 0) + 1
        
            if char in need and window[char] == need[char]:
                have += 1
        
            # shrink window
            while have == need_count:
                if (right - left + 1) < min_len:
                    min_len = right - left + 1
                    result = s[left:right+1]
        
                window[s[left]] -= 1
                if s[left] in need and window[s[left]] < need[s[left]]:
                    have -= 1
        
                left += 1
        
        return result