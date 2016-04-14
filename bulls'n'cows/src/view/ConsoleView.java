package view;

import controller.PlayerController;
import model.Player;

import java.util.*;


public class ConsoleView {

    public void updateView(int number, int enemyNumber) {
        String numberStr = number + "";
        String enemyNumberStr = enemyNumber + "";
        int bulls = 0;
        int cows = 0;
        int guesses = 0;
        boolean guessed = false;

        do {
            guesses++;
            for (int i = 0; i < 4; i++) {
                if (numberStr.charAt(i) == enemyNumberStr.charAt(i)) {
                    bulls++;
                } else if (enemyNumberStr.contains(numberStr.charAt(i) + "")) {
                    cows++;
                }

            }

            if (bulls == 4) {
                guessed = true;
                System.out.println("Вы выиграли, затратив " + guesses + " ходов.");

            } else if (guesses == 10) {
                System.out.println("Вы проиграли! Загаданное число было " + enemyNumberStr);
            } else {
                System.out.println(cows + " коров " + bulls + " быков.");
            }

        }while (!guessed) ;
    }
}
