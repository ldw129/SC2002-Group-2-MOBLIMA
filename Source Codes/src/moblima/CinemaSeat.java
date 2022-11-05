package moblima;

public class CinemaSeat {

	private int row;
	private int col;
	private boolean assigned = false;
	private int customerID;
	private String rowS;
	private String seatID;

	
	//constructor for Cinema seat
	public CinemaSeat(int row, int col) {
		this.row = row;
		this.col = col;
		this.assigned = false;
		this.customerID = 0;
		
	}

	public String getSeatID() {
		switch(row){
			case 1:
				rowS = "A";
				break;
			case 2:
				rowS = "B";
				break;
			case 3:
				rowS = "C";
				break;
			case 4:
				rowS = "D";
				break;
			case 5:
				rowS = "E";
				break;
			case 6:
				rowS = "F";
				break;
			case 7:
				rowS = "G";
				break;
			case 8:
				rowS = "H";
				break;
			case 9:
				rowS = "J";
				break;

		}
		// get the seat ID
		seatID = rowS + this.col;
		return seatID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public boolean isAssigned() {
		return this.assigned;
	}

	public void assign(int cust_id) {
		this.customerID = cust_id;
		this.assigned = true;
	}

	public void unAssign() {
		this.assigned = false;
		this.customerID = 0;
	}

}