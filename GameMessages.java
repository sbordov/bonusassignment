package bonusassignment;

import javax.swing.JOptionPane;

public class GameMessages {

	GameMessages(){
		
	}
	
	public static void intro(){
		int reply = JOptionPane.showConfirmDialog(null,
				"Welcome to Mastermind. Here are the rules.\n"
				+ " This is a text version of the classic board game Mastermind.\n"
				+ "The computer will think of a secret code. The code consists of 4 colored pegs.\n"
		        + "The pegs may be one of six colors: blue, green, orange, purple, red, or yellow.\n" 
				+ "A color may appear more than once in the code.\n" 
		        + "You try to guess what colored pegs are in the code and what order they are in.\n" 
		        + "After you make a valid guess the result (feedback) will be displayed.\n"
		        + "The result consists of a black peg for each peg you have guessed exactly correct\n"
		        + "(color and position) in your guess.\n" 
		        + "For each peg in the guess that is the correct color, but is out of position, you get a white peg.\n" 
				+ "For each peg, which is fully incorrect, you get no feedback.\n"
		        + "Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.\n"
		        + "When entering guesses you only need to enter the first character of each color as a capital letter.\n"
		        + "You have 12 guesses to figure out the secret code or you lose the game.\n\n"
		        + "Are you ready to play? (Y/N):"
		        , "Instructions", JOptionPane.YES_NO_OPTION);
			        if (reply == JOptionPane.YES_OPTION) {
			          
			        }
			        else {
			           JOptionPane.showMessageDialog(null, "GOODBYE");
			           System.exit(0);
			        }
	}
	
	public static void outofGuesses(Board game){
		int reply = JOptionPane.showConfirmDialog(null,
				"You've ran out of guesses!\n"
				+ "Would you like to play again?"
		        , "Confirmation", JOptionPane.YES_NO_OPTION);
			        if (reply == JOptionPane.YES_OPTION) {
			         game.guesses =0;
			        }
			        else {
			           JOptionPane.showMessageDialog(null, "GOODBYE");
			           System.exit(0);
			        }
	}
	
	
	public static void winMessage(Board game){
		int reply = JOptionPane.showConfirmDialog(null,
				  "Hooray! You've won!"
				+ "Would you like to play again?"
		        , "Confirmation", JOptionPane.YES_NO_OPTION);
			        if (reply == JOptionPane.YES_OPTION) {
			         game.guesses =0;
			        }
			        else {
			           JOptionPane.showMessageDialog(null, "GOODBYE");
			           System.exit(0);
			        }
	}
	
}
