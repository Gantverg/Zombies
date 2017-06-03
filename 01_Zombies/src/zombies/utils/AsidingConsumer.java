package zombies.utils;

import java.util.function.Consumer;

import zombies.Zombie;

public class AsidingConsumer implements Consumer<Zombie> {

	@Override
	public void accept(Zombie zombie) {
		int x_zombie = zombie.getX();
		x_zombie--;
		if (x_zombie > 0) {
			zombie.setX(x_zombie);
		} else {
			zombie.setHealth(0);
		}
	}

}
