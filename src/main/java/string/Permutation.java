package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
	public static void main(String[] args) {
      String str = "abb";
      Permutation permutation = new Permutation();
      permutation.permuteUtil(str);
      System.out.println();
      // permuteWithoutBacktracking(str, 0);
      // System.out.println();
      //permuteInputOutputBack(str, "");
      List<List<String>> result = new ArrayList<>();
      permuteWithSwap(0, str, result);
      System.out.println();
      System.out.println(result);
    }

	/**
	 * permutation function
	 *
	 * @param str
	 *            string to calculate permutation for
	 * @param l
	 *            starting index
	 * @param r
	 *            end index
	 */
	private void permuteBacktracking(String str, int l, int r, Set<String> unique) {
      if (l == r && !unique.contains(str)) {
        System.out.print(str + " ");// extra n times for printing therefore
        unique.add(str);
      } // O(N*N!)
      else {
        for (int i = l; i <= r; i++) // n times T(N)=n*(O(1)+T(N-1) +O(1))==
        // N*N-1*N-2*N-3......1 = N!
        {
          str = swap(l, i, str);
          permuteBacktracking(str, l + 1, r, unique);
          str = swap(l, i, str);
        }
      }
    }

	private static void permuteWithoutBacktracking(String str, int l) {
      if (l == str.length() - 1) {
        System.out.print(str + " ");// extra n times for printing therefore
        return;
      } // O(N*N!)
      else {
        for (int i = l; i <= str.length() - 1; i++) // n times
        // T(N)=n*(O(1)+T(N-1)
        // +O(1))==
        // N*N-1*N-2*N-3......1 = N!
        {
          str = swap(l, i, str);
          permuteWithoutBacktracking(str, l + 1);
          str = swap(l, i, str);
        }
      }
    }

  private static void permuteWithSwap(int i, String str, List<List<String>> result) {
    if (i == str.length() - 1) {
      result.add(List.of(str));
      return;
    }
    for (int j = i; j < str.length(); j++) {
      str = swap(i, j, str);
      permuteWithSwap(i + 1, str, result);
      str = swap(i, j, str);
    }
  }

	private static void permuteInputOutputBack(String input, String output) {
		if (input.isEmpty()) {
			System.out.print(output + " ");// extra n times for printing
											// therefore
			return;
		} else {
			for (int i = 0; i < input.length(); i++) {
				String newOutput = output + input.charAt(i);
				String newInput = input.substring(0, i) + input.substring(i + 1);
				permuteInputOutputBack(newInput, newOutput);
				// output = output.substring(0, output.length() - 1);  no need to reset output and input as we are not modifying them as we created temparay newinput and newoutput strings.

			}
		}
	}

	public Set<String> permuteUtil(String str) {
		int len = str.length();
		Set<String> unique = new HashSet<>();
		permuteBacktracking(str, 0, len - 1, unique);
		return unique;

	}

	/**
	 * Swap Characters at position
	 *
	 * @param str
	 *            string value
	 * @param i
	 *            position 1
	 * @param j
	 *            position 2
	 * @return swapped string
	 */
	public static String swap( int i, int j, String str) {
      char temp;
      char[] charArray = str.toCharArray();
      temp = charArray[i];
      charArray[i] = charArray[j];
      charArray[j] = temp;
      return String.valueOf(charArray);
    }

}