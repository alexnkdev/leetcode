package algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TopVotedCandidate {

	int[] times;
	int[] leaders;
	
	public TopVotedCandidate(int[] persons, int[] times) {
		int n = persons.length;
		this.times = times;
		PriorityQueue<PersonVote> pq = new PriorityQueue<>(new Comparator<PersonVote>() {
			@Override
			public int compare(PersonVote o1, PersonVote o2) {
				if (o1.votecount == o2.votecount) {
					return -Integer.compare(o1.voteindex, o2.voteindex);
				}
				return -Integer.compare(o1.votecount, o2.votecount);
			}
		});
		for (int i = 0; i < n; i++) {
			pq.add(new PersonVote(i, 0, 0));
		}
		int[] total = new int[5001];
		leaders = new int[times.length];
		for (int i = 0; i < times.length; i++) {
			PersonVote newValue = new PersonVote(persons[i], total[persons[i]] + 1, i);
			pq.remove(newValue);
			pq.add(newValue);
			PersonVote leader = pq.peek();
			leaders[i] = leader.idx;
		}
		System.out.println(Arrays.toString(leaders));
	}
	

	public int q(int t) {
		for (int i = 0; i < times.length; i++) {
			if (times[i] > t) {
				return leaders[i - 1];
			}
		}
		return leaders[times.length - 1];
	}
	
	public static void main(String[] args) {
		TopVotedCandidate tvc = new TopVotedCandidate(new int[] { 0,1,1,0,0,1,0 }, new int[] { 0,5,10,15,20,25,30 } );
		System.out.println(tvc.q(3));
		System.out.println(tvc.q(12));
		System.out.println(tvc.q(25));
		System.out.println(tvc.q(15));
		System.out.println(tvc.q(24));
		System.out.println(tvc.q(8));
	}
	
	static class PersonVote {
		
		public int idx;
		public int votecount;
		public int voteindex;
		
		public PersonVote(int idx, int votecount, int voteindex) {
			this.idx = idx;
			this.votecount = votecount;
			this.voteindex = voteindex;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + idx;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PersonVote other = (PersonVote) obj;
			if (idx != other.idx)
				return false;
			return true;
		}
		
	}

}
