package algorithms;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class UglyNumber2 {

	public static void main(String[] args) {
		int x = new UglyNumber2().nthUglyNumber(1690);
		System.out.println(x);
	}
	public int nthUglyNumber(int n) {
		Queue<Long> all = new PriorityQueue<Long>();
		Queue<Long> q = new PriorityQueue<Long>();
		Set<Long> processed = new HashSet<>();
		q.add(1L);
		all.add(1L);
		while (all.size() < 2000) {
			Long current = q.poll();
			if (!processed.contains(current * 2)) {
				processed.add(current * 2);
				q.add(current * 2);

				all.add(current * 2);
			}
			if (!processed.contains(current * 3)) {
				processed.add(current * 3);
				q.add(current * 3);

				all.add(current * 3);
			}
			if (!processed.contains(current * 5)) {
				processed.add(current * 5);
				q.add(current * 5);
				all.add(current * 5);
			}
		}
		int cnt = 0;
		Long ret = 0L;
		while (cnt != n) {
			ret = all.poll();
			cnt++;
		}
		return ret.intValue();
	}

}
