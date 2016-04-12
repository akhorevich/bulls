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
    String[] enemyNum;
    private final static Scanner IN = new Scanner(System.in);
    private Player player;
    private ConsoleView view;

    public PlayerController(Player player, ConsoleView view) {
        this.player = player;
        this.view = view;
    }

    public void enemyNumber() {
        enemyNum = new String[4];
        Random r = new Random();

        for (int i = 0; i < enemyNum.length; i++) {
            enemyNum[i] = String.valueOf(r.nextInt(11));
        }
        boolean checkEn = checkDupl(enemyNum);
        if (checkEn==true){
            enemyNumber();
        } else {
            setNum();
        }

    }


    public void setNum() {

            try {
                System.out.print("Введите число: ");
                num = IN.nextLine();

                String[] number = num.split("");
                boolean check = checkDupl(num);
                if (check == true) {
                    System.out.println("Нельзя вводить повторяющиеся числа!");
                    setNum();
                } else {
                    System.out.println("Все окей");
                }


            } catch (final InputMismatchException e) {
                System.out.println("Это не число");

            }


    }

    public static boolean checkDupl(int num) {
        boolean[] digs = new boolean[10];
        while(num > 0){
            if(digs[num%10]) return true;
            digs[num%10] = true;
            num/= 10;
        }
        return false;
    }
}
