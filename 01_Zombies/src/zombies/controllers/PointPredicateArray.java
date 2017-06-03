package zombies.controllers;

import tel_ran.collections.Array;

public class PointPredicateArray implements IPointPredicate{

	@Override
	public boolean test(IMap map, int x, int y) {
		for (IPointPredicate p : predicates )
		{
			if (!p.test(map, x, y))
				return false;
		}
		return true;
	}

	void add(IPointPredicate p)
	{
		predicates.add(p);
	}
	Array<IPointPredicate> predicates = new Array<IPointPredicate>();
}
