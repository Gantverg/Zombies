package zombies.controllers;

import zombies.Zombie;

/*
 * ����� (��� ���������� �������� � �� ������)
 */
public interface IMap {
	
	//��� ����������� � �����
	TerrainType getTerrainType(int x, int y);
	
	//����� � �����
	Zombie getZombie(int x, int y);
}
