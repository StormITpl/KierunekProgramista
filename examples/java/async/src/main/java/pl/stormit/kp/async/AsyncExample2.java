package pl.stormit.kp.async;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncExample2 {

	static ExecutorService executor;iagram związków encji / ERD entity relationship diagram
372
  - zależności, kolumny, klucze, tabela = encja
373
  - MySQL Workbench  


	public static void main(String[] args) throws Exception {
		executor = Executors.newFixedThreadPool(10);
		Map<Integer, Future<Integer>> futures = new HashMap<>();

		System.out.println("Starting...");
		for (int i = 0; i < 10; i++) {
			futures.put(i, calculate(i));
		}

		boolean finished = false;
		for (int iteration = 1; !finished; iteration++) {
			for (int i = 0; i < 10; i++) {
				finished = true;
				var future = futures.get(i);

				if (future.isDone()) {
					System.out.println(String.format("Result for: %d is %d.", i, future.get()));
				} else {
					System.out.println(String.format("Calculating [%d]...", i));
					finished = false;
				}
			}
			System.out.println("-----------------------");
			Thread.sleep(300);
		}

		executor.shutdown();
	}

	static Future<Integer> calculate(Integer input) {
		return executor.submit(() -> {
			Thread.sleep(1000);
			return input * input;
		});
	}
}
