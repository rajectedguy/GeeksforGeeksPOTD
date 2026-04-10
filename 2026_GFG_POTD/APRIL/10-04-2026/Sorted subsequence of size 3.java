class Solution {
    public ArrayList<Integer> find3Numbers(int[] arr) {
        // code here
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    if(arr[i]<arr[j] && arr[i]<arr[k] && arr[j]<arr[k] && i<j && j<k && i<k){
                        l.add(arr[i]);
                        l.add(arr[j]);
                        l.add(arr[k]); return l;
                    }
                    
                }
            }
        }
        return l;
    }
}