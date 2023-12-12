package Queue;

public class queue {

//	https://leetcode.com/problems/design-circular-queue/submissions/

	private int[] data;
	int front = 0;
	int size = 0;

	public queue(int cap) {
		data = new int[cap];
	}

	public void add(int val) {
		if (size == data.length) {
			System.out.println("Queue overflow");
			return;
		}

		int idx = (front + size) % data.length;
		data[idx] = val;
		size++;
	}

	public int remove() {
		if (size == 0) {
			System.out.println("Queue underflow");
			return -1;
		}
		int val = data[front];
		front = (front + 1) % data.length;
		size--;
		return val;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int peek() {
		if (size == 0) {
			System.out.println("Queue underflow");
			return -1;
		}

		return data[front];
	}

	@Override
	public String toString() {
		String str = "[";
		for(int i = 0 ; i < size-1; i++) {
			int idx = (front + i)%data.length;
			str += data[idx] + ", ";
		}
		if(size > 0) {
			int idx = (front + size-1)%data.length;
			str += data[idx] + ", ";
		}
		
		str += "]";
		return str;
	}

	void display() {
		for(int i = front; i < front+size; i++) {
			int idx = i%data.length;
			System.out.print(data[idx] + " ");
		}
	}

}
