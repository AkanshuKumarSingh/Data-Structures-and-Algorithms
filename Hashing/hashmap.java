package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class hashmap {

	private class Node {
		String key;
		int value;

		public Node(String key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private LinkedList<Node>[] bucket = null;
	private int size = 0;

	public void initBucket(int cap) {
		bucket = new LinkedList[cap];

		for (int i = 0; i < cap; i++) {
			bucket[i] = new LinkedList<>();
		}

		size = 0;
	}

	public hashmap() {
		int cap = 4;
		initBucket(cap);
	}

	private int hashFunction(String key) {
		int bi = Math.abs(key.hashCode()) % bucket.length;
		return bi;
	}

	private int searchWithinBucket(String key, int bi) {
		int di = -1;
//		Complexity -> O(n^2) : where n is the no of nodes in given linkedList ( bucket[bi] )
//		for(int i = 0; i < bucket[bi].size(); i++) {
//			Node n = bucket[bi].get(i);
//			
//			if(n.key.equals(key)) {
//				di = i;
//				break;
//			}
//		}

//		Complexity -> O(n) for each working with iterator
		for (Node n : bucket[bi]) {
			di++;
			if (n.key.equals(key)) {
				return di;
			}
		}

		return -1;
	}

	public void rehash() {
		LinkedList<Node> ob[] = bucket;
		initBucket(bucket.length * 2);
		for (int i = 0; i < ob.length; i++) {
			for (Node n : ob[i]) {
				put(n.key, n.value);
			}
		}
	}

	public void put(String key, int value) {
		int bi = hashFunction(key); // finding the bucket no

		int di = searchWithinBucket(key, bi); // finding the index in bucket

		if (di == -1) {
			// insert
			size++;
			bucket[bi].addLast(new Node(key, value));
		} else {
			// update
			bucket[bi].get(di).value = value;
		}

		double lambda = size * 1.0 / bucket.length;
		if (lambda > 2.0) {
			rehash();
		}

	}

	public int remove(String key) {
		int bi = hashFunction(key);
		
		int di = searchWithinBucket(key,bi);
		
		if(di == -1) {
			//absent
			return -1;
		}else {
			//present
			size--;
			return bucket[bi].remove(di).value;
		}
	}
	
	public int get(String key) {
		int bi = hashFunction(key);

		int di = searchWithinBucket(key, bi);

		if (di == -1) {
			// absent
			return -1;
		} else {
			// present
			return bucket[bi].get(di).value;
		}
	}

	public boolean containsKey(String key) {
		int bi = hashFunction(key);

		int di = searchWithinBucket(key, bi);

		if (di == -1) {
			// absent
			return false;
		} else {
			// present
			return true;
		}

	}

	public ArrayList<String> keySet() {
		ArrayList<String> keys = new ArrayList<>();
		for (int i = 0; i < bucket.length; i++) {
			for (Node n : bucket[i]) {
				keys.add(n.key);
			}
		}
		return keys;
	}

	public void display() {
		for (int bi = 0; bi < bucket.length; bi++) {
			for (Node n : bucket[bi]) {
				System.out.print(n.key + " = " + n.value + ", ");
			}
		}
		System.out.println();
	}

	public void bucketWiseDisplay() {
		for (int bi = 0; bi < bucket.length; bi++) {
			System.out.print("[" + bi + "] -> ");
			for (Node n : bucket[bi]) {
				System.out.print(n.key + " = " + n.value + ", ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		hashmap map = new hashmap();
		map.put("India", 100);
		map.put("China", 90);
		map.put("Pak", 70);
		map.put("USA", 95);
		map.put("UK", 92);
//		System.out.println(map.get("China"));
		map.put("india", 100);
		map.put("china", 90);
		map.put("pak", 70);
		map.put("usa", 95);
		map.put("uk", 92);
		map.put("canada", 98);
		map.bucketWiseDisplay();
		
	}

}

//[0] -> 
//[1] -> 
//[2] -> Pak = 70, UK = 92, pak = 70, uk = 92, 
//[3] -> India = 100, China = 90, USA = 95, india = 100, china = 90, usa = 95, 
