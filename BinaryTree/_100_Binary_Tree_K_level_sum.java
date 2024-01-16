package BinaryTree;

public class _100_Binary_Tree_K_level_sum {

    static int kLevelSum(int K, String S) {
        int currLvl = -1, sum = 0;
        for(int i = 0 ; i < S.length(); i++){
            char ch = S.charAt(i);
            if(ch == '('){
                currLvl++;
            }else if(ch == ')'){
                currLvl--;
            }else if(currLvl == K){
                int no = 0;
                while(S.charAt(i) >= '0' && S.charAt(i) <= '9'){
                    no = no*10 + (int)(S.charAt(i) - '0');
                    i++;
                }
                i--;
                sum += no;
            }
        }
        return sum;
        
    }
	
}
