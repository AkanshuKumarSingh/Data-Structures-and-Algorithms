package Hashing;

public class _32_Uncommon_characters {

	String UncommonChars(String A, String B) {
		int ch[] = new int[26];
		for (int i = 0; i < A.length(); i++) {
			int idx = (int) (A.charAt(i) - 'a');
			ch[idx] = -1;
		}

		for (int i = 0; i < B.length(); i++) {
			int idx = (int) (B.charAt(i) - 'a');
			if (ch[idx] == -1) {
				ch[idx] = -2;
			} else if (ch[idx] != -2) {
				ch[idx] = -3;
			}
		}

		StringBuilder str = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			char c = (char) (97 + i);
			if (ch[i] == -3 || ch[i] == -1) {
				str.append(c);
			}
		}

		return str.length() == 0 ? "-1" : str.toString();
	}

}
