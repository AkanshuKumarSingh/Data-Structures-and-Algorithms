package Time_and_space;

public class _40_Counting_Sort {

    public static String countSort(String arr)
    {
         //System.out.println("HHM");
        char seq[] = arr.toCharArray();
        int count[] = new int[26];
		for(int i = 0 ; i < seq.length; i++) {
			count[(int)(seq[i]-97)]++;
		}
		String ans = "";
		for(int i = 0 ; i < 26; i++){
		    int cnt = count[i];
		    while(cnt-- > 0){
		        ans += (char)(i+97);
		    }
		}
		return ans;
    }
	
}
