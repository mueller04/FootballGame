import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Posession {


    int yardsUntilFirstDown = 10;
    int down = 1;


    void playDown(Team offense){

            int yardsGained = yardsGained();

            offense.totalYardsUntilGoal = offense.totalYardsUntilGoal - yardsGained;
            yardsUntilFirstDown = yardsUntilFirstDown - yardsGained;

            System.out.println(offense.teamName + " gained " + yardsGained + " yards on the " + down + " down" );

            if (offense.totalYardsUntilGoal >= 0) {
                System.out.println(offense.totalYardsUntilGoal + " yards until goal\n");
            }

    }

    int yardsGained(){

        Random random = new Random();
        int n = random.nextInt(100);
        int yardsGained;


        if (n < 60) {
            yardsGained = random.nextInt(1);

        } else if (n >= 60 && n <= 85 ) {
            yardsGained = random.nextInt(15 - 5) + 5;


        } else if (n > 85 && n <= 95) {
            yardsGained = random.nextInt(25 - 10) + 10;

        } else {
            yardsGained = random.nextInt(100 - 35) + 35;
        }
        return yardsGained;

    }


    PlayResult.ResultType playPosession(Team offense, Team defense) {
        boolean chooseToPunt = false;

        if (down == 4) {
            chooseToPunt = goForIt(offense, defense);
            if (chooseToPunt) {
                return PlayResult.ResultType.PUNT;
            }

        }
            playDown(offense);


        if (!gotTheFirstDown(defense) && down >= 4) {

            return PlayResult.ResultType.TURNOVERONDOWNS;

        } else if (gotTheFirstDown(offense)) {

            yardsUntilFirstDown = 10;
            down = 1;
            System.out.println(offense.teamName + " GOT THE FIRST DOWN");

        } else {
            down = down + 1;
        }

        return PlayResult.ResultType.CONTINUE;

    }

    boolean gotTheFirstDown(Team offense){
        if (yardsUntilFirstDown <= 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean goForIt(Team offense, Team defense) {
        boolean chooseToPunt = false;

        System.out.println("\nIt's the 4th down, " + yardsUntilFirstDown + " to go");
        System.out.println("Press 0 to go for it, press 1 to punt");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();

        if (choice == 1) {
            chooseToPunt = true;
            System.out.println(offense.teamName + " opted to Punt");
        }

        return  chooseToPunt;
    }

}
