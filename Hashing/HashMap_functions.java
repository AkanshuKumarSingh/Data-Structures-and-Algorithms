package Hashing;

import java.util.HashMap;

public class HashMap_functions {

	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<>();
		map.put("India", 120);
		map.put("UK", 90);
		map.put("Pak", 70);
		
		System.out.println(map);
		
		System.out.println(map.remove("Pak"));
		System.out.println(map.remove("USA"));
		
		System.out.println(map);
		
		System.out.println(map.containsKey("India"));
		System.out.println(map.containsKey("Pak"));
		
		System.out.println(map.get("UK"));
		System.out.println(map.get("China"));
		
		System.out.println(map);
		
		System.out.println(map.keySet());
		
	}

}
