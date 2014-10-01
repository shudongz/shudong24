package math24;

public class Fraction {
	static final int prime[] = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23};

	int numerator;
	int denominator;
	String expression;

	public Fraction(int n, int d, String exp) {
		numerator = n;
		denominator = d;
		expression = exp;
		reduce();
	}

	private boolean isDivisible(int num, int factor) {
		return (num/factor) * factor == num;
	}

	private void reduce() {
		if (numerator == 0 || denominator == 0)
			return;
		for (int i = 0; i < prime.length; i++) {
			if (isDivisible(numerator, prime[i]) &&
					isDivisible(denominator, prime[i])) {
				numerator /= prime[i];
				denominator /= prime[i];
				i--;
			}
		}
	}

	public Fraction add(Fraction frac) {
		int denom = denominator * frac.denominator;
		int num = numerator * frac.denominator + denominator * frac.numerator;
		String exp = "(" + expression + "+" + frac.expression + ")";
		return new Fraction(num, denom, exp);
	}

	public Fraction subtract(Fraction frac) {
		int denom = denominator * frac.denominator;
		int num = numerator * frac.denominator - denominator * frac.numerator;
		String exp = "(" + expression + "-" + frac.expression + ")";
		return new Fraction(num, denom, exp);
	}

	public Fraction multiply(Fraction frac) {
		int denom = denominator * frac.denominator;
		int num = numerator * frac.numerator;
		String exp = "(" + expression + "x" + frac.expression + ")";
		return new Fraction(num, denom, exp);
	}

	public Fraction devide(Fraction frac) {
		int denom = denominator * frac.numerator;
		int num = numerator * frac.denominator;
		String exp = "(" + expression + "/" + frac.expression + ")";
		return new Fraction(num, denom, exp);
	}

	public boolean isTwentyFour() {
		return numerator == 24 && denominator == 1;
	}

	public boolean isNaN() {
		return denominator == 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + denominator;
		result = prime * result
				+ ((expression == null) ? 0 : expression.hashCode());
		result = prime * result + numerator;
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
		Fraction other = (Fraction) obj;
		if (denominator != other.denominator)
			return false;
		if (expression == null) {
			if (other.expression != null)
				return false;
		} else if (!expression.equals(other.expression))
			return false;
		if (numerator != other.numerator)
			return false;
		return true;
	}

	public String toString() {
		return expression;
	}
}
