import java.util.Map;

public class Application {

    public static void main(String[] args) {

        //declare variables
        Team offense;
        Team defense;

        PlayAction playAction = new PlayAction();

        //set values
        Map<String, Team> teamList = playAction.coinToss("browns", "steelers");
        offense = teamList.get("OFFENSE");
        defense = teamList.get("DEFENSE");

        boolean gameOver = false;
        while (!gameOver) {

            if (offense.score < 30 || defense.score < 30) {

                playAction.punt(offense);

                boolean stillHasPossession = true;

                while (stillHasPossession == true) {
                    stillHasPossession = playAction.play(offense);
                }

                teamList = playAction.turnover(offense, defense);
                offense = teamList.get("OFFENSE");
                defense = teamList.get("DEFENSE");

            } else {
                gameOver = true;
                System.out.println("The Game is Over");
            }
        }
    }

}



