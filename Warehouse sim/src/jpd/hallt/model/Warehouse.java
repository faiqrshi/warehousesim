package jpd.hallt.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import jpd.hallt.model.Actor;
import jpd.hallt.model.Location;



public class Warehouse
{
	
	// The depth and width of the field.
	private int depth, width;
	// Storage for the actors.
	private Actor[][] warehouse;
	
	/**
	 * Represent a field of the given dimensions.
	 * @param depth The depth of the field.
	 * @param width The width of the field.
	 */
	public Warehouse(int depth, int width)
	{
		this.depth = depth;
		this.width = width;
		warehouse = new Actor[depth][width];
		
	}
	
	/**
	 * Empty the field.
	 */
	public void clear()
	{
		for(int row = 0; row < depth; row++) {
			for(int col = 0; col < width; col++) {
				warehouse[row][col] = null;
			}
		}
	}
	
	/**
	 * Place an actor at the given location.
	 * If there is already an actor at the location it will
	 * be lost.
	 * @param actor The actor to be placed.
	 * @param row Row coordinate of the location.
	 * @param col Column coordinate of the location.
	 */
	public void place(Actor actor, int row, int col)
	{
		place(actor, new Location(row, col));
	}
	
	/**
	 * Place an actor at the given location.
	 * If there is already an actor at the location it will
	 * be lost.
	 * @param actor The actor to be placed.
	 * @param location Where to place the actor.
	 */
	public void place(Actor actor, Location location)
	{
		warehouse[location.getRow()][location.getCol()] = actor;
	}
	
	/**
	 * Return the actor at the given location, if any.
	 * @param location Where in the field.
	 * @return The actor at the given location, or null if there is none.
	 */
	public Actor getObjectAt(Location location)
	{
		return getObjectAt(location.getRow(), location.getCol());
	}
	
	/**
	 * Return the actor at the given location, if any.
	 * @param row The desired row.
	 * @param col The desired column.
	 * @return The actor at the given location, or null if there is none.
	 */
	public Actor getObjectAt(int row, int col)
	{
		return warehouse[row][col];
	}
	
	/**
	 * @return The depth of the field.
	 */
	public int getDepth()
	{
		return depth;
	}
	
	/**
	 * @return The width of the field.
	 */
	public int getWidth()
	{
		return width;
	}
}

