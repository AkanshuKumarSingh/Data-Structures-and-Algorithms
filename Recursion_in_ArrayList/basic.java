package Recursion_in_ArrayList;

import java.util.ArrayList;

public class basic {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println(list);
		
		System.out.println(list.size());
		
		list.add(3,8);
		
		System.out.println(list);
		
		System.out.println(list.get(2));
		
		list.set(1, 11);
		
		System.out.println(list);
		
		System.out.println(list.remove(3));
		
		System.out.println(list);
		
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
		for(int ele : list) {
			System.out.println(ele);
		}
		
		
		System.out.println("-----------String----------");
		
		String s = "Hi";
		
		
		
	}

}
