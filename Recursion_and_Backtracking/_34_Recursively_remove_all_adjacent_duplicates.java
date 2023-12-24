package Recursion_and_Backtracking;

public class _34_Recursively_remove_all_adjacent_duplicates {

    String rremove(String s) {
        return getStr(s, '@', 0);
    }
    
    String getStr(String str, char prevChar, int idx){
        if(str.length() == idx){
            return "";
        }
        
        char currCh = str.charAt(idx);
        if(currCh == prevChar){
        	System.out.println(idx + "1" + currCh);
            return getStr(str, currCh, idx+1);
        }else if(str.length() > idx+1 && currCh == str.charAt(idx+1)){
        	System.out.println(idx + "2" + currCh);
        	return getStr(str, currCh, idx+1);
        }else{
        	System.out.println(idx + "3" + currCh);
            return "" + str.charAt(idx) + getStr(str, currCh, idx+1);
        }
    }
    
    public static void main(String args[]) {
    	String S = "geeksforgeek";
    	System.out.println(new _34_Recursively_remove_all_adjacent_duplicates().rremove(S));

    }
	
}
