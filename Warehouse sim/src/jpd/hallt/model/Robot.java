package jpd.hallt.model;

import java.util.List;

import javafx.fxml.FXML;

public class Robot implements Actor{
	private String id;
	private int x, y;
	private double capacity, chargeSpeed, batteryLevel;
	private boolean active;
	private Location location;
	private int tick;
	
	public Robot(String id, int x, int y, double capacity, double chargeSpeed) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.capacity = capacity;
		this.chargeSpeed = chargeSpeed;
	}
	
	public Boolean isActive() {
		if (batteryLevel == 0) {
			return false;
		}
		return true;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public double getCapacity() {
		return capacity;
	}
	
	public double getChargeSpeed() {
		return chargeSpeed;
		
	}
	
	public double batteryLevel() {
		return batteryLevel;
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
	
	public void charge() {
		
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


