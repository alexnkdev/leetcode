package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TopVotedCandidate2 {

	TreeMap<Integer, Integer> rec;
	Map<Integer, Integer> count;
	
	public TopVotedCandidate2(int[] persons, int[] times) {
		rec = new TreeMap<>();
		count = new HashMap<>();
		int leader = persons[0];
		int max = 0;
		for (int i = 0; i < persons.length; i++) {
			int personScore = count.getOrDefault(persons[i], 0) + 1;
			if (personScore >= max) {
				max = personScore;
				leader = persons[i];
			}
			count.put(persons[i], personScore);
			rec.put(times[i], leader);
		}
	}
	
	public int q(int t) {
		return rec.get(rec.floorKey(t));
	}
	
	public static void main(String[] args) {
		
	}
	
}
