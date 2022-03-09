import java.util.Scanner;
import java.util.Random;

//additions: outputs time or times, not time(s), user input not case sensitive, retry after invalid input (heads/tails),
//retry after invalid input (number of flips), 
public class CoinFlip {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String headsOrTailsGuess = "";
		int numberOfFlips = -1;
		
		do {
			System.out.print("Guess which will have more: heads or tails? ");
			headsOrTailsGuess = scnr.next().toLowerCase();
			if (!headsOrTailsGuess.equals("heads") && !headsOrTailsGuess.equals("tails")) {
				System.out.println("Invalid input. Try again!");
			}
		} while (!headsOrTailsGuess.equals("heads") && !headsOrTailsGuess.equals("tails"));
		
		do {
			System.out.print("How many times shall we flip a coin? ");
			if (scnr.hasNextInt()) {
				numberOfFlips = scnr.nextInt();
				if (numberOfFlips < 1) {
					System.out.println("Invalid input. Try again!");
				}
			} else {
				System.out.println("Invalid input. Try again!");
			}
		} while (numberOfFlips < 1);
		
		
		
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
		if (correctCount == 1) {
			System.out.println("Your guess, " + headsOrTailsGuess + ", came up " + correctCount + " time.");	
		} else {
			System.out.println("Your guess, " + headsOrTailsGuess + ", came up " + correctCount + " times.");
		}
		System.out.println("That's " + correctCount * 100 / numberOfFlips + "%.");
		scnr.close();
	}

}
