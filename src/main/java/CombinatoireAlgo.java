/**
 * Created by Mahjouba on 05/07/17.
 */
import java.util.List;

public class CombinatoireAlgo {

	static int count = 0;

	public CombinatoireAlgo() {
		// TODO Auto-generated constructor stub

	}

	public void combi(char[] s, int i, List<String> result) {

		if (i == s.length - 1) {
			count++; // count no of words output and print the permutation.
			// System.out.println(count + ") " + new String(s));
			result.add(new String(s));
		}
		int curr = i;
		for (; i < s.length; i++) {
			swap(s, i, curr);
			combi(s, curr + 1, result);
			swap(s, i, curr);
		}

	}

	static void swap(char[] s, int i, int j) {
		char c = s[i];
		s[i] = s[j];
		s[j] = c;
	}
}