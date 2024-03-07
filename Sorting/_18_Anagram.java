package Sorting;

import java.util.HashMap;

public class _18_Anagram {

    public static boolean isAnagram(String a,String b)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < a.length(); i++){
            char ch = a.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        for(int i = 0 ; i < b.length(); i++){
            char ch = b.charAt(i);
            int cnt = map.getOrDefault(ch, 0);
            if(cnt == 0) return false;
            map.put(ch, cnt-1);
        }
        
        return true;
    }
	
}
