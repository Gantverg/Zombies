package zombies.utils;

import java.util.function.Predicate;

import zombies.Zombie;

public class ZombieLivePredicate implements Predicate<Zombie> {

	@Override
	public boolean test(Zombie zombie) {
		if (zombie.getHealth() > 0)
			return true;
		if (zombie.patronus != null){
			Predicate<Zombie> predicate = new ZombieLivePredicate();
			return predicate.test(zombie.patronus);
		}
		return false;
	}

}
