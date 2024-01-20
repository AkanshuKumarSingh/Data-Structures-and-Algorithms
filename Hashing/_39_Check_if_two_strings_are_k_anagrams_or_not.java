package Hashing;

import java.util.HashMap;
import java.util.Map;

public class _39_Check_if_two_strings_are_k_anagrams_or_not {

    static boolean areKAnagrams(String s1, String s2, int k) {
        if(s1.length() != s2.length()) return false;
        HashMap<Character, Integer>  map1 = new HashMap<>();
        HashMap<Character, Integer>  map2 = new HashMap<>();

        for(int i = 0 ; i < s1.length() ; i++){
            char ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0)+1);
        }
        for(int i = 0 ; i < s2.length() ; i++){
            char ch = s2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }
        System.out.println(map1);
        System.out.println(map2);
        
        int n1 = 0, n2 = 0;
        for(Map.Entry<Character, Integer> e : map1.entrySet()){
            char key = e.getKey();
            int val1 = e.getValue();
            if(map2.containsKey(key)){
                int val2 = map2.get(key);
                if(val1 == val2){
                    map1.put(key, -1);
                    map2.put(key, -1);
                }else if(val1 > val2){
                    map1.put(key, val1-val2);
                    map2.put(key, -1);
                }else{
                    map1.put(key, -1);
                    map2.put(key, val2-val1);
                }
            }
        }
        
        System.out.println(map1);
        System.out.println(map2);

        for(int i : map1.values()){
            if(i != -1) n1 += i;
        }
        
        for(int i : map2.values()){
            if(i != -1) n2 += i;
        }
        
        return n1 == n2 && n1 <= k;
        
    }

    public static void main(String args[]) {
    	System.out.println("HHM");
    	String s1 = "fodr";
    	String s2 = "gork";
    	int k = 2;
    	System.out.println(areKAnagrams(s1, s2, k));
    	
    }
	
}
