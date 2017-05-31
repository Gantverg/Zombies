package zombies.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import zombies.Game;
import zombies.Zombie;

public class ZombiesTestPredicate {
	Game game;

	@Before
	public void setUp() throws Exception {
		game = new Game();
		game.add(new Zombie(1));
		game.add(new Zombie(2));
		game.add(new Zombie(3));
		game.add(new Zombie(1));
	}

	@Test
	public void testAllZombiesDead() {
		assertTrue(!game.areAllDead());
		game = new Game();
		assertTrue(game.areAllDead());
		Zombie zombie = new Zombie(1);
		game.add(zombie);
		zombie.setHealth(0);
		assertTrue(game.areAllDead());
	}

	@Test
	public void testAreZombieWin() {
		assertTrue(!game.areZombiesWin());
		game = new Game();
		assertTrue(!game.areZombiesWin());
		Zombie zombie = new Zombie(1);
		game.add(zombie);
		zombie.setX(Game.MAX_POSITION);
		game.add(new Zombie(2));
		assertTrue(game.areZombiesWin());
	}

	@Test
	public void testAttackFirst() {
		game = new Game();
		Zombie zombie1_1 = new Zombie(1);
		Zombie zombie1_2 = new Zombie(1);
		game.add(zombie1_1);
		game.add(zombie1_2);
		game.attackFirst(0, 1);
		assertEquals(9, zombie1_1.getHealth());
		assertEquals(10, zombie1_2.getHealth());
	}
	
	@Test
	public void testAttackArrow() {
		game = new Game();
		Zombie zombie1_1 = new Zombie(1);
		Zombie zombie1_2 = new Zombie(1);
		game.add(zombie1_1);
		game.add(zombie1_2);
		zombie1_2.setX(5);
		game.attackArrow(1);
		assertEquals(10, zombie1_1.getHealth());
		assertEquals(9, zombie1_2.getHealth());
	}
}
