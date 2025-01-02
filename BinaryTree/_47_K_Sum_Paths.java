package BinaryTree;

import java.util.HashMap;

public class _47_K_Sum_Paths {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	private int pathCount;

	private void findSubtreeSumPaths(Node node, int targetSum, int currentSum, HashMap<Integer, Integer> sumFrequency) {
		if (node == null) {
			return;
		}

		// Update the current sum
		currentSum += node.data;

		// Check if there's a prefix sum that equals the target
		pathCount += sumFrequency.getOrDefault(currentSum - targetSum, 0);

		// Update the frequency map with the current sum
		sumFrequency.put(currentSum, sumFrequency.getOrDefault(currentSum, 0) + 1);

		// Traverse the left and right subtrees
		findSubtreeSumPaths(node.left, targetSum, currentSum, sumFrequency);
		findSubtreeSumPaths(node.right, targetSum, currentSum, sumFrequency);

		// Remove the current sum from the map to backtrack
		sumFrequency.put(currentSum, sumFrequency.get(currentSum) - 1);
	}

	public int sumK(Node root, int k) {
		pathCount = 0;
		int currentSum = 0;
		HashMap<Integer, Integer> sumFrequency = new HashMap<>();
		sumFrequency.put(0, 1); // Base case for the prefix sum
		findSubtreeSumPaths(root, k, currentSum, sumFrequency);
		return pathCount;
	}

}
