class Solution {
    private:
    int findPge(vector<int> &arr,vector<int> &pge,int size){
        stack<int>stk;
        for(int i=0;i<size;i++){
            while(!stk.empty() and arr[stk.top()]<arr[i])stk.pop();
            if(!stk.empty())pge[i]=stk.top();
            else pge[i]=-1;
            
            stk.push(i);
        }
    }
    int findNge(vector<int> &arr,vector<int> &nge,int size){
        stack<int>stk;
        for(int i=size-1;i>=0;i--){
            while(!stk.empty() and arr[stk.top()]<arr[i])stk.pop();
            if(!stk.empty())nge[i]=stk.top();
            else nge[i]=size;
            
            stk.push(i);
        }
    }
  public:
    int maxPeople(vector<int> &arr) {
        int size=arr.size();
        vector<int>pge(size);
        vector<int>nge(size);
        
        findPge(arr,pge,size);
        findNge(arr,nge,size);
        
        int maxRange=1;
        
        for(int i=0;i<size;i++){
            int personSeen=nge[i]-pge[i]-1;
            maxRange=max(maxRange,personSeen);
        }
        return maxRange;
    }
};