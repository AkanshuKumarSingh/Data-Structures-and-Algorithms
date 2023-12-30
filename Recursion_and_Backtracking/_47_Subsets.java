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

	public static void main(String[] args) {
	
	}

}
