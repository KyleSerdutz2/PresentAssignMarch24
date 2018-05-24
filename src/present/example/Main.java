package present.example;

//import java.util.AbstractCollection.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

import java.util.TreeSet;
import java.util.Comparator;

import java.util.Iterator; //Looping through Collections
import java.util.Map;
import java.util.Random; //Determining who wins

import java.util.Scanner; //Input as bids

public class Main {
	public static void main(String[] args) {
		
		/*NOTE THIS CLASS DOES NOT HAVE ERROR HANDLING WHATSOEVER*/
		//Please enter all values correctly: IE ints and chars
		
		System.out.println("");
		System.out.println("-----------");
		System.out.println("");
		
		/* 1) Hardcode the Contestants */
		
		HashMap<String, Contestant> contestants = new HashMap<String, Contestant>();
		contestants.put("Ben", new Contestant("Ben", "USA", 	50, 	50, 	20	));
		contestants.put("Ken", new Contestant("Ken", "JAP", 	7, 		7, 		7	));
		contestants.put("Jen", new Contestant("Jen", "SWE", 	20, 	10, 	5	));
		contestants.put("Len", new Contestant("Len", "CAN", 	2, 		8, 		1	));

		System.out.println("---");
		Iterator<Map.Entry<String, Contestant>> it = contestants.entrySet().iterator();
		while (it.hasNext()) {
		    Map.Entry<String, Contestant> pair = it.next();
		    
		    pair.getValue().printInformation();
			System.out.println("---");
		}
		
		System.out.println("");
		System.out.println("-----------");
		System.out.println("");
		
		/* 2) Get Bids */
		
		boolean biddingDone = false;
		
		HashMap<String, Customer> customers = new HashMap(); //Name as Key
		
		Scanner reader = new Scanner(System.in);
		while(!biddingDone) {
			System.out.println("Wanna make a bid? y/n: ");
			char yn = reader.next().charAt(0);
			if(yn == 'n') {
				biddingDone = true;
			} else if(yn == 'y') {
				System.out.println("Your Name Please: ");
				String name = reader.next(); //Customer's Name
				if(!customers.isEmpty()) {
					if(!customers.containsKey(name)) {
						customers.put(name, new Customer());
					}
				}else{
					customers.put(name, new Customer());
				}
				String contesterName = null;
				int bidAmount = 0;
				
				boolean done = false;
				while(!done){
					System.out.println("Who are you betting on?: ");
					contesterName = reader.next();
					
					if(contestants.containsKey(contesterName)) {
						done = true;
					}
				}
				System.out.println("How many dollars would you like to bet?: ");
				bidAmount = Character. getNumericValue(reader.next().charAt(0)); // Scans the next token of the input as an int.
				
				customers.get(name).addBid(new Bid(contesterName, bidAmount));
			} else {
				//Just keep looping!
				//Possible error handling in future
			}
		}
		reader.close();
		
		System.out.println("");
		System.out.println("-----------");
		System.out.println("");
		
		/* 3) Go through Game */
		
		System.out.println("The game begins!");
		System.out.println("...");
		
		//
		HashSet<String> crowd = new HashSet();
		crowd.add("Terry");
		crowd.add("Harry");
		crowd.add("Barry");
		crowd.add("Sherry");
		crowd.add("Kerry");
		crowd.add("Perry");
		crowd.add("Zerry");
		crowd.add("Lerry");
		crowd.add("Fairy");
		crowd.add("Very");
		crowd.add("Glarey");
		crowd.add("Starey");
		crowd.add("Hairy");
		crowd.add("Vary");
		crowd.add("Mary");
		
		int size = crowd.size();
		int personID = new Random().nextInt(size);
		int incID = 0;
		for(String person : crowd)
		{
			//Might be inefficient but camera doesn't have to move that often
			if (incID == personID) {
				System.out.println("The camera focuses on a random person... It's...");
				System.out.println("\t"+ person +"\n");
			}
			incID++;
		}
		System.out.println("...");
		
		//Determine Winners
		Random rand = new Random();
		int[] places = new int[4];

		places[0] = rand.nextInt(4) + 1;
		//4 is the maximum and the 1 is our minimum
		places[1] = places[0];
		places[2] = places[0];
		places[3] = places[0];
		while((places[1] == places[0]))
			places[1] = rand.nextInt(4) + 1;
		while((places[2] == places[0]) || (places[2] == places[1]))
			places[2] = rand.nextInt(4) + 1;
		while((places[3] == places[0]) || (places[3] == places[1]) || (places[3] == places[2]))
			places[3] = rand.nextInt(4) + 1;
		
		//Setting to Contestants
		int i = 0;
		Iterator<Map.Entry<String, Contestant>> it2 = contestants.entrySet().iterator();
		while (it2.hasNext()) {
		    Map.Entry<String, Contestant> pair = it2.next();

		    pair.getValue().setPlace(places[i]);
		    i++;
		}
		
		System.out.println("It's all over now!");
		
		/* 4) Setting winners */
		
		TreeSet<Contestant> winners = new TreeSet<Contestant>(new Comparator<Contestant>() {
			public int compare(Contestant a, Contestant b) {
				if(a.equals(b)){
					return 0;
				}else if (a.getPlace() > b.getPlace()){
					return 1;
				}else
					return -1;
			}
		});
		
		Iterator<Map.Entry<String, Contestant>> it3 = contestants.entrySet().iterator();
		while (it3.hasNext()) {		    
			Map.Entry<String, Contestant> pair = it3.next();
			
		    winners.add(pair.getValue());
		}
			
		
		System.out.println("");
		System.out.println("-----------");
		System.out.println("");
		
		/* 5) Displays Winners */
		
		Iterator<Contestant> winItr = winners.iterator();
	    while(winItr.hasNext()){
	    	Contestant current = winItr.next();
	    	switch(current.getPlace()) {
	    	case 1:
	    		System.out.println(current.getPlace() + "st Place!:");
	    		break;
	    	case 2:
		    	System.out.println(current.getPlace() + "nd Place!:");
	    		break;
	    	case 3:
		    	System.out.println(current.getPlace() + "rd Place!:");
	    		break;
	    	case 4:
		    	System.out.println(current.getPlace() + "th Place!:");
	    		break;
	    	}
	    	current.printInformation();
	    	
	    }
	    
	    System.out.println("");
		System.out.println("-----------");
		System.out.println("");

		System.out.println("Please come collect any winnings at booth!");
		/*
		Scanner reader2 = new Scanner(System.in);
		if(!customers.isEmpty()) {
			System.out.println("---");
			boolean hasEnteredMyself = false;
			System.out.println("Who might you be?: ");
			String me = reader2.nextLine();
			
			System.out.println("Who might you be?: ");
		}
		reader2.close();
		*/
	}
}
