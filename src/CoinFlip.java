import java.util.Scanner;
import java.util.Random;

public class CoinFlip {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.print("Guess which will have more: heads or tails? ");
		String headsOrTailsGuess = scnr.next();
		System.out.print("How many times shall we flip a coin? ");
		int numberOfFlips = scnr.nextInt();
		
		int correctCount;
		Random rand = new Random();
		
		//for loop generates random integer each loop.
		//if integer is even, print heads. If odd, print tails.
		for(int i = 0; i < numberOfFlips; i++) {
			int randomFlip = rand.nextInt() % 2;
			
			if (randomFlip == 0) {
				System.out.println("heads");
			} else {
				System.out.println("tails");
			}
		}
		
		
		
		System.out.print("Your guess, " + headsOrTailsGuess + ", came up " + " time(s).");
		
		scnr.close();
	}

}
