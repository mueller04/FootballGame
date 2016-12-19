import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Application {

    public static void main(String[] args) {

        //declare variables
        Team offense;
        Team defense;

        //set values
        Map<String, Team> teamList = coinToss("browns", "steelers");

        offense = teamList.get("OFFENSE");
        defense = teamList.get("DEFENSE");

        PlayAction playAction = new PlayAction(offense, defense);

        boolean gameOver = false;

        playAction.punt();

        while (!gameOver) {

            if (offense.score < 30 || defense.score < 30) {

                playAction.play();

            } else {
                gameOver = true;
                System.out.println("The Game is Over");
            }
        }
    }


    static Map<String, Team> coinToss(String teamName1, String teamName2){
        Map<String, Team> teams = new HashMap<String, Team>();

        Team offense = new Team();
        Team defense = new Team();
        offense.teamName = "Browns";
        defense.teamName = "Steelers";

        Random random = new Random();
        int n = random.nextInt(10);

        if (n > 5) {
            teams.put("OFFENSE", offense);
            teams.put("DEFENSE", defense);
            System.out.println("team: " + offense.teamName + " won the toss and choose to receive punt");

        } else {
            teams.put("OFFENSE", defense);
            teams.put("DEFENSE", offense);

            System.out.println("team: " + defense.teamName + " won the toss and choose to receive punt");
        }

        return teams;
    }

}



