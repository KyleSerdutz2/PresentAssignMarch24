package present.example;

public class Bid {
	private String contestantName;
	private int bidDollars;
	
	Bid(){
		
	}
	
	Bid(String name, int amount){
		contestantName = name;
		bidDollars = amount;
	}
	
	public void setContestantName(Contestant contestant) {
		contestantName = contestant.getName();
	}
	
	public void setContestantName(String name) {
		contestantName = name;
	}
	
	public String getContestantName() {
		return contestantName;
	}
	
	
	public void bidDollars(int bidAmount) {
		bidDollars = bidAmount;
	}
	
	public int bidDollars() {
		return bidDollars;
	}
}
