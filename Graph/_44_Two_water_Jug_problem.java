package Graph;

import java.util.Arrays;

public class _44_Two_water_Jug_problem {
	
	static int operations[];
	static int steps[];
	static boolean vis[];
	static String paths[];
	
	public int minStepsUtils(int m, int n, int d, int ssf, int prev) {
		if(ssf == d) {
			return 0;
		}
		
		vis[ssf] = true;
		System.out.println(ssf);
		for(int i = 0; i < operations.length; i++) {
			int currentStep = operations[i] + ssf;
			if (currentStep >= 0 && currentStep <= m+n && !vis[currentStep]) {
				int currAns = minStepsUtils(m, n, d, currentStep, prev);
				if(currAns != Integer.MAX_VALUE) {
//					System.out.println(ssf + " : " + currentStep);
					if(currAns+1 < steps[ssf]) {
			    		System.out.println(steps[ssf] + "aaaaaa");
						paths[ssf] = currentStep + paths[currentStep];
					}
					steps[ssf] = Math.min(currAns + 1, steps[ssf]);
				}
			}
		}
		
		return steps[ssf];
	}
	
    public int minSteps(int m, int n, int d)
    {
    	vis = new boolean[m+n+1];
        operations = new int[]{-1*n, n, -1*m, m};
        steps = new int[m+n+1];
        paths = new String[m+n+1];
        for(int i = 0; i < steps.length; i++) {
        	paths[i] = new String("");
        }
        Arrays.fill(steps, Integer.MAX_VALUE);
    	int a =  minStepsUtils(m,n,d,0,-1);
    	for(int i=0; i < steps.length; i++) {
    		System.out.print(steps[i] + " ");
    		System.out.println(paths[i]);
    	}
    	return a;
    }

	
    public static void main(String[] args) {
    	System.out.println(new _44_Two_water_Jug_problem().minSteps(3, 5, 4));
    	System.out.println();
    }
    
}
