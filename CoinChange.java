// Time Complexity :
// Space Complexity :O(N)- > where n is number 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(coins==null || coins.length==0)
            return 0;
    
        int dp[][]=new int[coins.length+1][amount+1];
        
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=amount+1;
        }
        
        for(int i =1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(coins[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
            }
        }
        int result =dp[coins.length][amount];
        if(result>=amount+1)
            return -1;
            
        return result;
    }
    

}