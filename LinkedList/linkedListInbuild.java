package LinkedList;

import java.util.LinkedList;

public class linkedListInbuild {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.addFirst(2);
		list.addFirst(1);
		System.out.println(list);
		list.addLast(8);
		list.addLast(9);
		list.add(0, 0);
		list.add(5,5);
		list.add(5,5);
		list.add(2,5);
		System.out.println(list);
		System.out.println(list.removeLast());
		System.out.println(list);
		System.out.println(list.removeFirst());
		System.out.println(list);
		System.out.println(list.remove());
		System.out.println(list);
//		System.out.println(list.remove(new Integer(5)));
//		System.out.println(list);
//		list.add(3);
//		System.out.println(list);
	}

}
