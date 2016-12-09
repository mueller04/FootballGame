import java.util.Random;

public class PlayAction {
    final static int MAXIMUM_YARDS_TO_PUNT = 70;
    final static int MINIMUM_YARDS_TO_PUNT = 40;


    void coinToss(Team team1, Team team2){

        Random random = new Random();
        int n = random.nextInt(10);
        if (n > 5) {
            team1.hasPosession = true;
            System.out.println("team: " + team1.teamName + " have possession");

        } else {
            team2.hasPosession = true;
            System.out.println("team: " + team2.teamName + " have possession");
        }
    }

    void punt(Team team1, Team team2){


        Random random = new Random();
        int yardsKicked = random.nextInt(MAXIMUM_YARDS_TO_PUNT - MINIMUM_YARDS_TO_PUNT) + MINIMUM_YARDS_TO_PUNT;

        if (team1.hasPosession){
          team1.totalYardsUntilGoal = yardsKicked;
            System.out.println("team " + team1.teamName + " received punt, " + team1.totalYardsUntilGoal + " to go");
        } else {
            team2.totalYardsUntilGoal = yardsKicked;
            System.out.println("team " + team2.teamName + " received punt, " + team2.totalYardsUntilGoal + " to go");
        }
    }



}
