package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> freqs = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int freq = freqs.getOrDefault(nums[i], 0);
			freq = freq + 1;
			freqs.put(nums[i], freq);
		}
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -Integer.compare(freqs.get(o1), freqs.get(o2));
			}
		});
		for (Integer key : freqs.keySet()) {
			q.add(key);
		}
		List<Integer> ret = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ret.add(q.poll());
		}
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(new TopKFrequentElements().topKFrequent(new int[] { 1, 1, 1, 2, 2, 3}, 2));
	}

}
