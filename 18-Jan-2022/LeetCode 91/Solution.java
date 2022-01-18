class Solution {
    static HashSet<String> memo = new HashSet<>();
    static{
        for(int i=0; i<27; i++){
            memo.add(String.valueOf(i));
        }
    }
    
    public int numDecodings(String s) {
       return decodeWays(0, s, new HashMap<Integer, Integer>());
    }
    
    public int decodeWays(int currentIndex,String s, HashMap<Integer, Integer> memo2){
        if(currentIndex == s.length()){
            return 1;
        }
        if(currentIndex > s.length() || s.charAt(currentIndex) == '0'){
            return 0;
        }
        
        int currentKey = currentIndex;
        
        if(memo2.containsKey(currentKey)){
            return memo2.get(currentKey);
        }
        
        int oneIndex = decodeWays(currentIndex + 1 , s, memo2);
        int twoIndex = 0;
        if(currentIndex+1 < s.length()  && memo.contains(s.substring(currentIndex, currentIndex+2))){
            twoIndex = decodeWays(currentIndex + 2, s, memo2);
        }
        
        memo2.put(currentKey,oneIndex + twoIndex);
        return memo2.get(currentKey);
    }
}