class Solution {
  public:
    int minCandy(vector<int> &arr) {
        // code here
         int n = arr.size();
         
         vector<int> candies(n, 1);
         
         int i = 1, j = n-2, cntA = 1, cntD = 1;
         
         while(i < n && j >= 0){
             if(arr[i] > arr[i-1]){
                 cntA++;
                 candies[i] = max(candies[i], cntA);
             }
             else{
                 cntA = 1;
             }
             
             if(arr[j] > arr[j+1]){
                 cntD++;
                 candies[j] = max(candies[j], cntD);
             }
             else{
                 cntD = 1;
             }
             i++;
             j--;
         }
         
         int sum = 0;
         for(int candy: candies){
             sum += candy;
         }
         return sum;
    }
};