package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class _1_Generic_HashMap<K,V> {

	private class Node {
		K key;
		V value;

		public Node(K key, V value) {
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

	public _1_Generic_HashMap() {
		int cap = 4;
		initBucket(cap);
	}

	private int hashFunction(K key) {
		int bi = Math.abs(key.hashCode()) % bucket.length;
		return bi;
	}

	private int searchWithinBucket(K key, int bi) {
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

	public void put(K key, V value) {
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

	public V remove(K key) {
		int bi = hashFunction(key);

		int di = searchWithinBucket(key, bi);

		if (di == -1) {
			// absent
			return null;
		} else {
			// present
			size--;
			return bucket[bi].remove(di).value;
		}
	}

	public V get(K key) {
		int bi = hashFunction(key);

		int di = searchWithinBucket(key, bi);

		if (di == -1) {
			// absent
			return null;
		} else {
			// present
			return bucket[bi].get(di).value;
		}
	}

	public boolean containsKey(K key) {
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

	public ArrayList<K> keySet() {
		ArrayList<K> keys = new ArrayList<>();
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

	public int size() {
		return size;
	}
	
	public static void main(String[] args) {
		_1_Generic_HashMap<String,Integer> map = new _1_Generic_HashMap<>();
		map.put("India", 100);
		map.put("China", 90);
		map.put("Pak", 70);
		map.put("USA", 95);
		map.put("UK", 92);
		System.out.println(map.get("China"));
		System.out.println(map.size());
		map.put("india", 100);
		map.put("china", 90);
		map.put("pak", 70);
		map.put("usa", 95);
		map.put("uk", 92);
		map.put("canada", 98);
		map.bucketWiseDisplay();

	}

}
