package view;

import controller.PlayerController;
import model.Player;

import java.util.*;


public class ConsoleView {

    String num;
    String name;
    String[] enemyNum;
    Player player;
    PlayerController plCont;
    private final static Scanner IN = new Scanner(System.in);

    public void gameStart() {
        player = new Player();
        setName();




        plCont = new PlayerController(player, true);
        enemyNumber();




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

        //System.out.println(Arrays.toString(enemyNum));
    }

    public void setName() {
        System.out.print("Введите свое имя: ");
        name = IN.nextLine();
        if (name == null) {
            System.out.println("Имя не может быть пустым");
            setName();

        } else {
            player.setName(name);
        }
    }

    public void setNum() {
        if (plCont.isTurn()) {
            try {
                System.out.print("Введите число: ");
                num = IN.nextLine();

                String[] number = num.split("");
                //System.out.println(Arrays.toString(number));
                boolean check = checkDupl(number);
                if (check == true) {
                    System.out.println("Нельзя вводить повторяющиеся числа!");
                    setNum();
                } else {
                    System.out.println("Все окей");
                }


            } catch (final InputMismatchException e) {
                System.out.println("Это не число");

            }
        } else {
            System.out.println("Не ваш ход!");
        }

    }

    public static boolean checkDupl(String[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i].equals(input[j]) && i != j) {
                    return true;
                }
            }
        }
        return false;
    }

}
