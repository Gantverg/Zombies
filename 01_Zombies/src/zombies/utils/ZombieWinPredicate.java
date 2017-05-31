package zombies.utils;

import java.util.function.Predicate;

import zombies.Game;
import zombies.Zombie;

public class ZombieWinPredicate implements Predicate<Zombie> {

	@Override
	public boolean test(Zombie zombie) {
		if (zombie.getX() == Game.MAX_POSITION)
			return true;
		if (zombie.patronus != null){
			Predicate<Zombie> predicate = new ZombieWinPredicate();
			return predicate.test(zombie.patronus);
		}
		return false;
	}

}
