import java.util.Scanner;
import java.util.Random;

//additions: outputs 'time' or 'times' instead of 'time(s)', user input not case sensitive, retry after invalid input (heads/tails),
//retry after invalid input (number of flips), dice expansion, percentages include decimal places instead of truncating.
//added total flips/rolls in final line.
public class CoinFlip {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("Roll an any sided die.");
		System.out.println("(To flip a coin, select 2 sides.)");
		int numberOfSides = -1;
		
		do {
			System.out.println("How many sides should it have?");
			if (scnr.hasNextInt()) {
				numberOfSides = scnr.nextInt();
				if (numberOfSides <= 1) {
					System.out.println("You need to choose an integer greater than 1.");
					
				} else if (numberOfSides == 2) {
					System.out.println("A classic coinflip! Very good.");
				} else {
					System.out.println("You have chosen to roll a " + numberOfSides + " sided die.");
				}
			} else {
				System.out.println("Invalid input. Try again!");
				scnr.next();
			}
		} while (numberOfSides <= 1);
		
		//Here is the original coin flip program:
		if (numberOfSides == 2) {
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
				System.out.print("How many times shall we flip the coin? ");
				if (scnr.hasNextInt()) {
					numberOfFlips = scnr.nextInt();
					if (numberOfFlips < 1) {
						System.out.println("Invalid input. Try again!");
					}
				} else {
					System.out.println("Invalid input. Try again!");
					scnr.next();
				}
			} while (numberOfFlips < 1);
			
			
			System.out.println();
			int correctCount = 0;
			
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
				System.out.println("Your guess, " + headsOrTailsGuess + ", came up " + correctCount + " time out of " + numberOfFlips + ".");	
			} else {
				System.out.println("Your guess, " + headsOrTailsGuess + ", came up " + correctCount + " times out of " + numberOfFlips + ".");
			}
			double correctCountDouble = correctCount;
			System.out.println("That's " + correctCountDouble * 100 / numberOfFlips + "%.");
			
			//here is the dice roll expansion:
		} else {
			int diceGuess = -1;
			int numberOfRolls = -1;
			
			do {
				System.out.println("Guess which side will be rolled the most? ");
				if (scnr.hasNextInt()) {
					diceGuess = scnr.nextInt();
					if (diceGuess <= 0 || diceGuess > numberOfSides) {
						System.out.println("That isn't one of this die's sides.");
					}
				} else {
					System.out.println("That isn't an integer.");
					scnr.next();
				}
			} while (diceGuess < 1 || diceGuess > numberOfSides);
			
			do {
				System.out.println("How many times shall we roll the die?");
				if (scnr.hasNextInt()) {
					numberOfRolls = scnr.nextInt();
					if (numberOfRolls < 1) {
						System.out.println("Invalid input. Try again!");
					}
				} else {
					System.out.println("That isn't an integer.");
					scnr.next();
				}
			} while (numberOfRolls < 1);
			
			System.out.println();
			int correctCountDieRolls = 0;
			
			for(int i = 0; i < numberOfRolls; i++) {
				int randomRoll = 1 + Math.abs(rand.nextInt() % numberOfSides);
				
				System.out.println(randomRoll);
				if (diceGuess == randomRoll) {
					correctCountDieRolls++;
				}
			}
			
			System.out.println();
			if (correctCountDieRolls == 1) {
				System.out.println("Your guess, " + diceGuess + ", came up " + correctCountDieRolls + " time out of " + numberOfRolls + ".");	
			} else {
				System.out.println("Your guess, " + diceGuess + ", came up " + correctCountDieRolls + " times out of " + numberOfRolls + ".");
			}
			double correctCountDoubleDice = correctCountDieRolls;
			System.out.println("That's " + correctCountDoubleDice * 100 / numberOfRolls + "%.");
			
		}
		scnr.close();
	}
}
