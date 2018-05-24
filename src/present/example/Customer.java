package present.example;

import java.util.ArrayList;

public class Customer {
	private ArrayList<Bid> bids = new ArrayList();
	
	public Customer() {
	}
	
	public void addBid(Bid recentBid) {
		bids.add(recentBid);
	}
	public ArrayList<Bid> getBidArrayList() {
		return bids;
	}
}
