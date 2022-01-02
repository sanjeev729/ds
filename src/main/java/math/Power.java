package math;

public class Power {
	int m, n;

	public static float power(float x, int y) {
		if (y < 0) {
			return powerUtil(1 / x, -y);
		} else {
			return powerUtil(x, y);
		}
	}

	public static float powerUtil(float x, int y) {
		// check for x^0=1
		if (y == 0) {
			return 1;
		}
		// check for 0^y=0
		if (x == 0) {
			return 0;
		}

		return x * powerUtil(x, y - 1);
	}

	public static float powerDC(float x, int y) {

		if (y == 0) {
			return 1;
		}

		// check for 0^y=0
		if (x == 0) {
			return 0;
		}

		float t = powerDC(x, y / 2);

		if (y % 2 == 0) {
			return t * t;
		} else {
			return x * t * t;
		}
	}

	public static void main(String[] args) {
		System.out.println(power(2, 2));
		System.out.println(power(2, -2));
		System.out.println(power(2, 3));
		System.out.println(powerDC(2, 3));
	}

}
