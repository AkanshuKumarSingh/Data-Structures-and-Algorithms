package Graph;

public class _22_Flood_fill_Algorithm {

    static int rows[] = {-1, 0, 1, 0};
    static int cols[] = {0, 1, 0, -1};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {   
        int currColor = image[sr][sc];
        image[sr][sc] = newColor;
        for(int i = 0 ; i < rows.length; i++){
            int nr = sr + rows[i];
            int nc = sc + cols[i];
            if(nr >= 0 && nc >= 0 && nr < image.length && nc < image[0].length && image[nr][nc] == currColor && 
            		image[nr][nc] != newColor){
            	// This last condition because if both old and new color will be same
            	// then recursion will be infinite next index color will be same 
            	// as current color even if it's colored so last condition
                floodFill(image, nr, nc, newColor);
            }
        }
        return image;
    }

	
	public static void main(String[] args) {
		
	}

}
