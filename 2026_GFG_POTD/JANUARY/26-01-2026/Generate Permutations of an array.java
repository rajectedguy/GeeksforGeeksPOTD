class Solution {
    static void dfs(int i, int[] arr, ArrayList<ArrayList<Integer>> res) {
        if (i == arr.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int x : arr) temp.add(x);
            res.add(temp);
            return;
        }
        for (int j = i; j < arr.length; j++) {
            int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
            dfs(i + 1, arr, res);
            t = arr[i]; arr[i] = arr[j]; arr[j] = t;
        }
    }

    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        dfs(0, arr, res);
        return res;
    }
}