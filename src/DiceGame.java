import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

// Write a Java program that mimics a dice game is for a user to first roll four dice, if the answer to this roll is a 7,11,15,21 the user wins from sum of 4 dice. If they roll a 10,12,19, 20,22,23 ,24 the user loses.
// if the user rolls any other number, that number becomes the goal number and they must roll it again to win.
// If the user rolls 13 he loses.

public class DiceGame {
         SecureRandom secureRandom = new SecureRandom();
     public void RunGame() {
         int diceSum = IntStream.of(secureRandom.ints(4, 1, 7).toArray()).sum();
         System.out.println("You got: "+diceSum);
         switch (WinType(diceSum)) {
             case 0:
                 System.out.println("You win! :)");
                 break;
             case 1:
                 System.out.println("You lose! :(");
                 break;
             case -1:
                 System.out.println("You gotta try again!");
                 NotDeterminedLoop(diceSum);
                 break;
         }
     }

    public void NotDeterminedLoop(int goal) {
        while (true) {
            int diceSum = IntStream.of(secureRandom.ints(4, 1, 7).toArray()).sum();

            System.out.println("You got: "+diceSum);
            if (diceSum == 13) {
                System.out.println("You lose!");
                return;
            } else if (diceSum == goal) {
                System.out.println("You win!");
                return;
            } else {
                System.out.println("You got it wrong, try again!");
            }
        }
    }

    public int WinType(int diceSum) {
        int[] winNumbers = {7, 11, 15, 21};
        int[] loseNumbers = {10, 12, 13, 19, 20, 22, 23, 24};

        if (Arrays.stream(winNumbers).anyMatch(x -> x == diceSum)) {
            return 0;
        } else if (Arrays.stream(loseNumbers).anyMatch(x -> x == diceSum)) {
            return 1;
        } else {
            return -1;
        }
    }
};
