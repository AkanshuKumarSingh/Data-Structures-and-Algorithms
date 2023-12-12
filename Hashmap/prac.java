package Hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class prac<K, V> {
	public class Node{
		K key;
		V value;
		Node(K key, V value){
			this.key = key;
			this.value = value;
		}
	}
	
	private LinkedList<Node> buckets[] = null;
	private int size = 0;
	
	public void initBucket(int cap) {
		buckets = new LinkedList[cap];
		for(int i = 0 ; i < cap; i++) {
			buckets[i] = new LinkedList<>();
		}
		size = 0;
	}
	
	prac(){
		int cap = 4;
		initBucket(cap);
	}
	
	public int hashFunction(K key) {
		int bi = Math.abs((key.hashCode()))% buckets.length;
		return bi;
	}
	
	public int findWithinBucket(int bi, K key) {
		LinkedList<Node> list = buckets[bi];
		int d1 = -1;
		for(Node node : list) {
			d1++;
			if(node.key == key) {
				return d1;
			}
		}
		return -1;
	}
	
	public void rehash() {
		LinkedList<Node> prev[] = buckets;
		initBucket(buckets.length * 2);
		for(int i = 0 ; i < prev.length; i++) {
			for(Node n : prev[i]) {
				this.put(n.key, n.value);
			}
		}
	}
	
	public void put(K key, V value) {
		int bi = hashFunction(key);
		int di = findWithinBucket(bi, key);
		LinkedList<Node> list = buckets[bi];
		
		if(di == -1) {
			list.add(new Node(key, value));
			size++;
		}else {
			list.get(di).value = value;
		}
		
		
		if(size*1.0/buckets.length > 2.0) {
			System.out.println("Starting reshash at " + key);
			rehash();
		}
	}
	
	public void remove(K key) {
		int bi = hashFunction(key);
		int di = findWithinBucket(bi, key);
		if(di == -1) {
			System.out.println("data doesn't exists");
		}else {
			Node node = buckets[bi].remove(di);
			System.out.println("data with key: " + node.key + " ,value: " + node.value);
			size--;
		}
	}
	
	public boolean containsKey(K key) {
		int bi = hashFunction(key);
		int di = findWithinBucket(bi, key);
		if(di == -1) {
			return false;
		}else {
			return true;
		}
	}
	
	public ArrayList<K> keySets(){
		ArrayList<K> keys = new ArrayList<>();
		for(LinkedList<Node> list : buckets) {
			for(Node node : list) {
				keys.add(node.key);
			}
		}
		return keys;
	}
	
	public V get(K key) {
		int bi = hashFunction(key);
		int di = findWithinBucket(bi, key);
		if(di == -1) {
			return null;
		}else {
			return buckets[bi].get(di).value;
		}
	}
	
	public void display() {
		for(int i = 0 ; i < buckets.length; i++) {
			System.out.println("At bucket " + (i+1));
			for(Node node : buckets[i]) {
				System.out.println(node.key + " " + node.value);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("HHM");
		prac hm = new prac();
		hm.put("12", "Hi");
		hm.put("02", "Hi");
		hm.put("22", "Hi");
		hm.put("42", "Hi");
		
		hm.display();
		System.out.println(hm.containsKey("01"));
		System.out.println(hm.containsKey("02"));
		System.out.println(hm.keySets());
		hm.remove("02");
		System.out.println(hm.get("02"));
		System.out.println(hm.containsKey("01"));
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("There", 1);
		System.out.println(map);
		System.out.println(map.get("There"));
		System.out.println(map.getOrDefault("There", 9));
		System.out.println(map.containsKey("There"));
		System.out.println();
		
		HashSet<Integer> set = new HashSet<>();	
		set.add(12);
		System.out.println(set);
		System.out.println(set.contains(1));
		System.out.println(set.remove(12));
		
	}
	

}
