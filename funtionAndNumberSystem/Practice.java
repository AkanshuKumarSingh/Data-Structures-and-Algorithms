package funtionAndNumberSystem;

public class Practice {

	 public static int getSum(int b, int n1, int n2){
		   int power = 1;
	       int carry = 0;
	       int ans = 0;
	       while(n1 > 0 || n2 > 0 || carry != 0){
	           int val1 = n1%10;
	           int val2 = n2%10;
	           n1 = n1/10;
	           n2 = n2/10;
	           int sum = (val1 + val2 + carry);
	           int val = sum%b;
	           carry = sum/b;
	           ans +=(power*val);
	           power *= 10;
	       }
	       return ans;
	   }
	
	public static void main(String[] args) {

		int base = 4;
		int n1 = 56;
		int n2 = 65;
		int ans = 0;
		int p = 1;
		System.out.println((float)(n2/base));
		
		while(n1 != 0) {
			int t = n2;
			int no = n1%10;
			n1 = n1/10;
			int ca = 0;
			int carry = 0;
			int power = 1;
			while(n2 != 0 || carry != 0) {
				int val = n2%10;
				n2 = n2/10;
				val = val*no + carry;
				carry = val/base;
				val = val%base;
				ca += (power*val);
				power *= 10;
			}
			n2 = t;
			ans = getSum(base,ans,ca*p);
			p *= 10;
		}
		System.out.println(ans);
	}

}
