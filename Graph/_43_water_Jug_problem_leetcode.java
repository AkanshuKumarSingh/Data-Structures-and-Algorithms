package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class _43_water_Jug_problem_leetcode {

	static int operations[];
	static boolean vis[];

	public boolean minStepsUtils(int m, int n, int d, int ssf) {
		if (ssf == d) {
			return true;
		}

		vis[ssf] = true;
		for (int i = 0; i < operations.length; i++) {
			int currentStep = operations[i] + ssf;
			if (currentStep >= 0 && currentStep <= m + n && !vis[currentStep]) {
				boolean currAns = minStepsUtils(m, n, d, currentStep);
				if (currAns) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean minStepsUtils1(int m, int n, int d) {
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while(!q.isEmpty()) {
			int currCap = q.remove();
			if(vis[currCap]) {
				continue;
			}
			
			vis[currCap] = true;
			for (int i = 0; i < operations.length; i++) {
				int currentStep = operations[i] + currCap;
				if(currentStep == d) {
					return true;
				}
				if (currentStep >= 0 && currentStep <= m + n && !vis[currentStep]) {
					q.offer(currentStep);
				}
			}
			
		}
		return false;
	}
	
	public boolean canMeasureWater(int m, int n, int d) {
		vis = new boolean[m + n + 1];
		operations = new int[] { m, -1 * m, n, -1 * n };
		return minStepsUtils(m, n, d, 0);

	}
}