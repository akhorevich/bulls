package controller;

import model.Player;
import view.ConsoleView;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by khoAK on 06.04.2016.
 */
public class PlayerController {

    int num;
    int enemyNum;
    private final static Scanner IN = new Scanner(System.in);
    private Player player;
    private ConsoleView view;


    public PlayerController(Player player, ConsoleView view) {
        this.player = player;
        this.view = view;
    }

    public void enemyNumber() {
        Random r = new Random();
        enemyNum = r.nextInt(9000) + 1000;
        if (checkDupl(enemyNum)) {
            enemyNumber();
        } else {
            setNumber();
        }
    }


    public void setNumber() {
        player = new Player();
        try {
            System.out.print("Введите число: ");
            num = IN.nextInt();
            player.setNumber(num);

            if (checkDupl(player.getNumber())) {
                System.out.println("Нельзя вводить повторяющиеся числа!");
                setNumber();
            }

        } catch (final InputMismatchException e) {
            System.out.println("Это не число");

        }
    }


    public static boolean checkDupl(int num) {
        boolean[] digs = new boolean[10];
        while (num > 0) {
            if (digs[num % 10]) return true;
            digs[num % 10] = true;
            num /= 10;
        }
        return false;
    }

    public int getPlayerNumber(){
        return player.getNumber();
    }

    public void game(){
        enemyNumber();
        view.updateView(num,enemyNum);
        setNumber();

    }
}
