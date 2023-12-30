package Recursion_and_Backtracking;

import java.util.ArrayList;

public class _46_Permutation_with_Spaces {

    void permutation(String str, int idx, ArrayList<String> list, String ans){
    	if(idx == str.length()-1){
            list.add(ans + str.charAt(idx));
            return;
        }
        
        permutation(str, idx+1, list, ans + str.charAt(idx) + " ");
        permutation(str, idx+1, list, ans + str.charAt(idx));
    }
    
    ArrayList<String> permutation(String S){
        ArrayList<String> list = new ArrayList<>();
        permutation(S, 0, list, "");
        return list;
    }
    
    public static void main(String args[]) {
    	System.out.println(new _46_Permutation_with_Spaces().permutation("ABC"));
    }
	
}
