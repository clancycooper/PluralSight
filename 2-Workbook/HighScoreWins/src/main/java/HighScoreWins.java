import java.util.Scanner;

public class HighScoreWins {
    public static void main(String[] args) {
        System.out.println("Please enter your information as Home:Visitor|00:00 below");
        Scanner highScore = new Scanner(System.in);
        String scores = highScore.nextLine();

        String[] findTeams = scores.split("\\|");
        String[] findScores = findTeams[0].split("\\:");
        String[] findPoints = findTeams[1].split("\\:");

        if(Integer.parseInt(findPoints[0]) > Integer.parseInt(findPoints[1])){
            System.out.println("The winner is " + findScores[0]);
        }
        else {
            System.out.println("The winner is " + findScores[1]);
        }
    }
}
