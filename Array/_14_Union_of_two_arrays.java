package Array;

import java.util.HashSet;

public class _14_Union_of_two_arrays {
	
	public static int doUnion(int a[], int n, int b[], int m) 
	{
//	    System.out.println("HHM");
	    HashSet<Integer> set = new HashSet<>();
	    for(int i : a){
	        set.add(i);
	    }
	    for(int i : b){
	        set.add(i);
	    }
	    
	    return set.size();

//    def count_unique_elements(a, b):
//        unique_elements = set()
//        for i in a:
//            unique_elements.add(i)
//        for i in b:
//            unique_elements.add(i)
//        return len(unique_elements)

	    
//	    python code
//	    set_union = set(a) | set(b)
//	    result = len(set_union)
	}
}
