package moblima.model;

public class Cinema {

	private String cinema_name;
	private String cinema_class;
	private int cinemaID;
	private String[] showtime;
	private Movie[] movie;
	// seating information
	private int numEmptySeat;
	private CinemaSeat[][] seat;
	private final int numofSeat = 162;
	private int row = 9;
	private int col = 16;
	private String[] rowL = {"A","B","C","D","E","F","G","H","J"}; //rows
	private String[] colL = {" "," 1 "," 2 "," 3 "," 4 "," 5 "," 6 "," 7 "," 8 "," 9 "," 10 ","11 ","12 ","13 ","14 ","15 ","16 "}; //columns
	
	//constructor
	public Cinema() {
		seat = new CinemaSeat[row][col];
		movie = new Movie[3];
		showtime = new String[3];
		this.numEmptySeat = numofSeat;
		for(int i = 0; i<row;i++){
			for(int j =0; j<col; j++){
				this.seat[i][j] = new CinemaSeat(i,j);
			}
		}
	}

	public void shownumEmptySeat() {
		System.out.println("Total number of seats left: "+ numEmptySeat);
	}


	//print out all the seats but i haven do according to the appendix yet
	public void showEmptySeat() {
		for(int k = 0; k<colL.length; k++){
			System.out.print(colL[k]);
		}
		System.out.println("");
		for(int i = 0; i<row;i++){
			System.out.print(rowL[i]+"|");
			for(int j =0; j<col; j++){
				if(this.seat[i][j].isAssigned()){
					System.out.print("+ |");
				}else{
					System.out.print("- |");
				}
			}
			System.out.println("");
		}
	}

	//assign seat
	public void assignSeat(int r,int c, int customerId){
		if(this.seat[r][c].isAssigned()){
			System.out.println("Seat is already assigned");
		}else{
			this.seat[r][c].assign(customerId);
			--numEmptySeat;
			//System.out.println(this.seat[r][c].isAssigned());
			System.out.println("Seat Assigned");
		}

	}

	public void showassignseat(){
		for(int i = 0; i<row;i++){
			for(int j =0; j<col; j++){
				if(this.seat[i][j].isAssigned()){
					System.out.println(this.seat[i][j].getSeatID());
				}
			}
		}
		
	}

	//array of movie
	public void setMovie(Movie movie) {
		for(int i = 0; i<3;i++){
			if(this.movie[i]==null){
				this.movie[i]=movie;
				break;
			}else{
				continue;
			}
		}
	}

	public String getMovie(int i) {
		return this.movie[i].getMovieName();
	}


	public String getShowtime(int i) {
		return this.showtime[i];
	}

	
	public void setShowtime(String showtime) {
		for(int i = 0; i<3;i++){
			if(this.showtime[i]==null){
				this.showtime[i]=showtime;
				break;
			}else{
				continue;
			}
		}
	}

	

}