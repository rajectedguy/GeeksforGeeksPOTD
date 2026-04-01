class Solution {
public:
    int minMen(vector<int>& arr) {
        int n = arr.size();
        vector<pair<int,int>> intervals;
        
        for(int i = 0; i < n; i++) {
            if(arr[i] != -1) {
                int start = max(0, i - arr[i]);
                int end = min(n - 1, i + arr[i]);
                intervals.push_back({start, end});
            }
        }
        
        sort(intervals.begin(), intervals.end());
        
        int ans = 0, i = 0, covered = 0, farthest = 0;
        while(covered < n) {
            bool found = false;
            while(i < intervals.size() && intervals[i].first <= covered) {
                farthest = max(farthest, intervals[i].second);
                i++;
                found = true;
            }
            if(!found) return -1;
            covered = farthest + 1;
            ans++;
        }
        return ans;
    }
};