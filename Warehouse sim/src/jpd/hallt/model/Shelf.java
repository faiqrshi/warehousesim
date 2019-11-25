package jpd.hallt.model;

import java.util.List;

public class Shelf implements Actor {
	private int x, y;
	private Location location;
	private String id;
	
	public Shelf(int x, int y, String id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String getId() {
		return id;
	}
	
	public Location getLocation() {
		return location;
	}
	
    public void setLocation(Location location) {
    			this.location = location;
    }

	@Override
	public void act(Warehouse warehouse, Warehouse updatedWarehouse, List<Actor> newActors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLocation(int row, int col) {
		// TODO Auto-generated method stub
		
	}
}
