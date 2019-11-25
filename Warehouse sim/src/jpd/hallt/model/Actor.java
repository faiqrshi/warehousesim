package jpd.hallt.model;

import java.util.List;

public interface Actor {

		public abstract void act(Warehouse warehouse, Warehouse updatedWarehouse, 
			     List<Actor> newActors);
   public abstract void setLocation(int row, int col);
}







   
   