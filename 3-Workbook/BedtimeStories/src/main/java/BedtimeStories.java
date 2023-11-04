import java.io.FileInputStream;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {
        bedTimeStories();
    }

    public static void bedTimeStories() {
        String userChoice;
        Scanner storySelect = new Scanner(System.in);

        System.out.println("Please choose a bedtime story: \n 1) Goldilocks \n 2) Hansel and Gretel \n 3) Mary had a Little Lamb");
        int story = storySelect.nextInt();

        if (story == 1) {
            try {

                FileInputStream fis = new FileInputStream("src/main/resources/DataFiles/goldilocks.txt");
                Scanner scanner = new Scanner(fis);

                while (scanner.hasNextLine()) {
                    userChoice = scanner.nextLine();
                    System.out.println(userChoice);
                }
                scanner.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        } else if (story == 2) {
            try {

                FileInputStream fis = new FileInputStream("src/main/resources/DataFiles/hansel_and_gretel.txt");
                Scanner scanner = new Scanner(fis);

                while (scanner.hasNextLine()) {
                    userChoice = scanner.nextLine();
                    System.out.println(userChoice);
                }
                scanner.close();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else if (story == 3) {
            try {

                FileInputStream fis = new FileInputStream("src/main/resources/DataFiles/mary_had_a_little_lamb.txt");
                Scanner scanner = new Scanner(fis);

                while (scanner.hasNextLine()) {
                    userChoice = scanner.nextLine();
                    System.out.println(userChoice);
                }
                scanner.close();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
