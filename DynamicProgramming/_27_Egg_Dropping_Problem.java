package DynamicProgramming;

import java.util.Arrays;

public class _27_Egg_Dropping_Problem {

    static int eggDropRecursive(int eggs, int floor) {
    	if(floor == 0 || floor == 1) return floor;
    	if(eggs == 1) return floor;
    	
    	
    	int minSteps = Integer.MAX_VALUE;
    	for(int i = 1; i <= floor; i++) {
    		int temp = 1 + Math.max(eggDropRecursive(eggs-1, i-1), eggDropRecursive(eggs, floor-i));
    		System.out.println(temp);
    		minSteps = Math.min(minSteps, temp);
    	}
    	return minSteps;
	}

    static int t[][];
    static int eggDropMemoization(int eggs, int floor) {
    	if(floor == 0 || floor == 1) return floor;
    	if(eggs == 1) return floor;
    	if(t[eggs][floor] != -1) return t[eggs][floor];
    	
    	int minSteps = Integer.MAX_VALUE;
    	for(int i = 1; i <= floor; i++) {
    		int temp = 1 + Math.max(eggDropMemoization(eggs-1, i-1), eggDropMemoization(eggs, floor-i));
    		minSteps = Math.min(minSteps, temp);
    	}
    	return t[eggs][floor]=minSteps;
	}
    
    static int eggDrop(int eggs, int floor) {
    	t = new int[eggs+1][floor+1];
    	for(int i = 0 ; i <= eggs; i++) {
    		Arrays.fill(t[i], -1);
    	}
    	return eggDropMemoization(eggs, floor);
	}

    
    public static void main(String args[]) {
    	int eggs = 4, floor = 3;
    	System.out.println(eggDropRecursive(eggs, floor));
    }
    
}
