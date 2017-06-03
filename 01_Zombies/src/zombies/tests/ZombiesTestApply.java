package zombies.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import zombies.Game;
import zombies.Zombie;

public class ZombiesTestApply {
	
	Game game;
	static final int LINE_1 = 1;
	static final int LINE_2 = 2;
	static final int MIDDLE = 5;
	static final int RIGHT = 0;
	static final int MIN_HEALTH = 1;
	static final int DEATH = 0;
	static final int HALF_HEALTH = Zombie.MAX_LIFE / 2;
	Zombie z1, z2, z3;
	
	@Before
	public void setUp() {
		game = new Game();
		z1 = new Zombie(LINE_1);
		z1.setX(MIDDLE);
		z1.setHealth(HALF_HEALTH - 1);
		game.add(z1);
		
		z2 = new Zombie(LINE_1);
		z2.setX(RIGHT);
		z2.setHealth(Zombie.MAX_LIFE);
		game.add(z2);
		
		z3 = new Zombie(LINE_2);
		z3.setX(MIDDLE - 1);
		z3.setHealth(DEATH);
		game.add(z3);
	}
	
	@Test
	public void testAsidingBomb() {
		int x = MIDDLE;
		int y = LINE_1;
		int r = 1;
		game.asidingBomb(x, y, r);
		assertEquals(MIDDLE - 1, 		z1.getX());
		assertEquals(HALF_HEALTH - 1,	z1.getHealth());
		assertEquals(RIGHT, 			z2.getX());
		assertEquals(Zombie.MAX_LIFE, 	z2.getHealth());
		assertEquals(MIDDLE - 2, 		z3.getX());
		assertEquals(DEATH,				z3.getHealth());
		x = RIGHT;
		y = LINE_1;
		r = 1;
		game.asidingBomb(x, y, r);
		assertEquals(MIDDLE - 1,		z1.getX());
		assertEquals(HALF_HEALTH - 1,	z1.getHealth());
		assertEquals(RIGHT,				z2.getX());
		assertEquals(DEATH,				z2.getHealth());
		assertEquals(MIDDLE - 2,		z3.getX());
		assertEquals(DEATH,				z3.getHealth());
	}
	
	@Test
	public void testFinishingBomb() {
		int x = MIDDLE;
		int y = LINE_1;
		int r = 1;
		game.finishingBomb(x, y, r);
		assertEquals(MIDDLE, 			z1.getX());
		assertEquals(DEATH, 			z1.getHealth());
		assertEquals(RIGHT, 			z2.getX());
		assertEquals(Zombie.MAX_LIFE, 	z2.getHealth());
		assertEquals(MIDDLE - 1, 		z3.getX());
		assertEquals(DEATH,				z3.getHealth());
		x = RIGHT;
		y = LINE_1;
		r = 1;
		game.finishingBomb(x, y, r);
		assertEquals(MIDDLE,			z1.getX());
		assertEquals(DEATH,				z1.getHealth());
		assertEquals(RIGHT,				z2.getX());
		assertEquals(Zombie.MAX_LIFE,	z2.getHealth());
		assertEquals(MIDDLE - 1,		z3.getX());
		assertEquals(DEATH,				z3.getHealth());
	}

	@Test
	public void testAsidingRay() {
		int y = LINE_1;
		game.asidingRay(y);
		assertEquals(MIDDLE - 1,		z1.getX());
		assertEquals(HALF_HEALTH - 1,	z1.getHealth());
		assertEquals(RIGHT, 			z2.getX());
		assertEquals(DEATH, 			z2.getHealth());
		assertEquals(MIDDLE - 1,		z3.getX());
		assertEquals(DEATH,				z3.getHealth());
		y = LINE_2;
		game.asidingRay(y);
		assertEquals(MIDDLE - 1,		z1.getX());
		assertEquals(HALF_HEALTH - 1,	z1.getHealth());
		assertEquals(RIGHT, 			z2.getX());
		assertEquals(DEATH, 			z2.getHealth());
		assertEquals(MIDDLE - 2, 		z3.getX());
		assertEquals(DEATH,				z3.getHealth());
	}

	@Test
	public void testFinishingRay() {
		int y = LINE_1;
		game.finishingRay(y);
		assertEquals(MIDDLE,			z1.getX());
		assertEquals(DEATH,				z1.getHealth());
		assertEquals(RIGHT, 			z2.getX());
		assertEquals(Zombie.MAX_LIFE, 	z2.getHealth());
		assertEquals(MIDDLE - 1, 		z3.getX());
		assertEquals(DEATH,				z3.getHealth());
		y = LINE_2;
		game.finishingRay(y);
		assertEquals(MIDDLE,			z1.getX());
		assertEquals(DEATH,				z1.getHealth());
		assertEquals(RIGHT, 			z2.getX());
		assertEquals(Zombie.MAX_LIFE, 	z2.getHealth());
		assertEquals(MIDDLE - 1, 		z3.getX());
		assertEquals(DEATH,				z3.getHealth());
	}
}
