class Solution {
    public int solve(int n, String s) {
        // code here
        Map<Character, Integer> mp = new HashMap<>();
        Set<Character> st = new HashSet<>();
        int ct = 0;
        for(Character c: s.toCharArray()) {
            if(mp.containsKey(c) && ct>0) {
                mp.remove(c);
                --ct;
            }
            else {
                if(ct<n && !st.contains(c)) {
                    ct++;
                    mp.put(c, ct);
                } else {
                    if(!st.contains(c)) st.add(c);
                }
            }
        }
        return st.size();
    }
}