package Hashing;

import java.util.HashMap;

public class _26_Smallest_distinct_window {

    public int findSubString( String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < str.length(); i++){
            map.put(str.charAt(i), 0);
        }
        
        int n = map.size();
        map.clear();
        int i = 0, j = 0, ans = 10000;
        while(i < str.length()){
            char ch = str.charAt(i);
            i++;
            map.put(ch, map.getOrDefault(ch, 0)+1);
            if(map.size() == n){
                while(j < i){
                    ans = Math.min(ans, i-j);
                    int freq = map.get(str.charAt(j));
                    j++;
                    if(freq == 1){
                        map.remove(str.charAt(j-1));
                        break;
                    }else{
                        map.put(str.charAt(j-1), freq-1);
                    }
                }
            }
        }
        
        return ans;
    }
	
}
