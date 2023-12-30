package Recursion_and_Backtracking;

import java.util.ArrayList;

public class _50_Print_all_possible_strings {

    void makeStrings(String str, int idx, String ans, ArrayList<String> list){
        if(idx == str.length()){
            list.add(ans);
            return;
        }
        
        makeStrings(str, idx+1, ans+str.charAt(idx), list);
        
        makeStrings(str, idx+1, ans+" "+str.charAt(idx), list);        
    }
    
    ArrayList<String> spaceString(String str)
    {
        ArrayList<String> list = new ArrayList<>();
        makeStrings(str, 1, ""+str.charAt(0), list);
        return list;
    }
	
}
