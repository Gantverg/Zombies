package zombies.utils;

import java.util.function.Predicate;

import zombies.Zombie;

public class ZombieLivePredicate implements Predicate<Zombie> {

	@Override
	public boolean test(Zombie zombie) {
		return zombie.getHealth() > 0;
	}

}
