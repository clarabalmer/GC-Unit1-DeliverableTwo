import java.util.Scanner;
import java.util.Random;

public class CoinFlip {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.print("Guess which will have more: heads or tails? ");
		String headsOrTailsGuess = scnr.next();
		System.out.print("How many times shall we flip a coin? ");
		int numberOfFlips = scnr.nextInt();
		System.out.println();
		
		int correctCount = 0;
		Random rand = new Random();
		
		//for loop generates random integer each loop.
		//if integer is even, print heads. If odd, print tails.
		//if user guess matches flip, add one to correctCount.
		for(int i = 0; i < numberOfFlips; i++) {
			int randomFlip = rand.nextInt() % 2;
			
			if (randomFlip == 0) {
				System.out.println("heads");
				
				if (headsOrTailsGuess.equals("heads")) {
					correctCount++;
				}
			} else {
				System.out.println("tails");
				
				if (headsOrTailsGuess.equals("tails")) {
					correctCount++;
				}
			}
		}
		
		System.out.println();
		System.out.println("Your guess, " + headsOrTailsGuess + ", came up " + correctCount + " time(s).");
		System.out.println("That's " + correctCount * 100 / numberOfFlips + "%.");
		scnr.close();
	}

}
