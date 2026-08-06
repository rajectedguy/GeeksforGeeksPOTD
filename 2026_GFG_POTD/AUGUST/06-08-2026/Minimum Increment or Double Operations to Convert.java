class Solution {
    public int countMinOperations(int[] arr) {
        int totalIncrements = 0;
        int maxDoubles = 0;
        for (int num : arr) {
            int currentDoubles = 0;
            while (num > 0) {
                if (num % 2 == 1) {
                    totalIncrements++;
                    num--;
                } else {
                    num /= 2;
                    currentDoubles++;
                }
            }
            maxDoubles = Math.max(maxDoubles, currentDoubles);
        }
        return totalIncrements + maxDoubles;
    }
}