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
	
	public void add(Zombie zombie){
		zombies.add(zombie);
	}
	
	public boolean areAllDead(){
		Predicate<Zombie> isZombieLive = new ZombieLivePredicate();
		for(Zombie zombie : zombies){
			if(isZombieLive.test(zombie)) 
				return false; 
		}
		return true;
	}

	public boolean areZombiesWin(){
		Predicate<Zombie> isZombieWin = new ZombieWinPredicate();
		for(Zombie zombie : zombies){
			if(isZombieWin.test(zombie))
				return true;
		}
		return false;
	}
	
	public void attackFirst(int x, int y){
		Predicate<Zombie> isZombieAttackFirst = new ZombieAttackFirstPredicate(x, y);
		for(Zombie zombie : zombies){
			if(isZombieAttackFirst.test(zombie)){
				zombie.decHealth();
				return;
			}
		}
	}
	
	public void attackArrow(int y){
		int maxX = -1;
		Zombie zombieToAttack = null;
		Predicate<Zombie> isAttackArrow = new AttackArrowPredicate(y);
		
		for(Zombie zombie : zombies){
			if(isAttackArrow.test(zombie)){
				if(zombie.getX() > maxX){
					maxX = zombie.getX();
					zombieToAttack = zombie; 
				}
			}
		}
		
		if (zombieToAttack != null){
			zombieToAttack.decHealth();
		}
	}
	
	public Zombie findFirst(Predicate<Zombie> predicate){
		for(Zombie zombie : zombies){
			if(predicate.test(zombie))
				return zombie;
		}
		return null;
	}
}
