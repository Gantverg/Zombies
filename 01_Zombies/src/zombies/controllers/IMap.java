package zombies.controllers;

import zombies.Zombie;

/*
 * Карта (для постановки растений и не только)
 */
public interface IMap {
	
	//Тип поверхности в точке
	TerrainType getTerrainType(int x, int y);
	
	//Зомби в точке
	Zombie getZombie(int x, int y);
}
