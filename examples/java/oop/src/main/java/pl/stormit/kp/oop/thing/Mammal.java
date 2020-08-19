package pl.stormit.kp.oop.thing;

import pl.stormit.kp.oop.Displayable;
import pl.stormit.kp.oop.Printable;

public abstract class Mammal extends LivingThing implements Displayable, Printable {

	@Override
	public String display() {
		return "Display: " + toString();
	}

	@Override
	public void print() {
		System.out.println("Print: " + this);
	}

	@Override
	public void saveToPdf() {
		System.out.println("saveToPdf: " + this);
	}
}
