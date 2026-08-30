class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>(); 
        for(int i=0; i<l.length; i++) {
            int st = l[i], en = r[i];
            for(int j=st; j<=en; j++) {
                list.add(j);
            }
        }
        for(int i=0; i<rank.length; i++) {
            res.add(list.get(rank[i]-1));
        }
        return res;
    }
}