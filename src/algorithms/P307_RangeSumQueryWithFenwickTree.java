package algorithms;

public class P307_RangeSumQueryWithFenwickTree {

	class NumArray {

		private FenwickTree fw;
		
		private int[] nums;
		
	    public NumArray(int[] nums) {
	    	this.nums = nums;
	        fw = new FenwickTree(nums);
	    }
	    
	    public void update(int index, int val) {
	    	nums[index] = val;
	        fw.inc(index, val - nums[index]);
	    }
	    
	    public int sumRange(int left, int right) {
	        return fw.sum(left, right);
	    }                                                                                      
	    
	}
	
	class FenwickTree {
		
		int[] tree;
		
		public FenwickTree(int[] arr) {
			tree = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				inc(i, arr[i]);
			}
		}
		
		public void inc(int index, int delta) {
			while (index < tree.length) {
				tree[index] += delta;
				index = index | (index + 1);
			}
		}
		
		public int sum(int right) {
			int ret = 0;
			while (right >= 0) {
				ret += tree[right];
				right = (right & (right + 1)) - 1;
			}
			return ret;
		}
		
		public int sum(int left, int right) {
			return sum(right) - sum(left - 1);
		}
		
	}
	
	public static void main(String[] args) {
		NumArray arr = new P307_RangeSumQueryWithFenwickTree().new NumArray(new int[] { 7, 2, 7, 2, 0} );
		arr.update(4, 6);
		arr.update(0, 2);
		arr.update(0, 9);
	}

}
