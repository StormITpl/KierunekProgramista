package pl.stormit.kp.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncExample1 {

	static ExecutorService executor;

	public static void main(String[] args) throws Exception {
		executor = Executors.newSingleThreadExecutor();

		Future<Integer> future = calculate(10);

		while (!future.isDone()) {
			System.out.println("Calculating...");
			Thread.sleep(300);
		}

		Integer result = future.get();
		System.out.println("Result => " + result);

		executor.shutdown();
	}

	static Future<Integer> calculate(Integer input) {
		return executor.submit(() -> {
			Thread.sleep(1_000);
			return input * input;
		});
	}
}
