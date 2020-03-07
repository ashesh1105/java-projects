package main.java.com.algorithms.puzzles;

class Base {
	protected int i;

	Base() {
		add(1);
	}

	int add(int v) {
		i += v;
		return i;
	}
}

class Extension extends Base {
	Extension() {
		add(1);
	}

	int add(int v) {
		i += v * 2;
		return i;
	}
}

public class Example {
	public static void main(String[] args) {
		/*
		 * The catch here is, when we create an object of Extension calls stack
		 * will be like this: Constructor Base() -> add(int v) method from
		 * Extension (and not from Base class!) -> Constructor Extension() ->
		 * add(int v) method from Extension class again
		 */
		System.out.println(" " + bogo(new Extension()));
	}

	static int bogo(Base b) {
		return b.add(8);
	}
}
