class Solution {
    public boolean wifiRange(String s, int x) {
        boolean[] range = new boolean[s.length()];
        int prev = -10000000;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                prev = i;
                range[i] = true;
            }else if(prev+x >= i){
                range[i] = true;
            }
        }
        prev = 10000000;
        for(int i=s.length()-1; i >= 0; i--){
            if(s.charAt(i) == '1'){
                prev = i;
                range[i] = true;
            }else if(prev-x <= i){
                range[i] = true;
            }
        }
        for(boolean cover: range){
            if(!cover) return false;
        }
        return true;
    }
}