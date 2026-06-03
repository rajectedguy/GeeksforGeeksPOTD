class Solution {
    public int LowerBound(ArrayList<Integer> nums, int target) {
        int low = 0;
        int high = nums.size();
        
        while(low < high) {
            int mid = low + ((high-low) / 2);
            
            if(nums.get(mid) < target) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        
        return low;
    }
    
    public int UpperBound(ArrayList<Integer> nums, int target) {
        int low = 0;
        int high = nums.size();
        
        while(low < high) {
            int mid = low + ((high-low) / 2);
            
            if(nums.get(mid) <= target) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        
        return low;
    }
    
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        final int size = arr.length;
        final int qSize = queries.length;
        ArrayList<Integer> ans = new ArrayList<>(qSize);
        Map<Integer, ArrayList<Integer>> mp = new HashMap<>();
        
        for(int i = 0; i < size; i++) {
            mp.putIfAbsent(arr[i], new ArrayList<Integer>());
            mp.get(arr[i]).add(i);
        }
        
        for(int[] q: queries) {
            int lbVal = q[0];
            int ubVal = q[1];
            ArrayList<Integer> v = mp.getOrDefault(q[2], new ArrayList<Integer>());
            
            int LB = LowerBound(v, lbVal);
            int UB = UpperBound(v, ubVal);
            
            ans.add(UB - LB);
        }
        
        return ans;
    }
}