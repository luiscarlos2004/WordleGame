package WordleGame;

import java.util.Scanner;
public class Wordle {
    private String secretWord;
    private int attempts;

    public Wordle(String secretWord, int attempts){
        this.secretWord = secretWord.toLowerCase();
        this.attempts = attempts;
    }

    public void play(){
        Scanner scanner = new Scanner(System.in);
        int remainingAttempts = attempts;
        while (remainingAttempts > 0) {
            System.out.println("Enter a word");
            String guess = scanner.nextLine().toLowerCase();
        
            if(guess.length() != secretWord.length()){
                System.out.println("try again the word is not matching");
                System.out.println("The word has only " + secretWord.length() + " characters");
                continue;
            }

            int correctChars = 0;
            int correctPositions = 0;

            for(int i = 0; i < secretWord.length(); i++){
                char c = guess.charAt(i);
                if(c == secretWord.charAt(i)){
                    correctPositions ++;
                }else if(secretWord.indexOf(c) >= 0){
                    correctChars ++;
                }
            }
            
            if(correctPositions == secretWord.length()){
                System.out.println("Congratulations you guessed. The secret work was: " + secretWord);
                break;
            }else{
                
                System.out.println("Correct characters" + correctChars);
                System.out.println("Correct Positions: " + correctPositions);
                remainingAttempts --;
                System.out.println("Yo have this remaining attempts" + remainingAttempts);
            }
        }
        if(remainingAttempts == 0){
            System.out.println("Sorry you're out of attempts" + secretWord);
        }
        scanner.close();
    }
}
