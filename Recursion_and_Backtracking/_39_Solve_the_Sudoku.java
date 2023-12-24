package Recursion_and_Backtracking;

public class _39_Solve_the_Sudoku {

    static boolean isSafe(int grid[][], int i, int j, int no){
        for(int k = 0 ; k < 9; k++){
            if(grid[i][k] == no || grid[k][j] == no){
                return false;
            }
        }
        
        i = i - i%3;
        j = j - j%3;
        for(int k = 0; k < 3; k++){
            for(int l = 0; l < 3; l++){
                if(grid[k+i][l+j] == no){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
       int i = 0, j = 0;
       outer: for(i = 0 ; i < 9; i++){
           for(j = 0 ; j < 9; j++){
               if(grid[i][j] == 0){
                   break outer;
               }
           }
       }
    
        if(i == 9 && j == 9){
            return true;
        }
        
        for(int no = 1; no <= 9; no++){
            if(isSafe(grid, i, j, no)){
                grid[i][j] = no;
                if(SolveSudoku(grid)){
                    return true;
                }
                grid[i][j] = 0;
            }
        }
        return false;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        for(int i = 0 ; i < 9; i++){
            for(int j = 0 ; j < 9 ; j++){
                System.out.print(grid[i][j] + " ");
            }
        }
    }
	
}
