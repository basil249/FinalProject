import java.util.ArrayList;


/*
 * Start testing here
 */
public class BackEndMain {
	
	public static void main(String[] args)
	
	{
		FileInitializer fz = new FileInitializer();
		ArrayList<Team> CONCACAF = fz.getRegionTeams("CONCACAF");
		ArrayList<Team> AFC = fz.getRegionTeams("AFC");
		ArrayList<Team> UEFA = fz.getRegionTeams("UEFA");
		ArrayList<Team> CAF = fz.getRegionTeams("CAF");
		ArrayList<Team> OFC = fz.getRegionTeams("OFC");
		ArrayList<Team> CONMEBOL = fz.getRegionTeams("CONMEBOL");
		
		League concacafLeague = new League (CONCACAF);
		concacafLeague.simulateQualifiers();
		concacafLeague.getSortedTeams();
		concacafLeague.getTournamentScore();
		System.out.println(fz.toString());
		/*
		 * Feel free to test these leagues out too, commented them out to only show one league test
		 * but hey if it works for one it should work for all....right?
		 */
		
		
		/*League afcLeague = new League(AFC);
		afcLeague.simulateQualifiers();
		
		League uefaLeague = new League(UEFA);
		uefaLeague.simulateQualifiers();
		
		League cafLeague = new League(CAF);
		cafLeague.simulateQualifiers();
		
		League ofcLeague = new League(OFC);
		ofcLeague.simulateQualifiers();
		
		League conmebolLeague = new League(CONMEBOL);
		conmebolLeague.simulateQualifiers(); */
		
		
		
	}
}
