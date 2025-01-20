package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (target < 0) {
			return new ArrayList<List<Integer>>();
		}
		if (target == 0) {
			List<List<Integer>> ret = new ArrayList<>();
			ret.add(new ArrayList<>());
			return ret;
		}
		Set<List<Integer>> ret = new HashSet<>();
		for (int i = 0; i < candidates.length; i++) {
			if (target - candidates[i] >= 0) {
				List<List<Integer>> subTask = combinationSum(candidates, target - candidates[i]);
				for (List<Integer> values : subTask) {
					List<Integer> option = new ArrayList<Integer>();
					option.add(candidates[i]);
					option.addAll(values);
					Collections.sort(option);
					ret.add(option);
				}
			}
		}
		return ret.stream().collect(Collectors.toList());
	}

	public static void main(String[] args) {
		System.out.println(new CombinationSum().combinationSum(new int[] { 2, 3, 5 }, 8));
	}

}
