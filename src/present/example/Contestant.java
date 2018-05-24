package present.example;

public class Contestant {
	private int place = 0;
	
	private String name = "";
	private String placeOfOrigin = "";
	
	private int wins = 0;
	private int losses = 0;
	
	private int yearsExperiance = 0;
	
	Contestant(String name, String placeOfOrigin, int wins, int losses, Integer yearsExperiance){
		this.name = name;
		this.placeOfOrigin = placeOfOrigin;
		
		this.wins = wins;
		this.losses = losses;
		
		if(yearsExperiance != null)
			this.yearsExperiance = yearsExperiance;
		else
			this.yearsExperiance = 0;
	}
	public String getName() {
		return name;
	}
	
	public int getPlace() {
		//if(placement == 0)
			//Error
		//else
			return place;
	}
	public void setPlace(int place) {
		//if(placement > 4 || placement < 1)
			//Error
		//else
			this.place = place;
	}
	public void printInformation() {
		switch(place) {
			case 0:
				System.out.println("Name:");
				System.out.println("\t"+name);
				System.out.println("From:");
				System.out.println("\t"+placeOfOrigin);
				System.out.println("Experiance:");
				System.out.println("\t"+yearsExperiance+" years.");
				System.out.println("Wins-Losses:");
				System.out.println("\t"+wins+"-"+losses);
				break;
			default:
				System.out.println("\t"+name);
		}
	}
}



