package Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class prac {

	public static void main(String[] args) {
		ArrayList<Long> list = new ArrayList<>();
		list.add(0, (long)8);
//		list.add(2, (long)8);
		
//		list.add(4, (long)1);
		System.out.println(list);
		
		HashSet<String> set1 = new HashSet<>();
		HashSet<String> set2 = new HashSet<>();
		set1.add("kjk");
		set1.add("utfg6");
		System.out.println(set1);
		ArrayList<String> list1 = new ArrayList<>();
		list1.addAll(set1);
		list1.add("kkk");
		set1.addAll(list1);
		System.out.println(set1);
		System.out.println(list1);
		list1.remove(1);
		System.out.println(list1);		
		list1.add(0, "1st");
		list1.add("last");
		System.out.println(list1);
		ArrayList<String> list2 = new ArrayList<>(list1);
		list1.add("0");
		System.out.println(list2);
		System.out.println(list1);
		
		System.out.println(String.valueOf("" + 17).length());
		
		System.out.println(Integer.BYTES);
		
		ArrayList<Integer> a = new ArrayList<>();
		for(int i : new int[] {5, 6, 6, 10, 3, 4, 6, 6, 4}) {
			a.add(i)
		}
		
		Collections.sort(null);
		Sysout
		
		
	}

}
