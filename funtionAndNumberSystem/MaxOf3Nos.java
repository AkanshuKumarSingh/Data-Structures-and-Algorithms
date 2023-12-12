package funtionAndNumberSystem;

public class MaxOf3Nos {

	public static int max(int a, int b, int c) {
		if(a > b && a > c) {
			return a;
		}else if(b > c) {
			return b;
		}else {
			return c;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("HHM");
		System.out.println(max(3, 5, 1));
	}

}
