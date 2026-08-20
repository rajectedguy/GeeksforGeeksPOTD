class Solution {
    int res;

    int maxDiff(Node root) {

        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }

    int dfs(Node node) {
        if (node == null) return Integer.MAX_VALUE;

        int l = dfs(node.left);
        int r = dfs(node.right);

        res = Math.max(res, node.data - Math.min(l, r));
        return Math.min(node.data, Math.min(l, r));
    }
}