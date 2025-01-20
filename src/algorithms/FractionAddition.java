package algorithms;

import java.util.ArrayList;
import java.util.List;

class FractionAddition {
	
	public static void main(String[] args) {
		System.out.println(new FractionAddition().fractionAddition("1/3-1/2"));
	}
    public String fractionAddition(String expression) {
        String term = "";
        List<String> terms = new ArrayList<String>();
        for (int i = 0; i <= expression.length(); i++) {
            if (i == expression.length() ||
                expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                if (term.length() > 0) {
                    terms.add(term);
                }
                if (i < expression.length()) {
                    term = "" + expression.charAt(i);
                }
            } else {
                term = term + expression.charAt(i);
            }
        }
        Fraction sum = new Fraction();
        sum.num = 0;
        sum.den = 1;
        for (int i = 0; i < terms.size(); i++) {
            Fraction fr = Fraction.parse(terms.get(i));
            sum = sum.add(fr);
        }
        if (sum.num == 0) {
            return "0/1";
        }
        int g = gcd(Math.abs(sum.num), Math.abs(sum.den));
        sum.num = sum.num / g;
        sum.den = sum.den / g;
        return sum.num + "/" + sum.den;
    }
    
    static class Fraction {
        int num;
        int den;
        
        static Fraction parse(String str) {
            Fraction ret = new Fraction();
            String[] tokens = str.split("/");
            ret.num = Integer.parseInt(tokens[0]);
            ret.den = Integer.parseInt(tokens[1]);
            return ret;
        }
        
        Fraction add(Fraction second) {
            int den = lcm(this.den, second.den);
            int mult1 = den / this.den;
            int mult2 = den / second.den;
            Fraction ret = new Fraction();
            ret.den = den;
            ret.num = this.num * mult1 + second.num * mult2;
            if (ret.den < 0) {
                ret.den = - ret.den;
                ret.num = -ret.num;
            }
            return ret;
        }
    }
    
    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}