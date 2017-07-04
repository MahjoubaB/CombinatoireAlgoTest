/**
 * Created by Mahjouba on 05/07/17.
 */
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class CombinatoireAlgoTest {

	CombinatoireAlgo provider;

	public CombinatoireAlgoTest() {
		provider = new CombinatoireAlgo();
	}

	// Verify of there is not the same result twice
	@Test
	public void Test_Result_twice() {
		System.out.println("Starting : " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		String s = "abc";
		List<String> result = new ArrayList<String>();
		provider.combi(s.trim().toCharArray(), 0, result);
		System.out.println(" - The obtained results : " + result);
		Set<String> set = new HashSet<String>(result);
		assertFalse(set.size() < result.size());
		System.out.println("Ending test."+ "\n");

	}

	// Verify of the expected number of results is correct
	@Test
	public void Test_Numbre_Results() {

		System.out.println("Starting : " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		String s = "abc";
		List<String> result = new ArrayList<String>();
		provider.combi(s.trim().toCharArray(), 0, result);

		if (empty(s.trim())) {
			int res = result.size();
			assertEquals(0, res);
		} else {
			int expected = calculateDistinctSubStringSum(result);
			int res = result.size();
			// assertEquals(expected, res);
			System.out
					.println(" - The expected number of results :" + expected);
			System.out.println(" - The obtained number of results :" + res);
			assertEquals(expected, res);
		}

		System.out.println("Ending test.");
	}

	public static int factorial(int N) {
		int multi = 1;
		for (int i = 1; i <= N; i++) {
			multi = multi * i;
		}
		return multi;
	}

	public static boolean empty(final String s) {
		// Null-safe, short-circuit evaluation.
		return s == null || s.trim().isEmpty();
	}

	public static int calculateDistinctSubStringSum(List<String> membA) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		// char[] charAarry = text.toCharArray();
		for (int i = 0; i < membA.size(); i++) {
			map.put(membA.get(i) + "", 1);
		}
		return map.size();

	}
}
