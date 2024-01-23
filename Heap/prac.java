package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class prac {
	private ArrayList<Integer> data;
	
	prac(){
		data = new ArrayList<>();
	}
	
	prac(int arr[]){
		for(int i : arr) {
			data.add(i);
		}
		for(int i = data.size()-1; i >= 0; i--) {
			downheapify(i);
		}
	}
	
	public void add(int no) {
		data.add(no);
		upheapify(data.size()-1);
	}
	
	public int remove() {
		if(data.size() == 0) {
			System.out.println("Heap Empty!");
			return -1;
		}
		int no = data.get(0);
		swap(0, data.size()-1);
		data.remove(data.size()-1);
		downheapify(0);
		return no;
	}
	
	public int peek() {
		if(data.size() == 0) {
			System.out.println("Heap Empty");
			return -1;
		}
		return data.get(0);
	}
	
	public void swap(int i, int j) {
		int val1 = data.get(i);
		int val2 = data.get(j);
		
		data.set(i, val2);
		data.set(j, val1);
	}
	
	public void upheapify(int index) {
		int parentIndex = (index-1)/2;
		if(parentIndex >=0 && data.get(parentIndex) > data.get(index)) {
			swap(index, parentIndex);
			upheapify(parentIndex);
		}
	}

	public void downheapify(int index) {
		int leftChild = 2*index + 1;
		int rightChild = 2*index + 2;
		int minIndex = index;
		
		if(leftChild < data.size() && data.get(leftChild) < data.get(minIndex)) {
			minIndex = leftChild;
		}
		if(rightChild < data.size() && data.get(rightChild) < data.get(minIndex)) {
			minIndex = rightChild;
		}
		
		if(minIndex != index) {
			swap(index, minIndex);
			downheapify(minIndex);
		}
	}
	
	public int size() {
		return data.size();
	}
	
	public boolean isEmpty() {
		return data.size() == 0;
	}
	
	public void display() {
		System.out.println(data);
	}
	
    static class Node implements Comparable<Node>{
        int data;
        int no;
        Node left;
        Node right;
        Node(int data, int no){
            this.data = data;
            this.left = null;
            this.right = null;
            this.no = no;
        }
        public int compareTo(Node temp){
            if(this.data == temp.data){
                return 1;
            }
            return this.data - temp.data;
        }
    }
	
	public static void main(String[] args) {
		System.out.println("HHM");
		prac minHeap = new prac();
		minHeap.add(5);
		minHeap.add(6);
		minHeap.add(1);
		minHeap.add(10);
		minHeap.display();
		System.out.println(minHeap.peek());
		System.out.println(minHeap.remove());
		System.out.println(minHeap.peek());
		System.out.println(minHeap.size());
		System.out.println(minHeap.isEmpty());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		pq.add(12);
		pq.add(21);
		System.out.println(pq.remove());
		System.out.println(pq.peek());
		pq.offer(1234);
		System.out.println(pq.poll());
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(3, 1));
        q.offer(new Node(3, 2));
        q.offer(new Node(3, 3));
		System.out.println(q.poll().no);
		System.out.println(q.poll().no);

	}

}
