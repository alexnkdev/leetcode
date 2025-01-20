package algorithms;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SuperUglyNumber {

	public int nthSuperUglyNumber(int n, int[] primes) {
		PriorityQueue<Long> q = new PriorityQueue<>();
		PriorityQueue<Long> all = new PriorityQueue<>();
		all.add(1L);
		q.add(1L);
		int generated =0 ;
		Set<Long> generatedSet = new HashSet<Long>();
		while (generated < n) {
			generated++;
			Long smallest = q.poll();
			for (int k = 0; k < primes.length; k++) {
				if (!generatedSet.contains(primes[k] * smallest)) {
					generatedSet.add(primes[k] * smallest);
					q.add(primes[k] * smallest);
					all.add(primes[k] * smallest);
//					System.out.println(smallest + "  ---> " + primes[k] * smallest);
				}
			}
		}
		int cnt = n;
		long last = 0;
		while (cnt != 0) {
			last = all.poll();
			cnt--;
		}
//		System.out.println(all);
		return (int) last;
	}
	
	public static void main(String[] args) {
		System.out.println(new SuperUglyNumber().nthSuperUglyNumber(12, new int[] { 2, 7, 13, 19} ));
	}
	
}
