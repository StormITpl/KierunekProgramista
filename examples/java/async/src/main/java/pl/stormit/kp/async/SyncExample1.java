package pl.stormit.kp.async;

public class SyncExample1 {

	public static void main(String[] args) throws Exception {
		Integer result = calculate(10);
		System.out.println("Result => " + result);
	}

	static Integer calculate(Integer input) throws InterruptedException {
		Thread.sleep(1_000);
		return input * input;
	}
}
