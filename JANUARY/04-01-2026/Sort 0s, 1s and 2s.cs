class Solution {
    public void sort012(int[] arr) {
        int low = 0, mid = 0, high = arr.Length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int t = arr[low];
                arr[low++] = arr[mid];
                arr[mid++] = t;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int t = arr[mid];
                arr[mid] = arr[high];
                arr[high--] = t;
            }
        }
    }
}