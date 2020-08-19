package pl.stormit.kp.oop;

import pl.stormit.kp.oop.thing.Cat;
import pl.stormit.kp.oop.thing.LivingThing;

public class EncapsulationApp {
	public static void main(String[] args) {
		LivingThing cat = new Cat();
		cat.incAge(); //+1 => 1
		cat.incAge(); //+1 => 2

		cat.age = -10;

		System.out.println(cat.getAge());
	}
}
