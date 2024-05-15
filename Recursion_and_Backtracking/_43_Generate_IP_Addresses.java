package Recursion_and_Backtracking;

import java.util.ArrayList;

public class _43_Generate_IP_Addresses {

    public ArrayList<String> gen(String str, int n){
        ArrayList<String> ans = new ArrayList<>();
        if(n == 0){
        	if(str.length() > 3) return ans;
            int no = Integer.parseInt(str);
            if(no < 256){
            	if(no == 0 && String.valueOf(no).length() == str.length())
            		ans.add(str);
            	else if(no > 0 && no < 256 && str.charAt(0) != '0')
            		ans.add(str);
            }
            return ans;
        }
        
        int sz = str.length();
        for(int i = 1 ; i < sz && (sz-i)-(n-1) != 0 ; i++){
            String subStr = str.substring(i);
        	if(Integer.parseInt(str.substring(0, i)) >= 256) break;
        	
            ArrayList<String> curr = gen(str.substring(i), n-1);
            for(String s: curr){
                ans.add(str.substring(0, i) + "." + s);
            }
            
            if(str.charAt(0) == '0') break;
        }
        
        return ans;
    }
    
    public ArrayList<String> genIp(String s) {
        return gen(s, 3);
    }
    
    public static void main(String args[]) {
    	System.out.println(Integer.parseInt("0024"));
    	System.out.println(new _43_Generate_IP_Addresses().genIp("3783022527424056"));
    }
	
}
