import java.util.TreeSet;


public class Elevator extends GuestSpace implements Steppable {

	public static enum DIRECTION {INACTIVE, UP, DOWN};
	private int speed;	//Number of steps to move 1 unit
	private double location;  //Height in the elevator shaft
	private boolean doorsOpen;
	DIRECTION direction;
	TreeSet<Floor> destinations;
	
	public Elevator() {
		World.steppables.add(this);
		doorsOpen = false;
		destinations = new TreeSet<Floor>();
		location = 0;
		speed = 1;
	}
	
	public double getLocation() {
		return location;
	}
	
	public TreeSet<Floor> getDestinations() {
		return destinations;
	}
	
	public DIRECTION getDirection() {
		return direction;
	}
	
	public void addDestination(Floor floor) {
		destinations.add(floor);
	}
	
	public void setState(DIRECTION direction) {
		this.direction = direction;
	}
	
	public void toggleDoors() {
		if (!doorsOpen)
			doorsOpen = true;
		else doorsOpen = false;
	}
	
	public void move () {
		if (direction == DIRECTION.UP)
			location += 1.0/speed;
		else if (direction == DIRECTION.DOWN)
			location -= 1.0/speed;
	}
	
	public String toString() {
		return "" + getLocation();
	}
	
	public void step() {
		move();
		if (direction != DIRECTION.INACTIVE)
			adjacentSpace.clear();
		System.out.println(getLocation());
		System.out.println(getDirection());
		System.out.println(getDestinations());
	}
}
