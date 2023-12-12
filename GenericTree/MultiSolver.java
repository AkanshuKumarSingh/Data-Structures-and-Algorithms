package GenericTree;

import java.util.ArrayList;

public class MultiSolver {
	
	public class Node{
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	public static class MSPair {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int ht = -1;
		int size = 0;
	}
	
	public static MSPair multiSolver(Node root) {
		MSPair mres = new MSPair();
		mres.max = mres.min = root.data;
		
		for(Node child : root.children) {
			MSPair rres = multiSolver(child);
			
			mres.min = Math.min(mres.min, rres.min);
			mres.max = Math.max(mres.max, rres.max);
			mres.ht = Math.max(mres.ht,rres.ht);
			mres.size += (rres.size);
			
		}
		mres.ht++;
		mres.size++;
		
		return mres;
	}

	public static void main(String[] args) {

	}

}
