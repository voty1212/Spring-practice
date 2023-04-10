import java.util.Scanner;

public class WordGuess {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java WordGuess <word>");
            return;
        }

        String word = args[0].toLowerCase();
        int wordLength = word.length();
        boolean[] guessedLetters = new boolean[wordLength];
        int trials = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Key in one character or your guess word: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.length() == 1) {
                char letter = input.charAt(0);
                boolean foundLetter = false;

                for (int i = 0; i < wordLength; i++) {
                    if (word.charAt(i) == letter && !guessedLetters[i]) {
                        guessedLetters[i] = true;
                        foundLetter = true;
                    }
                }

                if (foundLetter) {
                    System.out.printf("Trail %d: ", ++trials);
                    for (int i = 0; i < wordLength; i++) {
                        if (guessedLetters[i]) {
                            System.out.print(word.charAt(i));
                        } else {
                            System.out.print("_");
                        }
                    }
                    System.out.println();
                } else {
                    System.out.printf("Trail %d: Wrong guess\n", ++trials);
                }

                if (allLettersGuessed(guessedLetters)) {
                    System.out.println("Congratulation!");
                    System.out.printf("You got in %d trials\n", trials);
                    break;
                }
            } else if (input.equals(word)) {
                System.out.println("Congratulation!");
                System.out.printf("You got in %d trials\n", ++trials);
                break;
            } else {
                System.out.printf("Trail %d: Wrong guess\n", ++trials);
            }
        }

        scanner.close();
    }

    private static boolean allLettersGuessed(boolean[] guessedLetters) {
        for (boolean guessed : guessedLetters) {
            if (!guessed) {
                return false;
            }
        }
        return true;
    }
}
