package jpd.hallt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import jpd.hallt.model.Actor;
import jpd.hallt.model.Warehouse;

public class Simulator
{
	// The private static final variables represent 
	// configuration information for the simulation.
	// The default width for the grid.
	private static final int DEFAULT_WIDTH = 10;
	// The default depth of the grid.
	private static final int DEFAULT_DEPTH = 10;
	// The probability that a fox will be created in any given grid position.
	private static final double FOX_CREATION_PROBABILITY = 0.02;
	// The probability that a rabbit will be created in any given grid position.
	private static final double RABBIT_CREATION_PROBABILITY = 0.08;    
	// The probability that a hunter will be created in any given grid position.
	private static final double HUNTER_CREATION_PROBABILITY = 0.01;
	
	// The list of actors in the field
	private List<Actor> actors;
	// The list of actors just born
	private List<Actor> newActors;
	// The current state of the field.
	private Warehouse warehouse;
	// A second field, used to build the next stage of the simulation.
	private Warehouse updatedwarehouse;
	// The current step of the simulation.
	private int step;
	
	
	/**
	 * Create a simulation and run it for a specified number of steps
	 */
	public static void main(String[] args) {
		int numSteps = 1;  // By default, run for 1 step
		if (args.length >= 1) {
			numSteps = Integer.parseInt(args[0]);
		}
		if (numSteps <= 0) 
			numSteps = 1;
		
		int seed = 42;  // By default, use a seed of 42
		if (args.length >= 2) {
			seed = Integer.parseInt(args[1]);
		}
		Simulator s = new Simulator(seed);
		
		s.simulate(numSteps);
	}
	
	/**
	 * Construct a simulation field with default size.
	 */
	public Simulator(int seed)
	{
		this(DEFAULT_DEPTH, DEFAULT_WIDTH, seed);
	}
	
	/**
	 * Create a simulation field with the given size.
	 * @param depth Depth of the field. Must be greater than zero.
	 * @param width Width of the field. Must be greater than zero.
	 */
	public Simulator(int depth, int width, int seed)
	{
		if(width <= 0 || depth <= 0) {
			System.out.println("The dimensions must be greater than zero.");
			System.out.println("Using default values.");
			depth = DEFAULT_DEPTH;
			width = DEFAULT_WIDTH;
		}
		actors = new ArrayList<Actor>();
		newActors = new ArrayList<Actor>();
		warehouse = new Warehouse(depth, width);
		warehouse = new Warehouse(depth, width);
	
	}
	
	/**
	 * Run the simulation from its current state for a reasonably long period,
	 * e.g. 500 steps.
	 */
	public void runLongSimulation()
	{
		simulate(500);
	}
	
	/**
	 * Run the simulation from its current state for the given number of steps.
	 * Stop before the given number of steps if it ceases to be viable.
	 */
	public void simulate(int numSteps)
	{
	}
	
	/**
	 * Run the simulation from its current state for a single step.
	 * Iterate over the whole field updating the state of each
	 * actor.
	 */
	//public void simulateOneStep()
	//{
		//step++;
		//newActors.clear();
		/**
		// let all actors act
		for(Iterator<Actor> iter = actors.iterator(); iter.hasNext(); ) {
			Actor actor = iter.next();
			if (actor.isAlive()) {
				actor.act(field, updatedField, newActors);
			}
			else {
				iter.remove();   // remove dead actors from collection
			}
		}
		// add new born actors to the list of actors
		actors.addAll(newActors);
		
		// Swap the field and updatedField at the end of the step.
		Field temp = field;
		field = updatedField;
		updatedField = temp;
		updatedField.clear();
		// All the counts need to be recalculated
		field.reset();  
		
		// display the new field on screen
		for (int i = 0; i < views.length; i++) {
			views[i].showStatus(step, field);
		}
	}
	
	/**
	 * Reset the simulation to a starting position.
	 * 
	 */
	
	public void reset(int seed)
	{
		step = 0;
		actors.clear();
		warehouse.clear();
		//warehouse.reset();
		
	
} 
	
}
