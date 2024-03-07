package test;

import java.util.*;

public class assesment {
	
//	[4:54 PM] Brahadeesh Kishore
//	You are tasked to find the optimal polymer formula. You've a task script which contains polymer template and 
//	insertion rules (puzzle input). Your job is to work out what polymer would result after repeating the insertion 
//	process.
//	 
//	For example:
//	===============================
//	NNCB -> polymer template
//	 
//	CH -> B -> insertion rules
//	NN -> C
//	NC -> B
//	CB -> H
//	NH -> C
//	===============================
//	 
//	A rule like AB -> C means that when elements A and B are immediately adjacent, element C should be inserted 
//	between them. These insertions all happen simultaneously.
//	 
//	- The first pair (NN) matches the rule NN -> C, so element C is inserted between the first N and the second N.
//	- The second pair (NC) matches the rule NC -> B, so element B is inserted between the N and the C.
//	- The third pair (CB) matches the rule CB -> H, so element H is inserted between the C and the B.
//	 
//	Template:     NNCB
//	After step 1: NCNBCHB
//	After step 2: NBCCNBBBCBHCB
//	After step 3: NBBBCNCCNBBNBNBBCHBHHBCHB
//	After step 4: NBBNBNBBCCNBCNCCNBBNBBNBBBNBBNBBCBHCBHHNHCBBCBHCB
//	 
//	Output: What do you get if you take the quantity of the most common element and subtract the quantity of the 
//	least common element?
//	 
//	Example: Taking the quantity of the most common element (B, 23) and subtracting the quantity of the least 
//	common element (H, 5) produces 23 - 5 = 18.
//	 
//	*****
//	Testing Input
//	===============================
//	NNCB
//	 
//	CH -> B
//	HH -> N
//	CB -> H
//	NH -> C
//	HB -> C
//	HC -> B
//	HN -> C
//	NN -> C
//	BH -> H
//	NC -> B
//	NB -> B
//	BN -> B
//	BB -> N
//	BC -> B
//	CC -> N
//	CN -> C
		
	static String ans;
	
	public static void findInsertion(String str, HashMap<String, String> map, int idx, String currAns) {
		if(idx >= str.length()) {
			ans = currAns;
			return;
		}
		String subStr = str.substring(idx-1, idx+1);
		if(map.containsKey(subStr)) {
			findInsertion(str, map, idx+1, currAns+str.charAt(idx-1)+map.get(subStr)+str.charAt(idx));
		}else {
			findInsertion(str, map, idx+1, currAns+subStr);
		}
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
		while(n-- > 0) {
			findInsertion(str, map, 1, "");
			str = ans;
			System.out.println(str);
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
