package moblima.model;
/**
 * Class represent cinema seat
 */
public class CinemaSeat {

	/**
	 * boolean for whether seat is assigned
	 */
	private boolean assigned;
	
	/**
	 * Constructor
	 */
	public CinemaSeat() {
		assigned = false;
	}s

	/**
	 * check if seat is assigned
	 * @return assigned boolean
	 */
	public boolean isAssigned() {
		return this.assigned;
	}

	/**
	 * Assigns seat, assigned = true
	 */
	public void assign() {
		this.assigned = true;
	}

	/**
	 * Unassign seat, assigned = false
	 */
	public void unAssign() {
		this.assigned = false;
	}

}