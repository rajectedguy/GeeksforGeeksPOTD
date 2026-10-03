class Solution {
	public ArrayList<ArrayList<Integer>> formCoils(int n) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int nn = 4 * n;
		ArrayList<Integer> first = new ArrayList<>();
		int top = 0;
		int bottom = nn - 1;
		int right = nn - 2;
		int left = 0;
		while (top <= bottom && left <= right) {
			for (int i = top; i <= bottom; i++) {
				first.add(((4*n*i) + left + 1));
			}
			left++;
			for (int i = left; i <= right; i++) {
				first.add(((4*n*bottom) + i+1));
			}
			bottom--;
			top++;
			left++;
			for (int i = bottom; i >= top; i--) {
				first.add(((4*n*i) + right + 1));
			}
			bottom--;
			right--;
			for (int i = right; i >= left; i--) {
				first.add(((4*n*top) + i+1));
			}
			top++;
			right--;
		}
		result.add(first);
		ArrayList<Integer> second = new ArrayList<>();
		top = 0;
		bottom = nn - 1;
		right = nn - 1;
		left = 1;
		while (top <= bottom && left <= right) {
			for (int i = bottom; i >= top; i--) {
				second.add(((4*n*i) + right + 1));
			}
			right--;
			for (int i = right; i >= left; i--) {
				second.add(((4*n*top) + i+1));
			}
			top++;
			bottom--;
			right--;
			for (int i = top; i <= bottom; i++) {
				second.add(((4*n*i) + left + 1));
			}
			top++;
			left++; ;
			for (int i = left; i <= right; i++) {
				second.add(((4*n*bottom) + i+1));
			}
			bottom--;
			left++;
			
		}
		result.add(second);
		return result;
	}
}