package zombies.utils;

import java.util.function.Consumer;

import zombies.Zombie;

public class FinishingConsumer implements Consumer<Zombie> {

	@Override
	public void accept(Zombie zombie) {
		if (zombie.getHealth() < Zombie.MAX_LIFE / 2) {
			zombie.setHealth(0);
		}
	}

}
