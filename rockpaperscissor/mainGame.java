package rockPaperScissors;
/**
 * 
 * DESC: A simple "Rock, Paper, Scissors - game" against the "computer"
 * DATE: 20.02.2019
 * @author Wilma C
 */

import java.util.Scanner;

public class mainGame {

	//Main program for the game
	public static void main(String[] args) {
		int numberOfRounds;
		Scanner reader = new Scanner(System.in);
		
		//Asks the user how many rounds they want to play
		System.out.println("Welcome to Rock Paper Scissor- game!");
		System.out.println("How many rounds do you want to play?");
		numberOfRounds = reader.nextInt();
		
		//Sends rounds to the constructor and creates the game
		game uusiPeli = new game(numberOfRounds);
		uusiPeli.finalScore();
		reader.close();
	}

}
