package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> frequency = new HashMap<String, Integer>();
		for (String word : words) {
			int freq = frequency.getOrDefault(word, 0);
			freq++;
			frequency.put(word, freq);
		}
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int fq1 = frequency.get(o1);
				int fq2 = frequency.get(o2);
				if (fq1 == fq2) {
					return o1.compareTo(o2);
				}
				return - Integer.compare(frequency.get(o1), frequency.get(o2));
			}
		});
		for (String word : frequency.keySet()) {
			pq.add(word);
		}
		List<String> ret = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ret.add(pq.poll());
		}
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(new TopKFrequentWords().topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2));
	}

}
