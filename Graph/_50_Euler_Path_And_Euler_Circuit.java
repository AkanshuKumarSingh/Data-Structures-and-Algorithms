package Graph;

import java.util.ArrayList;

public class _50_Euler_Path_And_Euler_Circuit {

    public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int count = 0;
        int n = adj.size();
        int cntArr[] = new int[adj.size()];
        for(ArrayList<Integer> edge: adj){
            for(int v: edge){
                cntArr[v]++;
            }
        }
        
        for(int i=0;i < n;i++){
            if(cntArr[i]%2==1){
                count++;
            }
        }
        
        if(count == 2) return 1;
        else if(count == 0) return 2;
        return 0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
