package Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class _47_Subsets {
	
    public static void prepareSubSets(int idx, ArrayList<Integer> ip, ArrayList<Integer> currAns,
    ArrayList<ArrayList<Integer>> list
    ){
        if(idx == ip.size()){
            ArrayList<Integer> bans = new ArrayList<>(currAns);
            list.add(bans);
            return;
        }
        
        prepareSubSets(idx+1, ip, currAns, list);
        currAns.add(ip.get(idx));
        prepareSubSets(idx+1, ip, currAns, list);
        currAns.remove(currAns.size()-1);

    }
    
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> ip)
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> currAns = new ArrayList<>();
        prepareSubSets(0, ip, currAns, list);
        Collections.sort(list, new Comparator<ArrayList<Integer>>(){
        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            int size = Math.min(o1.size(), o2.size());
            for (int i = 0; i < size; i++) {
                int comp = o1.get(i) - o2.get(i);
                if (comp != 0) {
                    return comp;
                }
            }
            return o1.size() - o2.size();
        }
        });
        return list;

    }

// def subsets(ip):
//     def prepare_subsets(idx, curr_ans, result):
//         if idx == len(ip):
//             result.append(curr_ans.copy())
//             return
        
//         # Exclude current element
//         prepare_subsets(idx + 1, curr_ans, result)
        
//         # Include current element
//         curr_ans.append(ip[idx])
//         prepare_subsets(idx + 1, curr_ans, result)
//         curr_ans.pop()  # Backtrack
    
//     list_result = []
//     prepare_subsets(0, [], list_result)
    
//     # Custom sorting similar to Java Comparator
//     def custom_sort(subset):
//         return (len(subset), subset)
    
//     list_result.sort(key=custom_sort)
//     return list_result
    
	public static void main(String[] args) {
	
	}

}
