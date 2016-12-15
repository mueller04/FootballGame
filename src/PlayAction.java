import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PlayAction {
    final static int MAXIMUM_YARDS_TO_PUNT = 70;
    final static int MINIMUM_YARDS_TO_PUNT = 40;

    Play play;

    Map<String, Team> coinToss(String teamName1, String teamName2){

        Team offense = new Team();
        Team defense = new Team();
        offense.teamName = "Browns";
        defense.teamName = "Steelers";

        Random random = new Random();
        int n = random.nextInt(10);
        if (n > 5) {
            System.out.println("team: " + offense.teamName + " have possession");

        } else {
            Team temporary = new Team();

            temporary = offense;

            offense = defense;

            defense = temporary;

            System.out.println("team: " + offense.teamName + " have possession");
        }

        Map<String, Team> teams = new HashMap<String, Team>();
        teams.put("OFFENSE", offense);
        teams.put("DEFENSE", defense);
        return teams;
    }

    void punt(Team offense){

        Random random = new Random();
        int yardsKicked = random.nextInt(MAXIMUM_YARDS_TO_PUNT - MINIMUM_YARDS_TO_PUNT) + MINIMUM_YARDS_TO_PUNT;

          offense.totalYardsUntilGoal = yardsKicked;
            System.out.println("team " + offense.teamName + " received punt, " + offense.totalYardsUntilGoal + " to go");
    }

    boolean play(Team offense){

        play = new Play();
        int down = 1;

        do  {
            play.playDown(offense);

            if (gotATouchDown(offense)) {
                return false;
            }

            if (gotTheFirstDown()) {
                return true;
            }

            down = down + 1;

        } while (down < 5);

            return false;

    }

    boolean gotTheFirstDown(){
        if (play.yardsUntilFirstDown <= 0) {
            play.yardsUntilFirstDown = 10;
            return true;
        }  else {
            return false;
        }
    }

    boolean gotATouchDown(Team offense){

        if (offense.totalYardsUntilGoal <= 0){
            offense.score = offense.score + 6;

            System.out.println(offense.teamName + " got a touch down");
            System.out.println(offense.teamName + " has " + offense.score + " points");

            return true;
        } else {
            return false;
        }
    }

    Map<String, Team> turnover(Team offense, Team defense) {
        Team temporary = new Team();

        temporary = offense;

        offense = defense;

        defense = temporary;

        Map<String, Team> teams = new HashMap<String, Team>();
        teams.put("OFFENSE", offense);
        teams.put("DEFENSE", defense);
        return teams;
    }

}
