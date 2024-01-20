package Hashing;

import java.util.*;

public class _35_Second_most_repeated_string_in_sequence {

    static class Pair implements Comparable<Pair>{
        String str;
        int freq;
        Pair(String str, int freq){
            this.str = str;
            this.freq = freq;
        }
        
        public int compareTo(Pair obj){
            return obj.freq - this.freq;
        }
        
    }
    
    String secFrequent(String arr[], int N)
    {
        HashMap<String, Pair> map = new HashMap<>();
        ArrayList<Pair> list = new ArrayList<>();
        for(String st : arr){
            if(!map.containsKey(st)){
                Pair p = new Pair(st, 1);
                map.put(st, p);
                list.add(p);
            }else{
                map.get(st).freq++;
            }
        }
        
        Collections.sort(list);
        return list.get(1).str;
        
    }
	
}
