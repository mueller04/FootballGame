import java.util.Random;

public class Play {


    int yardsUntilFirstDown = 10;


    void playDown(Team offense){

            int yardsGained = yardsGained();

            offense.totalYardsUntilGoal = offense.totalYardsUntilGoal - yardsGained;
            yardsUntilFirstDown = yardsUntilFirstDown - yardsGained;

            System.out.println(offense.teamName + " gained " + yardsGained + " yards");

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

}
