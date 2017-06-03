package zombies;

public class Zombie {
	private int x, y;
	private int health;
	public Zombie patronus;
	public static final int MAX_LIFE = 10;

	public Zombie(int y) {
		this.x = 0;
		this.y = y;
		this.health = MAX_LIFE;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @param health
	 *            the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	public void decHealth() {
		health--;
	}
}
