package Graph;

public class _34_Travelling_Salesman_Problem {

    int dp[][];
    int visitedAll;

    public int findCost(int src, int cost[][], int mask){
        if(mask == visitedAll){
            return cost[src][0];
        }else if(dp[src][mask] != 0){
            return dp[src][mask];
        }
        
        int currCost = Integer.MAX_VALUE;
        for(int neigh = 0; neigh < cost[src].length; neigh++){
            if((mask&(1<<neigh)) == 0 && cost[src][neigh] > 0){
                int newCost = findCost(neigh, cost, mask|(1<<neigh));
                if(newCost != Integer.MAX_VALUE){
                    currCost = Math.min(currCost, newCost + cost[src][neigh]);
                }
            }
        }
        dp[src][mask] = currCost;
        return currCost;
    }
    
    public int total_cost(int[][] cost)
    {
        int n = cost.length;
        dp = new int[n][(1<<n)-1];
        visitedAll = (1<<n) - 1;
        int ans = findCost(0, cost, 1);
        return ans != Integer.MAX_VALUE ? ans : 0;
    }

	
}
