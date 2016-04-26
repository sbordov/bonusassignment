package bonusassignment;

import java.util.Random;

public class Board {
	private int guesses;
	private Code secret_code;
	public Code[] board = new Code[12];
	
	public Board(){
		guesses = 0;
		secret_code = new Code(generateSecretCode());
		for(int  i=0; i<12;i++){
			board[i]= new Code();
		}
	
	}
	
	public static String generateSecretCode(){
		String validColors = "BGOPRY";
		String result = "";
		for(int i = 0; i < 4; i++){
			int randIndex = randInt(0, 5);
			String character = validColors.substring(randIndex, randIndex + 1);
			result = result + character;
		}
		return result;
	}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	public int getNumGuesses(){
		return guesses;
	}
	
	public String getSecretCode(){
		return secret_code.getCode();
	}
	
	public void setNextGuess(String input){
		try{
			board[guesses].setCode(input);
			incrementGuesses();
		} catch(IllegalCodeException e){
			throw new IllegalCodeException();
		} 
		
	}
	
	public Code getGuess(int index){
		if((index <= guesses) && (index >= 0)){
			return board[index];
		} else{
			return null;
		}
	}
	
	public void incrementGuesses(){
		guesses++;
	}
	
	public ResultPegs checkLastGuess(){
		ResultPegs result = new ResultPegs();
		Code last_guess = getGuess(guesses - 1);
		
		char[] guess = last_guess.code.toLowerCase().toCharArray();
		char[] secret = secret_code.code.toLowerCase().toCharArray();
		
		
		int bcount =0;
		int wcount =0;
		
		
		for(int i =0; i < 4; i++){
			if(guess[i] == secret[i]){
				guess[i] = secret[i] = '.';
				bcount ++;
			}
		}
	
		
		if(bcount != 4){
			for(int i =0; i < 4; i++){
				if(guess[i] != '.'){
					for(int j =0; j < 4; j++){
						if(guess[i] == secret[j]){
							wcount++;
							guess[i] = secret[j] = '.';
							break;
						}
					}
					
				}
			}
		}
			result.setBlackPegs(bcount);
			result.setWhitePegs(wcount);
		
		return result;
	}
	
}