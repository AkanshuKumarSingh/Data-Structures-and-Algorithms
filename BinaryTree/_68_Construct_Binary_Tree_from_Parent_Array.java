package BinaryTree;

public class _68_Construct_Binary_Tree_from_Parent_Array {

	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	public static Node createTree(int parent[], int N) {
		Node nodes[] = new Node[N];
		Node head = null;

		for (int i = 0; i < N; i++)
			nodes[i] = new Node(-1);

		for (int i = 0; i < N; i++) {
			int no = parent[i];
			if (no == -1) {
				head = nodes[i];
				head.data = i;
			} else {
				nodes[i].data = i;
				if (nodes[no].left == null) {
					nodes[no].left = nodes[i];
				} else {
					nodes[no].right = nodes[i];
				}
			}
		}
		return head;
	}

}
