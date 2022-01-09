class Solution {
    public int climbStairs(int n) {
       return solve(0, n, new HashMap<Integer, Integer>());
    }
    
    public int solve(int currentStair, int targetStair, HashMap<Integer, Integer> memo){
        //Reach Target stair
        if(currentStair == targetStair){
            return 1;
        }
        //Not possible to reach target stair because currentStair > taget Stair
        
        //In Recursive tree , we can see that we are solving same problems multiple times
        //So this becomes Dp
        //We store problem solution in Map and Return if encounter same problem, i.e. currentStair
        int currentKey = currentStair;
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        
        if(currentStair > targetStair){
            return 0;
        }
        
        int oneStep = solve(currentStair + 1, targetStair, memo);
        int twoStep = solve(currentStair + 2, targetStair, memo);
        
        memo.put(currentKey, oneStep + twoStep);
        
        return oneStep + twoStep;
    }
}