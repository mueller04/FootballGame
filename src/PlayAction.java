import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PlayAction {
    final static int MAXIMUM_YARDS_TO_PUNT = 70;
    final static int MINIMUM_YARDS_TO_PUNT = 40;

    Posession posession;
    Team offense;
    Team defense;

    public PlayAction(Team offense, Team defense) {
        this.offense = offense;
        this.defense = defense;
    }

    void kickoff(){
        Random random = new Random();
        int yardsKicked = random.nextInt(MAXIMUM_YARDS_TO_PUNT - MINIMUM_YARDS_TO_PUNT) + MINIMUM_YARDS_TO_PUNT;

        offense.totalYardsUntilGoal = yardsKicked;
        System.out.println(offense.teamName + " received punt, " + offense.totalYardsUntilGoal + " to go");
    }

    void punt() {
        turnover();
        kickoff();
    }

    void play(){

        posession = new Posession();
        PlayResult.ResultType result;

        do  {

            try {
            Thread.sleep(2000);
            } catch (Exception e){
                System.out.println("Exception " + e);
            }

            result = posession.playPosession(offense, defense);

        } while (posession.down < 5 && result == PlayResult.ResultType.CONTINUE && !checkForTouchDown());

        if (result == PlayResult.ResultType.PUNT) {
            punt();
        } else if (result == PlayResult.ResultType.TURNOVERONDOWNS) {
            turnOverOnDowns();
        }
    }

    public void turnOverOnDowns() {
        System.out.println("Turnover On Downs at the " + offense.totalYardsUntilGoal + " yard line.\n");
        defense.totalYardsUntilGoal = 100 - offense.totalYardsUntilGoal;
        System.out.println(defense.teamName + " are starting with " + defense.totalYardsUntilGoal + " yards to go");
        turnover();

        try {
            Thread.sleep(2000);
        } catch (Exception e){
            System.out.println("Exception " + e);
        }
    }


    boolean checkForTouchDown(){

        if (offense.totalYardsUntilGoal <= 0){
            offense.score = offense.score + 6;

            System.out.println("TOUCHDOWN " + offense.teamName + "!\n");
            System.out.println(offense.teamName + " have " + offense.score + " points\n");
            punt();
            return true;
        } else {
            return false;
        }

    }

    void turnover() {

        Team temporary = this.defense;
        this.defense = offense;
        this.offense = temporary;
    }





}
