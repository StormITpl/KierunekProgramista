package pl.stormit.kp.exceptions;

public class Exceptions2App {
	public static void main(String[] args) {
		method_a();
	}

	private static void method_a() {
		method_bb();
	}

	private static void method_bb() {
		method_ccc();
	}

	private static void method_ccc() {
		Integer number = null;
		number = number + 1;
	}
}
