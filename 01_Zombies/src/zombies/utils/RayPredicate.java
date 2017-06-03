package zombies.utils;

import java.util.function.Predicate;

import zombies.Zombie;

public class RayPredicate implements Predicate<Zombie> {
	int y;
	
	public RayPredicate(int y) {
		super();
		this.y = y;
	}

	@Override
	public boolean test(Zombie zombie) {
		return zombie.getY() == y;
	}

}
