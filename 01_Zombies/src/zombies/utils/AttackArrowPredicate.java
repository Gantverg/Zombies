package zombies.utils;

import java.util.function.Predicate;

import zombies.Zombie;

public class AttackArrowPredicate implements Predicate<Zombie> {
	int y;

	public AttackArrowPredicate(int y) {
		super();
		this.y = y;
	}

	@Override
	public boolean test(Zombie zombie) {
		return zombie.getY() == y;
	}

}
