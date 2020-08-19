package pl.stormit.kp.exceptions;

public class Exceptions4App {
	public static void main(String[] args) {
		try {
			method_a();
		} catch (Exception e) {
			System.out.println("Some strange error occurred. Please check logs.");
			e.printStackTrace();
		} finally {
			System.out.println("Block finally will always be called.");
		}
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
