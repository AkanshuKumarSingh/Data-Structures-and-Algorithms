package Searching;

import java.util.ArrayList;

public class _4_Common_elements {

    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        int i = 0, j = 0, k = 0, prev = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        while(i < A.length && j < B.length && k < C.length){
            if(A[i] == B[j] && B[j] == C[k] && prev != A[i]){
                list.add(A[i]);
                prev = A[i];
                i++;
                j++;
                k++;
            }else if(A[i] == B[j] && B[j] == C[k]){
                i++;
                j++;
                k++;
            }else if(A[i] < B[j] || A[i] < C[k]){
                i++;
            }else if(B[j] < C[k] || B[j] < A[i]){
                j++;
            }else{
                k++;
            }
        }
        
        return list;
    }
	
}
