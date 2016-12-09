
public class Application {

    public static void main(String[] args) {

        //declare variables
        Team team1 = new Team();
        Team team2 = new Team();
        PlayAction playAction = new PlayAction();

        //set values
        team1.teamName = "browns";
        team2.teamName = "steelers";


        playAction.coinToss(team1, team2);

        playAction.punt(team1, team2);


    }

}
