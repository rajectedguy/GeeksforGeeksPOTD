class Solution {
	public int minimumSum(String s) {
		int n = s.length();
		
		for (int i = 0; i < n / 2; i++) {
			char left = s.charAt(i);
			char right = s.charAt(n - 1 - i);
			
			if (left != '?' && right != '?' && left != right) {
				return - 1;
			}
		}
		
		int sum = 0;
		char prev = '?';
		
		for (int i = 0; i <= (n - 1) / 2; i++) {
			char left = s.charAt(i);
			char right = s.charAt(n - 1 - i);
			
			char current;
			if (left != '?') {
				current = left;
			} else {
				current = right;
			}
			
			if (current == '?') {
				continue;
			}
			
			if (prev != '?') {
				sum += Math.abs(current - prev);
			}
			
			prev = current;
		}
		
		return 2 * sum;
		
	}
}