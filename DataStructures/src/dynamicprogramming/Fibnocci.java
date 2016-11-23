package dynamicprogramming;

public class Fibnocci {

	static int fib[] = new int[11];

	public static int calculateFibnocci(int n) {

		if (n <= 1) {
			fib[n] = n;
		} else {
			fib[n] = fib[n - 1] + fib[n - 2];
		}
		return fib[n];
	}

	public static void main(String[] args) {
		System.out.println(calculateFibnocciBottomUp(10));
	}

	public static int calculateFibnocciBottomUp(int n) {

		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}

		return fib[n];
	}

}
