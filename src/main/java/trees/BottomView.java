package trees;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class BottomView {

	Map<Integer, Integer> m = new TreeMap<Integer, Integer>();

	public void bottomView(Node t, int column) {
		if (t == null)
			return;
		m.put(column, t.info);

		if (t.left != null) {
			bottomView(t.left, column - 1);
		}
		if (t.right != null) {
			bottomView(t.right, column + 1);
		}
	}

	public void print(Node root) {
		bottomView(root, 0);
		Set<Map.Entry<Integer, Integer>> es = m.entrySet();
		for (Map.Entry<Integer, Integer> e : es) {
			System.out.println(e.getValue());
		}

	}
}
