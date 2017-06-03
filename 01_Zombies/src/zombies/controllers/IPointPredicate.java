package zombies.controllers;


//Проверяет клетку с координатами (x, y)	
public interface IPointPredicate {
	
boolean test(IMap map, int x, int y);

}
