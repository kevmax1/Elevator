
public class Guest implements Steppable {
	
	GuestSpace place;
	GuestSpace finalDestination;
	
	public Guest() {
		place = World.getBuilding().getFloors().get(0);
		World.steppables.add(this);
	}
	
	public Guest(GuestSpace destination) {
		place = World.getBuilding().getFloors().get(0);
		finalDestination = destination;
		World.steppables.add(this);
	}
	
	public void callElevator(Elevator.DIRECTION direction) {
		if (place instanceof Floor)
			World.getBuilding().getOperator().callElevator((Floor)place, direction);
	}
	
	public void callElevator(Floor floor) {
		if (place instanceof Elevator)
			((Elevator)place).addDestination(floor);
	}
	
	//Move the guest from current GuestSpace to destination GuestSpace
	public void enterSpace(GuestSpace destination) {
		if (place.adjacentSpace.contains(destination)) {
			place.guests.remove(this);
			destination.guests.add(this);
			place = destination;
		}
		else { 
			System.out.println("Error in program.  Cannot move between non-adjacent spaces.");
			System.exit(0);
		}
	}
	
	public void step() {
		
	}
	
}