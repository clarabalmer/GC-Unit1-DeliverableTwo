import java.util.Scanner;

public class CoinFlip {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.print("Guess which will have more: heads or tails? ");
		String headsOrTailsGuess = scnr.next();
		System.out.print("How many times shall we flip a coin? ");
		int numberOfFlips = scnr.nextInt();
		
		int correctCount;
		
		
		
		
		
		System.out.print("Your guess, " + headsOrTailsGuess + ", came up " + " time(s).");
		
		scnr.close();
	}

}
