package Graph;

public class _33_Floyd_Warshall {

    public void shortest_distance(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = Integer.MAX_VALUE/100;
                }
            }
        }
        
        
        for(int via = 0; via < matrix.length; via++){
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == Integer.MAX_VALUE/100){
                    matrix[i][j] = -1;
                }
            }
        }

    }

	
}
