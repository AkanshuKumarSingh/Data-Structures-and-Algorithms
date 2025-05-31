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

//    def isAnagram(a: str, b: str) -> bool:
//        if len(a) != len(b):
//            return False
//
//        char_count = {}
//
//        for ch in a:
//            char_count[ch] = char_count.get(ch, 0) + 1
//
//        for ch in b:
//            if ch not in char_count or char_count[ch] == 0:
//                return False
//            char_count[ch] -= 1
//
//        return True

    
}
