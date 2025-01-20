package algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {

	public int leastBricks(List<List<Integer>> wall) {
		Map<Long, Integer> endsCount = new HashMap<>();
		long wallLength = 0;
		for (List<Integer> row : wall) {
			long sum = 0;
			for (Integer brick : row) {
				sum += brick;
				if (!endsCount.containsKey(sum)) {
					endsCount.put(sum, 1);
				} else {
					endsCount.put(sum, endsCount.get(sum) + 1);
				}
			}
			wallLength = sum;
		}
		int max = 0;
		for (Long end : endsCount.keySet()) {
			if (end != wallLength) {
				Integer cnt = endsCount.get(end);
				if (cnt > max) {
					max = cnt;
				}
			}
		}
		return wall.size() - max;
	}

}
