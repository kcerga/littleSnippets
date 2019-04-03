package rockPaperScissors;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class game {

	private int rounds;
	private String userChoice;
	private String computerRoll;
	Scanner reader = new Scanner(System.in);
	private int userScore;
	private int computerScore;
	
	
	/* Constructor */
	public game(int numberOfRounds) {
		this.rounds = numberOfRounds;
		System.out.println("The game will run for " + rounds + " rounds.");
		
		//For- loop to run as many rounds as the user chose
		for (int i=1; i<=rounds; i++) {
			System.out.println("Round " + i);
			chooseType(); 
			computerChoice();
			whoWins();
			System.out.println("**************");
		}
	}
	
	//Method to set the players choice (rock,paper or scissor)
	private void chooseType() {
		int type;
		System.out.println("What do you want to play with?"
				+ "\n(1) Rock"
				+ "\n(2) Paper"
				+ "\n(3) Scissor");
		type = reader.nextInt();
		
		if(type == 1) {userChoice = "Rock";}
		else if(type == 2) {userChoice = "Paper";}
		else if(type == 3) {userChoice = "Scissor";}
		else {System.out.println("Faulty input. Please try again.");
				chooseType();}
		System.out.println("You chose to play with " + userChoice + "!");
	}
	
	//Method to randomly set the computers choice..
	private void computerChoice() {
		//Sets the options to array
		String[] choices = new String[] {"Rock", "Paper", "Scissor"};
		//Convert array to a list and shuffle it
		List<String> choicesList = Arrays.asList(choices);
		Collections.shuffle(choicesList);
		//Sets the item in the first position in the shuffled list as the computers choice
		computerRoll = choicesList.get(0).toString();
		
		System.out.println("The computer chose " + computerRoll + "!");
	}
	
	
	//Determines the scores of each round
	private void whoWins() {
		
		//If the players have the same choice
		if (userChoice == computerRoll) {
			System.out.println("This round was a tie!");
		}
		//If user chooses Rock
		else if (userChoice == "Rock") {
				if (computerRoll == "Paper" ) {
					computerScore = computerScore +1;
					System.out.println("The computer wins this round with " + computerRoll + "!");
				}
				else if (computerRoll == "Scissor") {
					userScore = userScore +1;
					System.out.println("The player wins this round with " + userChoice + "!");
				}
		}
		//If user chooses Paper
		else if (userChoice == "Paper") {
			if (computerRoll == "Scissor" ) {
				computerScore = computerScore +1;
				System.out.println("The computer wins this round with " + computerRoll + "!");
			}
			else if (computerRoll == "Rock") {
				userScore = userScore +1;
				System.out.println("The player wins this round with " + userChoice + "!");
			}
		}
		//If user chooses Scissor
		else if (userChoice == "Scissor") {
			if (computerRoll == "Rock" ) {
				computerScore = computerScore +1;
				System.out.println("The computer wins this round with " + computerRoll + "!");
			}
			else if (computerRoll == "Paper") {
				userScore = userScore +1;
				System.out.println("The player wins this round with " + userChoice + "!");
			}
		}
		
	}
	
	//Returns the final score
		public String finalScore() {
			
			String results = "The final results are: "
					+ "\nPlayer score: " + userScore
					+ "\nComputer score: " + computerScore;
			
			if (userScore > computerScore) {
				results = results + "\nThe player wins!";
			}
			else if (userScore < computerScore) {
				results = results + "\nThe computer wins!";
			}
			else {
					results = results + "\nIt was a tie!";	
			}
			System.out.println(results);
			return results;
			
		}
}
