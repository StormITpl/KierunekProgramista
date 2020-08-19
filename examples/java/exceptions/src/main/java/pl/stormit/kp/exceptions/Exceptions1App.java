package pl.stormit.kp.exceptions;

public class Exceptions1App {
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
		throw new RuntimeException("Exception from method_ccc");
		//---
	}
}
