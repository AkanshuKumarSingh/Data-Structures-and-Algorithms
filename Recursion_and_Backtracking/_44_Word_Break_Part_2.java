package Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _44_Word_Break_Part_2 {
	
    static void makeWords(HashSet<String> dict, String s, String ans, int idx, List<String> ansList){
    	if(idx == s.length()){
            ansList.add(ans.substring(0, ans.length()-1));
            return;
        }
        
        for(int i = idx+1; i <= s.length(); i++){
            String str = s.substring(idx, i);
            if(!dict.contains(str)) continue;
            makeWords(dict, s, ans+str+" ", i, ansList);
        }
        
    }
    
    static List<String> wordBreak(int n, List<String> dict, String s)
    {
        List<String> ansList = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(String str : dict){
            set.add(str);
        }
        makeWords(set, s, "", 0, ansList);
        return ansList;
    }

	public static void main(String[] args) {
		String s = "catsanddog";
		int n = 5; 
		String dict[] = {"cats", "cat", "and", "sand", "dog"};
		List<String> ans = new ArrayList<>();
		for(String str: dict) {
			ans.add(str);
		}
		System.out.println(wordBreak(n, ans, s));
		
	}

}
