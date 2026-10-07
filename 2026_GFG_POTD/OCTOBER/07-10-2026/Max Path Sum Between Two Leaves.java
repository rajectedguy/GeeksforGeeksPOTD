class Solution {
    int maxSum;
    public int solve(Node root){
        if(root == null){
            return 0;
        }
        int leftMax = solve(root.left);
        int rightMax = solve(root.right);
        if(root.left == null && root.right == null){
            return root.data;
        }else if(root.left == null && root.right != null){
            return root.data + rightMax;
        }else if(root.right == null && root.left != null){
            return root.data + leftMax;
        }else{
            maxSum = Math.max(maxSum , root.data+leftMax+rightMax);
            return Math.max(root.data+leftMax , root.data+rightMax);
        }
    }
    public int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }
}