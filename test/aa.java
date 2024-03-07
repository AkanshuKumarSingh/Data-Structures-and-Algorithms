package test;

import java.util.HashMap;
import java.util.Map;

public class aa {

static String ans;
	
	public static void findInsertion(HashMap<Integer, Character> strMap, HashMap<String, String> map, 
			int idx, HashMap<Character, Integer> freqMap) {
//		if(!strMap.containsKey(idx)) {
//			return;
//		}
//		String subStr = "" + strMap.get(idx-1) + strMap.get(idx);
//		if(map.containsKey(subStr)) {
//			freqMap.put(map.get(subStr), freqMap.getOrDefault(subStr, 0)+1);
//			findInsertion(strMap, map, idx+1, freqMap);
//		}else {
//			findInsertion(str, map, idx+1, freqMap);
//		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "NCNCB";
		ans = "";
		int n = 10;
		HashMap<String, String> map = new HashMap<>();
		map.put("CH", "B");
		map.put("HH", "N");
		map.put("CB", "H");
		map.put("NH", "C");
		map.put("HB", "C");
		map.put("HC", "B");
		map.put("HN", "C");
		map.put("NN", "C");
		map.put("BH", "H");
		map.put("NC", "B");
		map.put("NB", "B");
		map.put("BN", "B");
		map.put("BB", "N");
		map.put("BC", "B");
		map.put("CC", "N");
		map.put("CN", "C");

		
		HashMap<Character, Integer> freqMap = new HashMap<>();
		HashMap<Integer, Character> strMap = new HashMap<>();
		while(n-- > 0) {
			findInsertion(strMap, map, 1, freqMap);
		}
		
		for(int i = 0 ; i < str.length(); i++) {
			char ch = str.charAt(i);
			freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
		}
		System.out.println(freqMap);
		
		
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for(Map.Entry<Character, Integer> e: freqMap.entrySet()) {
			max = Math.max(max, e.getValue());
			min = Math.min(min, e.getValue());
		}
		
		System.out.println(max-min);
		
	}

}
