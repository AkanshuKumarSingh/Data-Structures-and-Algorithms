package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class _36_Snakes_and_Ladders {

    //what if we have changed the dice number, or changing the starting index or 
	//changing the ending index so i have covered all possible ways in which this 
	//question can be asked

	//bfs tip:- for better bfs, we can use marking first and then inserting it in 
	//the queue which works faster then removing first and then checking
    public int findAns(int board[][], HashMap<Integer, Integer> map, int n){

        int dice = 6;
        int si = 1;
        int ei = n*n;
        int level = 0;

        //to stop visiting cells again
        boolean [] vis = new boolean [ei+1];
        vis[si]=true;

        
    	//if si==ei just directly return 
        if(si == ei) return 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{si, 0, 0});

        //starting bfs
        while(q.size()!=0){
            int size = q.size();
            while(size-->0){
                int node[] = q.remove();
                int curr = node[0];
                int ladder = node[1];
                int snake = node[2];
                for(int i=1;i<=dice;i++){
                    int move = curr + i; //checking all the steps
                    if(move <= ei){ //valid points
                        if(map.containsKey(move)){ //this means that we have encountered a snake or a ladder
                            int val = map.get(move); 
                            if(val==ei) return level+1;
                            if(!vis[val]){
                                vis[val]=true;
                                //if val>move this means we have a ladder and if less, then it is a snake
                                q.add(val>move? new int [] {val,ladder+1,snake}:new int [] {val,ladder,snake+1});
                            }
                        }
                        else{
                            //if it is not present in map, then it is a normal cell, so just insert it directly
                            if(move==ei) return level+1;
                            if(!vis[move]){
                                vis[move]=true;
                                q.add(new int [] {move,ladder,snake});
                            }
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public int snakesAndLadders(int[][] board) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 1;
        int n = board.length;
        boolean flag = true;
        //traversing the board in the board game fashion and checking if the count that is representing the cell number, if we encounter something other then -1, then it can be a snake or it can be a ladder and mapping that cell index (i.e count to that number)
        for(int i=n-1;i>=0;i--){
            //traversing in the order of the board
            if(flag){
                for(int j=0;j<n;j++){
                    if(board[i][j]!=-1){
                        map.put(count,board[i][j]);   
                    }
                    count++;
                    flag=false;
                }
            }
            else{
                //reversing the direction
                for(int j=n-1;j>=0;j--){
                    if(board[i][j]!=-1){
                        map.put(count,board[i][j]);
                    }
                    flag=true;
                    count++;
                }
            }
        }
        //if snake on destination then just return -1;
        if(board[0][0]!=-1) return -1;
        //we only want the minimum steps, but for more conceptual approach for this question, {minm steps,ladders used, snakes used} 
        return findAns(board, map, n);        
    }
	
}
