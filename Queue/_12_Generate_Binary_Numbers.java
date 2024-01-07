package Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _12_Generate_Binary_Numbers {

	static ArrayList<String> generate(int N) {
		ArrayList<String> ans = new ArrayList<>();
		Queue<String> q = new LinkedList<>();
		q.offer("1");

		while (N-- > 0) {
			String no = q.poll();
			ans.add(no);
			q.offer(no + "0");
			q.offer(no + "1");
		}

		return ans;
	}

}
