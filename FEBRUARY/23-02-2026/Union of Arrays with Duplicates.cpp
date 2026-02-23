class Solution {
  public:
    vector<int> findUnion(vector<int>& a, vector<int>& b) {
        unordered_set<int> s;
        for(int i = 0;i<(a.size()+b.size());i++)
        {
            if(i<a.size()){
                s.insert(a[i]);
            }
            if(i<b.size()){
                s.insert(b[i]);
            }
        }
        
        return vector<int>{s.begin(), s.end()};
    }
};