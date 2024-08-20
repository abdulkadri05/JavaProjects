package BusinessLogic;

import java.util.Random;

public class GameLogic {
    private int tries;
    private int targetNumber;

    public GameLogic(int maxTries) {
        this.tries = maxTries;
        this.targetNumber = generateRandomNumber();
    }

    private int generateRandomNumber() {
        return new Random().nextInt(100) + 1;
    }

    public String processGuess(int userInput) {
        if (userInput == targetNumber) {
            return "Congratulations! You guessed the correct number.";
        } else if (userInput < targetNumber) {
            decreaseTries();
            return "Too low! Try again.";
        } else {
            decreaseTries();
            return "Too high! Try again.";
        }
    }

    public boolean isGameOver() {
        return tries <= 0;
    }

    public void decreaseTries() {
        tries--;
    }

    public int getTries() {
        return tries;
    }

    public String getGameStatus() {
        if (isGameOver()) {
            return "Game Over! You've used all your tries.";
        }
        return "";
    }
}
