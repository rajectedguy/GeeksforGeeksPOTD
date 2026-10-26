class Solution {
	public int minDiff(int k, int[] arr) {
		// code here
		int n = arr.length;
		
		int[] minFromLeft = new int[n];
		int[] maxFromLeft = new int[n];
		
		int[] minFromRight = new int[n];
		int[] maxFromRight = new int[n];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0 ; i < n ; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
			minFromLeft[i] = min;
			maxFromLeft[i] = max;
		}
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		for (int i = n - 1 ; i >= 0 ; i--) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
			minFromRight[i] = min;
			maxFromRight[i] = max;
		}
		
		int ans = Integer.MAX_VALUE;
		for (int i = k - 1 ; i < n ; i++) {
			int leftMin = (i - k < 0 ? Integer.MAX_VALUE : minFromLeft[i - k]);
			int rightMin = (i + 1 >= n ? Integer.MAX_VALUE : minFromRight[i + 1]);
			
			int overAllRestMin = Math.min(leftMin, rightMin);
			
			int leftMax = (i - k < 0 ? Integer.MIN_VALUE : maxFromLeft[i - k]);
			int rightMax = (i + 1 >= n ? Integer.MIN_VALUE : maxFromRight[i + 1]);
			
			int overAllRestMax = Math.max(leftMax, rightMax);
			
			ans = Math.min(ans, (overAllRestMax - overAllRestMin));
		}
		return ans;
	}
}