package zombies.controllers;


//��������� ������ � ������������ (x, y)	
public interface IPointPredicate {
	
boolean test(IMap map, int x, int y);

}
