package Array2D;

import java.util.Scanner;

public class Ring_Rotate {
//	You are given a n*m matrix where n are the number of rows and m are the number of columns. You are also given n*m numbers representing the elements of the matrix.
//	You will be given a ring number 's' representing the ring of the matrix. For details, refer to image.

	public static Scanner scan = new Scanner(System.in);

	public static void input(int matrix[][]) {
		int no = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = no++;
			}
		}
	}

	public static void display(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[] makeOneDArray(int arr[][], int s) {
		int minRow = s - 1;
		int minCol = s - 1;
		int maxRow = arr.length - s;
		int maxCol = arr[0].length - s;

		int size = 2 * (maxRow - minRow + maxCol - minCol);
		System.out.println("Size: "+ size);
		int oneD[] = new int[size];
		int index = 0;

		for (int i = minRow; i <= maxRow; i++) {
			oneD[index++] = arr[i][minCol];
		}
		minCol++;

		for (int i = minCol; i <= maxCol; i++) {
			oneD[index++] = arr[maxRow][i];
		}
		maxRow--;

		for (int i = maxRow; i >= minRow; i--) {
			oneD[index++] = arr[i][maxCol];
		}
		maxCol--;

		for (int i = maxCol; i >= minCol; i--) {
			oneD[index++] = arr[minRow][i];
		}
		minRow++;
		
		return oneD;
	}

	public static void reverse(int oneD[], int start, int end) {
		
		while(start < end) {
			int t = oneD[start];
			oneD[start] = oneD[end];
			oneD[end] = t;
			start++;
			end--;
		}
		
	}
	
	public static void rotateIt(int oneD[], int r) {
		int n = oneD.length;
		r = r % oneD.length;
		if (r < 0) {
			r = r + oneD.length;
		}
		
		reverse(oneD,0,n-1);
		reverse(oneD,0,r-1);
		reverse(oneD,r,n-1);
		
	}

	public static void insertItBack(int arr[][], int oneD[], int s) {
		int minRow = s-1;
		int minCol = s-1;
		int maxRow = arr.length-s;
		int maxCol = arr[0].length-s;
		
		int index = 0;
		
		for(int i = minRow; i <= maxRow; i++) {
			arr[i][minCol] = oneD[index++];
		}
		minCol++;
		
		for(int i = minCol; i <= maxCol; i++) {
			arr[maxRow][i] = oneD[index++];
		}
		maxRow--;
		
		for(int i = maxRow; i >= minRow; i--) {
			arr[i][maxCol] = oneD[index++];
		}
		maxCol--;
		
		for(int i = maxCol; i >= minCol; i--) {
			arr[minRow][i] = oneD[index++];
		}
		minRow++;
		
	}
	
	public static void shellRotate(int arr[][], int r, int s) {

		int oneD[] = makeOneDArray(arr, s);
		for(int i: oneD) {
			System.out.print(i + " ");
		}
		System.out.println();
		rotateIt(oneD, r);
		for(int i: oneD) {
			System.out.print(i + " ");
		}
		System.out.println();
		insertItBack(arr, oneD, s);
	}

	public static void main(String[] args) {
		int n = scan.nextInt();
		int m = scan.nextInt();
		int matrix[][] = new int[n][m];
		input(matrix);
		int s = scan.nextInt();
		int r = scan.nextInt();
		display(matrix);
		System.out.println();
		
		shellRotate(matrix, r, s);

		display(matrix);

	}

}

//import java.io.*;
//import java.util.*;
//
//public class Main {
//    
//    public static Scanner scn = new Scanner(System.in);
//    
//    public static void takeInput(int[][] arr) {
//        for(int i = 0; i < arr.length; i++) {
//            for(int j = 0; j < arr[0].length; j++) {
//                arr[i][j] = scn.nextInt();
//            }
//        }
//    }
//    
//    public static int[] getOneDArray(int[][] arr, int s) {
//        
//        int minr = s - 1;
//        int minc = s - 1;
//        int maxr = arr.length - s;
//        int maxc = arr[0].length - s;
//        
//        // lw + bw + rw + tw -4
//        int sz = 2 * (maxr - minr + maxc - minc);
//        
//        int[] oneD = new int[sz];
//        int indx = 0;
//        
//        // left wall
//        for(int i = minr; i <= maxr; i++) {
//            oneD[indx] = arr[i][minc];
//            indx++;
//        }
//        minc++;
//        
//        // bottom wall
//        for(int j = minc; j <= maxc; j++) {
//            oneD[indx] = arr[maxr][j];
//            indx++;
//        }
//        maxr--;
//        
//        // right wall
//        for(int i = maxr; i >= minr; i--) {
//            oneD[indx] = arr[i][maxc];
//            indx++;
//        }
//        maxc--;
//        
//        // top wall
//        for(int j = maxc; j >= minc; j--) {
//            oneD[indx] = arr[minr][j];
//            indx++;
//        }
//        minr++;
//        
//        return oneD;
//    }
//    
//    public static void reverse(int[] oneD, int left, int right) {
//        while(left < right) {
//            int temp = oneD[left];
//            oneD[left] = oneD[right];
//            oneD[right] = temp;
//            
//            left++;
//            right--;
//        }
//    }
//    
//    public static void rotateArray(int[] oneD, int r) {
//        r = r % oneD.length;
//        if(r < 0) {
//            r = r + oneD.length;
//        }
//        
//        int n = oneD.length;
//        
//        reverse(oneD, 0, n - 1 - r);
//        reverse(oneD, n - r, n - 1);
//        reverse(oneD, 0, n - 1);
//    }
//    
//    public static void setOneD(int[][] arr, int[] oneD, int s) {
//        int minr = s - 1;
//        int minc = s - 1;
//        int maxr = arr.length - s;
//        int maxc = arr[0].length - s;
//        
//        int indx = 0;
//        
//        // left wall
//        for(int i = minr; i <= maxr; i++) {
//            arr[i][minc] = oneD[indx];
//            indx++;
//        }
//        minc++;
//        
//        // bottom wall
//        for(int j = minc; j <= maxc; j++) {
//            arr[maxr][j] = oneD[indx];
//            indx++;
//        }
//        maxr--;
//        
//        // right wall
//        for(int i = maxr; i >= minr; i--) {
//            arr[i][maxc] = oneD[indx];
//            indx++;
//        }
//        maxc--;
//        
//        // top wall
//        for(int j = maxc; j >= minc; j--) {
//            arr[minr][j] = oneD[indx];
//            indx++;
//        }
//        minr++;
//    }
//    
//    public static void shellRotate(int[][] arr, int s, int r) {
//        // get one D Array from Sth shell of matrix i.e. arr 
//        int[] oneD = getOneDArray(arr, s);
//        // rotate that oneD array
//        rotateArray(oneD, r);
//        // set it again in Sth shell of arr
//        setOneD(arr, oneD, s);
//    }
//
//    public static void main(String[] args) throws Exception {
//        // write your code here
//        int n = scn.nextInt();
//        int m = scn.nextInt();
//        
//        int[][] arr = new int[n][m];
//        
//        takeInput(arr); // fill array from user
//        int s = scn.nextInt(); // for shell
//        int r = scn.nextInt(); // for rotation
//        
//        shellRotate(arr, s, r);
//        
//        display(arr);
//    }
//
//    public static void display(int[][] arr){
//        for(int i = 0; i < arr.length; i++){
//            for(int j = 0; j < arr[0].length; j++){
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//}
