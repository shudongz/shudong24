package math24;

import java.util.HashSet;
import java.util.Set;

public class FourNumbers {

	private Fraction num[];

	public FourNumbers(int a, int b, int c, int d) {
		num = new Fraction[4];
		num[0] = new Fraction(a, 1, Integer.toString(a));
		num[1] = new Fraction(b, 1, Integer.toString(b));
		num[2] = new Fraction(c, 1, Integer.toString(c));
		num[3] = new Fraction(d, 1, Integer.toString(d));
	}

	public Set<Fraction> computeTwo(Fraction f1, Fraction f2) {
		Set<Fraction> result = new HashSet<Fraction>();
		result.add(f1.add(f2));
		result.add(f1.subtract(f2));
		result.add(f2.subtract(f1));
		result.add(f1.multiply(f2));
		result.add(f1.devide(f2));
		result.add(f2.devide(f1));
		
		return result;
	}

	public Set<Fraction> computeThree(Fraction f1, Fraction f2, Fraction f3) {
		Set<Fraction> result = new HashSet<Fraction>();
		Set<Fraction> ff = computeTwo(f1, f2);
		for (Fraction f : ff) {
			result.addAll(computeTwo(f, f3));
		}
		ff = computeTwo(f1, f3);
		for (Fraction f : ff) {
			result.addAll(computeTwo(f, f2));
		}
		ff = computeTwo(f2, f3);
		for (Fraction f : ff) {
			result.addAll(computeTwo(f1, f));
		}
		return result;
	}

	public String Compute() {
		Set<Fraction> result = new HashSet<Fraction>();
		Set<Fraction> ff = computeTwo(num[0], num[1]);
		for (Fraction f : ff) {
			result.addAll(computeThree(f, num[2], num[3]));
		}
		ff = computeTwo(num[0], num[2]);
		for (Fraction f : ff) {
			result.addAll(computeThree(f, num[1], num[3]));
		}
		ff = computeTwo(num[0], num[3]);
		for (Fraction f : ff) {
			result.addAll(computeThree(f, num[1], num[2]));
		}
		ff = computeTwo(num[1], num[2]);
		for (Fraction f : ff) {
			result.addAll(computeThree(f, num[0], num[3]));
		}
		ff = computeTwo(num[1], num[3]);
		for (Fraction f : ff) {
			result.addAll(computeThree(f, num[0], num[2]));
		}
		ff = computeTwo(num[2], num[3]);
		for (Fraction f : ff) {
			result.addAll(computeThree(f, num[0], num[1]));
		}

		String ret = "";
		for (Fraction r : result) {
			if (r.isTwentyFour())
				ret += r.toString() + ";";
		}
		return ret.isEmpty() ? "impossible" : ret;
	}
}