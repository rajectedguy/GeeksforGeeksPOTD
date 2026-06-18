class Pair{
    int first;
    int last;
    Pair(int first,int last)
    {
        this.first=first;
        this.last=last;
    }
}
class Solution {
    public int findCoverage(int[][] matrix) {
        // code here
        int n=matrix.length;
        int m=matrix[0].length;
        Map<Integer,Pair>row=new HashMap<>();
        Map<Integer,Pair>col=new HashMap<>();
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==1)
                {
                    if(!row.containsKey(i)) row.put(i,new Pair(j,j));
                    else row.get(i).last=j;
                    
                    if(!col.containsKey(j)) col.put(j,new Pair(i,i));
                    else col.get(j).last=i;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    if(row.containsKey(i)&& row.get(i).first<j)ans++;
                    if(row.containsKey(i)&& row.get(i).last>j)ans++;
                    if(col.containsKey(j)&& col.get(j).first<i)ans++;
                    if(col.containsKey(j)&& col.get(j).last>i)ans++;
                }
            }
        }
        return ans;
        
    }
}