class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer, Integer> mem = new HashMap<>();
        int startWithZero = minCost(cost, 0, mem);
        // int startWithOne = minCost(cost, 1, new HashMap<Integer, Integer>());
        int startWithOne = mem.get(1);
        return Math.min(startWithZero, startWithOne);
    }
    
    public int minCost(int[] cost,int currentIndex, HashMap<Integer, Integer> memo){
        if(currentIndex == cost.length){
            return 0;
        }
        if(currentIndex > cost.length){
            return 1000;
        }
        
        int currentKey = currentIndex;
        
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        
        int oneStep = cost[currentIndex] + minCost(cost, currentIndex + 1, memo);
        int twoStep = cost[currentIndex] + minCost(cost, currentIndex + 2, memo);
        
        memo.put(currentKey,Math.min(oneStep, twoStep));
        
        return memo.get(currentKey);
    }
}