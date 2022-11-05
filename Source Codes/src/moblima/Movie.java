package movieApp;

public class Movie {
	
	private String title;
	private String type;
	private String status;
	private String director;
	private String cast;
	private String synopsis;
	private String reviews;
	private int numrating;
	private float totalrating;
	private float overallrating;
	
	public Movie(String title, String type, String status, String director, String cast, String synopsis, String reviews) {
		this.title = title;
		this.type = type;
		this.status = status;
		this.director = director;
		this.cast = cast;
		this.synopsis = synopsis;
		this.reviews = reviews;
		this.numrating = 0;
		this.totalrating = 0;
		this.overallrating = 0;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

	public String getDirector() {
		return director;
	}

	public String getCast() {
		return cast;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public String getReviews() {
		return reviews;
	}
	
	public void setOverallrating(float viewrating) {
		this.totalrating = totalrating + viewrating;
		this.overallrating = totalrating / ++numrating;
	}

	public float getOverallrating() {
		return overallrating;
	}
	
}
