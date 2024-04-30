import java.util.Scanner;

public class HangmanGame {
    public static String[] WORDS = {"hangman", "student", "travel", "sweet", "january", "magic", "moon", "grass", "nirvana"};
    public static int max_tries = 6;

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String secretWord = WORDS[(int) (Math.random() * WORDS.length)];

        char[] guessedWord = new char[secretWord.length()];

        int attempts = 0;
        boolean gameWon = false;

        for(int i = 0; i < secretWord.length(); i++) {
            guessedWord[i] = '_';
        }

        System.out.println("Welcome to Hangman game!");
        while (attempts < max_tries && !gameWon) {
            System.out.println("\nSecret word: " + String.valueOf(guessedWord));
            System.out.println("Attempts remaining: " + (max_tries - attempts));
            System.out.println("Enter a letter: ");
            char guess = myObj.nextLine().charAt(0);
            boolean found = false;

            for(int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    found = true;
                }
            }
            if (!found) {
                attempts++;
                System.out.println("Incorrect guess");
            }
            if(String.valueOf(guessedWord).equals(secretWord)) {
                gameWon = true;
            }
        }
        if (gameWon) {
            System.out.println("\nCongratulation! You've guessed the word: " + secretWord);
            System.out.println("YOU WON :)");
        }else {
            System.out.println("\nSorry, you ran out of words. The word was : " + secretWord);
        }
        myObj.close();
    }
}
