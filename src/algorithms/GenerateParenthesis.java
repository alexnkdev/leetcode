package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GenerateParenthesis {

	public List<String> generateParenthesis(int n) {
		 if (n == 0) {
			 List<String> ret = new ArrayList<>();
			 ret.add("");
			 return ret;
		 }
		 Set<String> ret = new HashSet<String>();
		 for (int p = 1; p < n; p++) {
			 int left = p;
			 int right = n - p;
			 List<String> gen1 = generateParenthesis(left);
			 List<String> gen2 = generateParenthesis(right);
			 for (int i = 0; i < gen1.size(); i++) {
				 for (int j = 0; j < gen2.size(); j++) {
					 ret.add(gen1.get(i) + gen2.get(j));
				 }
			 }
		 }
		 List<String> gen3 = generateParenthesis(n - 1);
		 for (String x : gen3) {
			 ret.add("(" + x + ")");
		 }
		 return ret.stream().collect(Collectors.toList());
	}
	
	public static void main(String[] args) {

		System.out.println(new GenerateParenthesis().generateParenthesis(4));
	}

}
