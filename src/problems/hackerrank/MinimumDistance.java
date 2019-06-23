package problems.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistance {

	static int minimumDistances(int[] numbers) {

		Map<Integer, List<Integer>> indexMap = new HashMap<>();

		for (int i = 0; i < numbers.length; i++) {
			List<Integer> indexes = indexMap.get(numbers[i]);
			if (indexes == null) {
				indexes = new ArrayList<>();
				indexMap.put(numbers[i], indexes);
			}
			indexes.add(i);
		}
		int minDistance = Integer.MAX_VALUE;
		for (Integer key : indexMap.keySet()) {
			List<Integer> indexes = indexMap.get(key);
			if (indexes.size() < 2)
				continue;
			int distance = 0;
			for (int i = 0; i < indexes.size() - 1; i++) {
				distance = indexes.get(i + 1) - indexes.get(i);
				if (distance < minDistance) {
					minDistance = distance;
				}
			}

		}
		if (minDistance == Integer.MAX_VALUE) {
			minDistance = -1;
		}
		return minDistance;
	}
}
