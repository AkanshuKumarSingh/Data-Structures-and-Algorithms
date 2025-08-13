package Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _7_First_non_repeating_character_in_stream {

    public String FirstNonRepeating1(String S) {
        Queue<Character> q = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder("" + S.charAt(0));
        map.put(S.charAt(0), 1);
        q.add(S.charAt(0));
        
        for(int i = 1 ; i < S.length(); i++){
            char ch = S.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, -1);
                while(!q.isEmpty() && map.get(q.peek()) == -1){
                    q.remove();
                }
                
                if(q.size() > 0)
                    sb.append("" + q.peek());
                else{
                    sb.append("#");
                }
            }else{
                map.put(ch, 1);
                q.add(ch);
                sb.append("" + q.peek());
            }
        }
        return sb.toString();
    }

//    def FirstNonRepeating(S: str) -> str:
//        q = deque()
//        char_map = {}
//        result = S[0]
//        char_map[S[0]] = 1
//        q.append(S[0])
//
//        for i in range(1, len(S)):
//            ch = S[i]
//            if ch in char_map:
//                char_map[ch] = -1
//                while q and char_map.get(q[0], -1) == -1:
//                    q.popleft()
//                if q:
//                    result += q[0]
//                else:
//                    result += "#"
//            else:
//                char_map[ch] = 1
//                q.append(ch)
//                result += q[0]
//        return result

    
	public String FirstNonRepeating(String str) {
		StringBuilder ans = new StringBuilder();
		Queue<Character> q = new LinkedList<>();
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!map.containsKey(ch)) {
				q.offer(ch);
				map.put(ch, 1);
				ans.append(q.peek());
			} else {
				map.put(ch, -1);
				if (q.isEmpty()) {
					ans.append("#");
				} else if (ch == q.peek()) {
					while (q.size() > 0) {
						if (map.get(q.peek()) == -1)
							q.poll();
						else
							break;
					}
					if (q.isEmpty())
						ans.append("#");
					else
						ans.append(q.peek());
				} else {
					ans.append(q.peek());
				}
			}
		}
		return ans.toString();
	}

}
