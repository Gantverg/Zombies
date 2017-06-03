package zombies.controllers;


public interface IPlantController {
	IPointPredicate getPointPredicate();
	IDrawing		getDrawing();
	boolean			createPlant(IMap map, int x, int y);
}
