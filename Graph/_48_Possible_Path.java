package Graph;

public class _48_Possible_Path {
	
    public int isPossible(int[][] paths)
    {
    	
    	// https://www.geeksforgeeks.org/eulerian-path-and-circuit/
    	
        int n = paths.length;
        for(int i = 0; i < n; i++){
            int degree = 0;
            for(int j = 0 ; j < paths[i].length; j++){
                if(paths[i][j] == 1){
                    degree++;
                }    
            }
            
            if(degree%2 == 1){
                return 0;
            }
            
        }
        return 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
