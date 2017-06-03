package zombies.utils;

import java.util.function.Predicate;

import zombies.Zombie;

public class BombPredicate implements Predicate<Zombie> {
	int x,y,r;
	
	public BombPredicate(int x, int y, int r) {
		super();
		this.x = x;
		this.y = y;
		this.r = r;
	}

	@Override
	public boolean test(Zombie zombie) {
		int x_zombie = zombie.getX();
		int y_zombie = zombie.getY();
		if((x - r <= x_zombie) && (x + r >= x_zombie) && (y - r <= y_zombie) && (y + r >= y_zombie)) {
			return true;
		} else {
			return false;
		}
	}

}
