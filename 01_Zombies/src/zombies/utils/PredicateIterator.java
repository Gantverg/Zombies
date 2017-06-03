package zombies.utils;

import java.util.Iterator;
import java.util.function.Predicate;

import tel_ran.collections.Array;
import zombies.Zombie;

public class PredicateIterator implements Iterator<Zombie> {
	private int current;
	private Array<Zombie> zombies;
	private Predicate<Zombie> predicate;
	final static Predicate<Zombie> predicateTrue = new PredicateTrue();

	public PredicateIterator(int current, Array<Zombie> zombies, Predicate<Zombie> predicate) {
		this.predicate = predicate == null ? predicateTrue : predicate;
		this.zombies = zombies;
		this.current = getNext(current);
	}
	
	public PredicateIterator(Array<Zombie> zombies, Predicate<Zombie> predicate) {
		this(0, zombies, predicate);
	}

	private int getNext(int i) {
		while (i < zombies.size() && !predicate.test(zombies.get(i))) {
			i++;
		};
		return i;
	}

	@Override
	public boolean hasNext() {
		return current < zombies.size();
	}

	@Override
	public Zombie next() {
		if (!hasNext()) {
			return null;
		}
		Zombie res = zombies.get(current);
		current = getNext(current + 1);
		return res;
	}
}
