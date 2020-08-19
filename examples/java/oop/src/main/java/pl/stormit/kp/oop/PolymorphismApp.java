package pl.stormit.kp.oop;

import pl.stormit.kp.oop.thing.Cat;
import pl.stormit.kp.oop.thing.Dog;
import pl.stormit.kp.oop.thing.Thing;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismApp {
	public static void main(String[] args) {
		Cat cat = new Cat();

		cat.print();
		cat.display();
		cat.getAge();

		Thing thing = cat;
		thing.toString();

		Displayable displayable = cat;
		displayable.display();

		List<Printable> printables = new ArrayList<>();
		printables.add(new Cat());
		printables.add(new Dog());

		for(Printable printable : printables){
			printable.print();
		}
	}
}
