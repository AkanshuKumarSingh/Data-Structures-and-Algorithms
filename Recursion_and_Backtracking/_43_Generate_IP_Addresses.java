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
    
    // def gen_ip(s: str) -> list[str]:
    // def gen(str_part: str, n: int) -> list[str]:
    //     ans = []
    //     if n == 0:
    //         if len(str_part) > 3:
    //             return ans
    //         try:
    //             num = int(str_part)
    //         except ValueError:
    //             return ans
            
    //         if num < 256:
    //             if num == 0 and len(str(str_part)) == len(str_part):
    //                 ans.append(str_part)
    //             elif 0 < num < 256 and str_part[0] != '0':
    //                 ans.append(str_part)
    //         return ans
        
    //     sz = len(str_part)
    //     for i in range(1, sz):
    //         if (sz - i) - (n - 1) == 0:
    //             break
            
    //         first_part = str_part[:i]
    //         try:
    //             if int(first_part) >= 256:
    //                 break
    //         except ValueError:
    //             break
            
    //         curr = gen(str_part[i:], n - 1)
    //         for valid_str in curr:
    //             ans.append(first_part + "." + valid_str)
            
    //         if str_part[0] == '0':
    //             break
        
    //     return ans
    
    // return gen(s, 3)

    public void findList(String s, ArrayList<String> ans, String asf, int deci){
        if(deci == 0){
            if(s.length() == 0) return;
            else{
            	System.out.println(s);
                if(s.charAt(0) == '0' && s.length() == 1){
                    ans.add(asf + 0);
                }else if(s.charAt(0) == '0'){
                    return;
                }else if(s.length() < 4 && Integer.parseInt(s) <= 255){
                    ans.add(asf + s);
                }else{
                    return;
                }
                return;
            }
        }else if(s.length() == 0){
            return;
        }
        
        if(s.charAt(0) == '0'){
            findList(s.substring(1), ans, asf + "0.", deci-1);
        }else{
            int no1 = s.charAt(0)-'0';
            findList(s.substring(1), ans, asf + no1 + ".", deci-1);
            
            if(s.length() < 2) return;
            int no2 = no1*10 + (s.charAt(1)-'0');
            findList(s.substring(2), ans, asf + no2 + ".", deci-1);

            if(s.length() < 3) return;
            int no3 = no2*10 + (s.charAt(2)-'0');
            if(no3 > 255) return;
            findList(s.substring(3), ans, asf + no3 + ".", deci-1);
        }
        
    }
    
    public ArrayList<String> genIp1(String s) {
        ArrayList<String> ans = new ArrayList<>();
        findList(s, ans, "", 3);
        return ans;
    }
    
    public static void main(String args[]) {
    	System.out.println("ajs".substring(1, 2));
    	System.out.println(Integer.parseInt("0024"));
    	System.out.println(new _43_Generate_IP_Addresses().genIp1("3783022527424056"));
    }
	
}
