class pair
{
    Node node;
    int length;
    pair(Node node,int length)
    {
        this.node=node;
        this.length=length;
    }
}
class Solution {
    public int longestConsecutive(Node root) {
        if(root==null)
        {
            return -1;
        }
        if(root.left==null && root.right==null)
        {
            return 1;
        }
        int result=Integer.MIN_VALUE;
        Stack<pair>st=new Stack<>();
        int len=0;
        st.push(new pair(root,1));
        while(!st.isEmpty())
        {
            pair pairR=st.pop();
            Node node=pairR.node;
            len=pairR.length;
            result=Math.max(result,len);
            if(node.left!=null && node.left.data==((node.data)+1))
            {
                st.push(new pair(node.left,len+1));
            }
            else if(node.left!=null && node.left.data!=((node.data)+1))
            {
                st.push(new pair(node.left,1));
            }
            if(node.right!=null && node.right.data==((node.data)+1))
            {
                st.push(new pair(node.right,len+1));
            }
            if(node.right!=null && node.right.data!=((node.data)+1))
            {
                st.push(new pair(node.right,1));
            }
        }
        if(result==1)
        {
            return -1;
        }
        return result;
    }
}