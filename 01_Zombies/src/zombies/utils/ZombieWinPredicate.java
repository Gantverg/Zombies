package zombies.utils;

import java.util.function.Predicate;

import zombies.Game;
import zombies.Zombie;

public class ZombieWinPredicate implements Predicate<Zombie> {

	@Override
	public boolean test(Zombie zombie) {
		return (zombie.getX() == Game.MAX_POSITION);
	}

}
