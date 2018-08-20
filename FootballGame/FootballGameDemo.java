import java.util.Scanner;

public class FootballGameDemo {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		String homeTeam, visitorTeam;
		int scoringEvent,team;
		
		System.out.print("Please enter home team name: ");
		homeTeam = scnr.nextLine();
		System.out.print("Please enter visitor team name: ");
		visitorTeam = scnr.nextLine();
		
		FootballGame game = new FootballGame(homeTeam, visitorTeam);
		
		do {
			System.out.print("\nEnter Scoring Event(or -1 to end game):\n"+
					"1) To score touchdown\n"+
					"2) To score extra point\n"+
					"3) To score conversion\n" + 
					"4) To score field goal\n" + 
					"5) To score safety\n>>");
			
			scoringEvent = scnr.nextInt();
			if(scoringEvent == -1) {
				scnr.close();
				System.exit(0);
			}
			else if (scoringEvent > 5 || scoringEvent<-1)
				continue;
			System.out.print("Enter Team:\n" + 
					"\n" + 
					"1) For " + homeTeam +" (home)\n" + 
					"2) For "+ visitorTeam+" (visitor)\n" + 
					"\n" + 
					">>");
			team = scnr.nextInt();
			switch(scoringEvent) {
			case 1: //touchDown
				game.scoreTouchdown(((team==1? homeTeam: visitorTeam)));
				break;
			case 2: // ExtraPoint
				game.scoreExtraPoint(((team==1? homeTeam: visitorTeam)));
				break;
			case 3: // conversion
				game.scoreConversion(((team==1? homeTeam: visitorTeam)));
				break;
			case 4: // field goal
				game.scoreFieldGoal(((team==1? homeTeam: visitorTeam)));
				break;
			case 5: // safety
				game.scoreSafety(((team==1? homeTeam: visitorTeam)));
				break;
				default:
					continue;
				
			}
			System.out.println(game);
			
		} while(scoringEvent!=-1);
		
		

	}

}
