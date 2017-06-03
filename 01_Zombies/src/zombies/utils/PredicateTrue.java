package zombies.utils;

import java.util.function.Predicate;

import zombies.Zombie;

public class PredicateTrue implements Predicate<Zombie> {

	@Override
	public boolean test(Zombie zombie) {
		return true;
	}

	
}
