import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);

    /********************
     * User Input Methods*
     ********************/
    public static int getNumBatters() {
        System.out.println("Enter number of players: ");
        int numBatters = getValidInteger();
        return numBatters;
    }

    public static int getAtBat() {
        System.out.println("Enter number of times at bat: ");
        int atBat = getValidInteger();
        return atBat;
    }

    public static int getnumBases() {
        System.out.println("0 = Strikeout, 1 = Single, 2 = Double, 3 = Triple, 4 = Home-run");
        System.out.println("Enter number of bases: ");
        int numBases = getValidInteger(-1, 5);
        return numBases;
    }

    /*******************
     *Validation Methods*
     *******************/
    public static int getValidInteger() {
        Scanner scan1 = new Scanner(System.in);
        //validation for numbers
        while (!scan1.hasNextInt()) {
            scan1.nextLine(); //clears the buffer
            System.out.println("Please enter an integer! "); //tells user to enter number
        }
        return scan1.nextInt(); //takes the correct integer
    }

    public static boolean checkRange(int input, int min, int max) {
        if (input <= min || input >= max) {
            return false;
        }
        return true;
    }

    public static int getValidInteger(int min, int max) {
        int userInput = getValidInteger();
        while (checkRange(userInput, min, max) == false) {
            System.out.println("Please provide a number within range!");
            userInput = getValidInteger();
        }
        return userInput;
    }

    public static void main(String[] args) {
        double battAvg = 0;
        int basesCount = 0;
        int[][] batterStats;
        int sum = 0;
        int atBat = 0;
        double slugPerc = 0;


        System.out.println("WELCOME TO BATTING STATS CALCULATOR!");
        batterStats = new int[getNumBatters()][];
        for (int i = 0; i < batterStats.length; i++) {
            atBat = getAtBat();
            batterStats[i] = new int[atBat];
            for (int j = 0; j < batterStats[i].length; j++) {
                basesCount = basesCount + getnumBases();
                sum = sum + batterStats[i][j];
            }
            battAvg = (double) basesCount / (double) atBat;
            slugPerc = (double) sum / (double) atBat;

        }
        for (int i = 0; i < batterStats.length; i++) {
            System.out.println("Batting avg for Player " + batterStats[i] + "is: " + battAvg);
            System.out.println("and the ");
            System.out.println("Slug Percentage for Player " + batterStats[i] + "is: " + slugPerc);

        }
    }

}
