package pl.stormit.kp.datastructures;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DataStructuresApp {
	public static void main(String[] args) {
		record();
		array();
		linkedList();
		stack();
		queue();
		set();
		map();
	}

	private static void record() {
		System.out.println("\n\n=> Record \t\t===============================");

		City city = new City();

		city.name = "Gdańsk";
		city.province = "Pomorskie";
		city.population = 500_000;

		System.out.println(city.name);
	}

	private static void array() {
		System.out.println("\n\n=> Array \t\t===============================");

		City[] cities = new City[10];
		cities[0] = new City();
		cities[5] = new City();
		cities[5].name = "Gdańsk";

		System.out.println(Arrays.toString(cities));
	}

	private static void linkedList() {
		System.out.println("\n\n=> LinkedList \t\t===============================");

		LinkedList<String> list = new LinkedList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		System.out.println(list);

		list.remove("C");
		System.out.println(list);

		list.add(2, "c");
		System.out.println(list);
	}

	private static void stack() {
		System.out.println("\n\n=> Stack \t\t===============================");

		Deque<String> stack = new LinkedList<>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		System.out.println(stack);

		stack.pop();
		System.out.println(stack);
	}

	private static void queue() {
		System.out.println("\n\n=> Queue \t\t===============================");

		Queue<String> queue = new LinkedList<>();
		queue.add("A");
		queue.add("B");
		queue.add("C");
		queue.add("D");
		System.out.println(queue);

		queue.poll();
		System.out.println(queue);
	}

	private static void set() {
		System.out.println("\n\n=> Set \t\t===============================");

		Set<String> set = new HashSet<>();
		set.add("A");
		set.add("A");
		set.add("A");
		set.add("B");
		set.add("C");
		System.out.println(set);
	}

	private static void map() {
		System.out.println("\n\n=> Map \t\t===============================");

		Map<String, String> map = new HashMap<>();
		map.put("a", "AA");
		map.put("b", "BB");
		map.put("c", "CC");
		System.out.println(map);

		map.put("a", "X");
		System.out.println(map);

		System.out.println("a => " + map.get("a"));
		System.out.println("z => " + map.get("z"));
	}
}
