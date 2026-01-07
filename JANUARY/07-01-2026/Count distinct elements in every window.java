import java.util.*;

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            
            if (i >= k - 1) {
                res.add(freq.size());
                
                int left = arr[i - k + 1];
                freq.put(left, freq.get(left) - 1);
                if (freq.get(left) == 0) {
                    freq.remove(left);
                }
            }
        }
        
        return res;
    }
}