class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        // code here
        int ans[] = new int[n];
        int aux[][] = new int[n][2];
        for(int i=0; i<a.length; i++){
            int si = a[i];
            int ei = b[i];
            aux[si][0] += k[i];
            aux[ei][1] += k[i];
        }
        int addValue = 0;
        int max = 0;
        for(int i=0; i<aux.length; i++){
            addValue+=aux[i][0];
            ans[i] = addValue;
            max = Math.max(ans[i], max);
            addValue-=aux[i][1];
        }
        return max;
    }
}