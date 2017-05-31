package zombies;

import java.util.function.Predicate;

import tel_ran.collections.Array;
import zombies.utils.AttackArrowPredicate;
import zombies.utils.ZombieAttackFirstPredicate;
import zombies.utils.ZombieLivePredicate;
import zombies.utils.ZombieWinPredicate;

public class Game {
	public static final int MAX_POSITION = 10;
	Array<Zombie> zombies;

	public Game() {
		zombies = new Array<>();
	}

	public void add(Zombie zombie) {
		zombies.add(zombie);
	}

	public boolean areAllDead() {
		Predicate<Zombie> isZombieLive = new ZombieLivePredicate();
		for (Zombie zombie : zombies) {
			if (isZombieLive.test(zombie))
				return false;
		}
		return true;
	}

	public boolean areZombiesWin() {
		Predicate<Zombie> isZombieWin = new ZombieWinPredicate();
		for (Zombie zombie : zombies) {
			if (isZombieWin.test(zombie))
				return true;
		}
		return false;
	}

	public void attackFirst(int x, int y) {
		Predicate<Zombie> isZombieAttackFirst = new ZombieAttackFirstPredicate(x, y);
		for (Zombie zombie : zombies) {
			Zombie zombieAttack = attakFirstWithPatronus(zombie, isZombieAttackFirst);
			if (zombieAttack != null) {
				zombieAttack.decHealth();
				return;
			}
		}
	}

	private Zombie attakFirstWithPatronus(Zombie zombie, Predicate<Zombie> isZombieAttackFirst) {
		if(isZombieAttackFirst.test(zombie))
			return zombie;
		if (zombie.patronus != null) {
			return attakFirstWithPatronus(zombie.patronus, isZombieAttackFirst);
		}

		return null;
	}

	public void attackArrow(int y) {
		int maxX = -1;
		Zombie zombieToAttack = null;
		Predicate<Zombie> isAttackArrow = new AttackArrowPredicate(y);

		for (Zombie zombie : zombies) {
			Zombie zombieToAttackWithPatronus = findAttackArrowWithPatronus(zombie, isAttackArrow);
			if (zombieToAttackWithPatronus != null){
				int currentX = zombieToAttackWithPatronus.getX();
				if (currentX > maxX) {
					maxX = currentX;
					zombieToAttack = zombieToAttackWithPatronus;
				}
			}
		}

		if (zombieToAttack != null) {
			zombieToAttack.decHealth();
		}
	}

	private Zombie findAttackArrowWithPatronus(Zombie zombie, Predicate<Zombie> isAttackArrow) {
		int maxX = -1;
		Zombie res = null;
		if (isAttackArrow.test(zombie)) {
			maxX = zombie.getX();
			res = zombie;
		}
		if (zombie.patronus != null){
			Zombie zombieWithPatronus = findAttackArrowWithPatronus(zombie.patronus, isAttackArrow);
			if(zombieWithPatronus.getX() > maxX){
				res = zombieWithPatronus;
			}
		}
		return res;
	}

	public Zombie findFirst(Predicate<Zombie> predicate) {
		for (Zombie zombie : zombies) {
			Zombie subZombie = findFirstZombieWithPatronus(zombie, predicate);
			if(subZombie != null)
				return subZombie;
		}
		return null;
	}

	private Zombie findFirstZombieWithPatronus(Zombie zombie, Predicate<Zombie> predicate) {
		if (predicate.test(zombie))
			return zombie;
		if(zombie.patronus != null) {
			return findFirstZombieWithPatronus(zombie.patronus, predicate);
		}
		return null;
	}
}
