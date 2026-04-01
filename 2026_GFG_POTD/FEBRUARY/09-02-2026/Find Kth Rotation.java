class Solution {
    
    public int binarySearch(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        int n = arr.length;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] <= arr[n - 1]){
                index = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return index;
    }
    public int findKRotation(int arr[]) {
        // Code here
        return binarySearch(arr);
    }
}