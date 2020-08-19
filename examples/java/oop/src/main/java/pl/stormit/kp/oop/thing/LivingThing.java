package pl.stormit.kp.oop.thing;

public abstract class LivingThing extends Thing {
	public int age;

	public LivingThing() {
		this(0);
	}

	public LivingThing(int age) {
		this.age = age;
	}

	public void incAge(){
		age++;
	}

	public int getAge() {
		return age;
	}
}
