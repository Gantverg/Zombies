package zombies.utils;

import java.util.function.Predicate;

import zombies.Zombie;

public class ZombieAttackFirstPredicate implements Predicate<Zombie> {
	int x,y;
	
	
	public ZombieAttackFirstPredicate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}


	@Override
	public boolean test(Zombie zombie) {
		return zombie.getX() == x && zombie.getY() == y;
	}

}
