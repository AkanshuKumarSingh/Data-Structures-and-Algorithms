package Sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class _32_Alien_Dictionary {

    public void dfs(Character ch, HashMap<Character, ArrayList<Character>> map, HashSet<Character> vis, Stack<Character> st){
        // System.out.println(ch);
    	vis.add(ch);
        for(Character neigh: map.getOrDefault(ch, new ArrayList<Character>())){
            if(!vis.contains(neigh)){
                dfs(neigh, map, vis, st);
            }
        }
        st.add(ch);
    }
    
    public String findOrder(String [] dict, int N, int K){
        HashMap<Character, ArrayList<Character>> map = new HashMap<>();

        for(int i = 0 ; i < dict.length-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];

            for(int j = 0; j < s1.length() && j < s2.length(); j++){
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if(c1 != c2){
                    ArrayList<Character> neighs = map.getOrDefault(c1, new ArrayList<Character>());
                    neighs.add(c2);
                    map.put(c1, neighs);
                    break;
                }
            }
        }
        
        for(int i = 0; i < K; i++){
            char ch = (char)((int)'a' + i);
            // System.out.println(ch + " :" + map.get(ch));
        }
        
        HashSet<Character> vis = new HashSet<>();
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < K; i++){
            char ch = (char)((int)'a' + i);
            if(!vis.contains(ch)){
                dfs(ch, map, vis, st);
            }
        }
        
        String ans = "";
        while(!st.isEmpty()){
            ans += st.pop();
        }
        
        return ans;
    }

//    def dfs(ch, graph, visited, stack):
//        visited.add(ch)
//        for neighbor in graph.get(ch, []):
//            if neighbor not in visited:
//                dfs(neighbor, graph, visited, stack)
//        stack.append(ch)
//
//    def find_order(dict, N, K):
//        from collections import defaultdict
//
//        graph = defaultdict(list)
//
//        # Build the graph based on given dictionary
//        for i in range(N - 1):
//            s1 = dict[i]
//            s2 = dict[i + 1]
//            for j in range(min(len(s1), len(s2))):
//                if s1[j] != s2[j]:
//                    graph[s1[j]].append(s2[j])
//                    break
//
//        visited = set()
//        stack = []
//
//        # Topological sort
//        for i in range(K):
//            ch = chr(ord('a') + i)
//            if ch not in visited:
//                dfs(ch, graph, visited, stack)
//
//        # Reverse the result for correct order
//        return ''.join(reversed(stack))

	
}
