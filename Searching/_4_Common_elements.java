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

//    def common_elements(A, B, C, n1, n2, n3):
//        i = j = k = 0
//        prev = float('inf')
//        result = []
//
//        while i < n1 and j < n2 and k < n3:
//            if A[i] == B[j] == C[k] and prev != A[i]:
//                result.append(A[i])
//                prev = A[i]
//                i += 1
//                j += 1
//                k += 1
//            elif A[i] == B[j] == C[k]:
//                i += 1
//                j += 1
//                k += 1
//            elif A[i] < B[j] or A[i] < C[k]:
//                i += 1
//            elif B[j] < C[k] or B[j] < A[i]:
//                j += 1
//            else:
//                k += 1
//
//        return result

    
}
