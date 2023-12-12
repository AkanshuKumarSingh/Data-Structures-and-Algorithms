package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class _2_DFS {

	//	GFG
    public void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean isVisited[], ArrayList<Integer> ans){
        isVisited[v] = true;
        for(int i: adj.get(v)){
            if(!isVisited[i]){
                ans.add(i);
                dfs(i, adj, isVisited, ans);
            }
        }
        
    }
    
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraphRecursive(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        ArrayList<Integer> ans  = new ArrayList<>();
        boolean isVisited[] = new boolean[V];
        ans.add(0);
        dfs(0, adj, isVisited, ans);
        return ans;
    }

	
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraphIterative(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        ArrayList<Integer> ans  = new ArrayList<>();
        boolean isVisited[] = new boolean[V];

        while(!st.isEmpty()){
            int v = st.pop();
            
            if(!isVisited[v]){
                ans.add(v);
                isVisited[v] = true;

                ArrayList<Integer> curr = adj.get(v);
                for(int i= curr.size()-1; i >= 0; i--){
                    if(!isVisited[curr.get(i)]){
                        st.push(curr.get(i));
                    }
                }
            }
        }
        return ans;
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
