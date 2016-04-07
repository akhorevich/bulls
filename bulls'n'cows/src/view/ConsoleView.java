package view;

import controller.PlayerController;
import model.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by khoAK on 06.04.2016.
 */
public class ConsoleView {

    String num;
    String name;
    private final static Scanner IN = new Scanner(System.in);

    public void gameStart(){
        System.out.print("Введите свое имя: ");
        name = IN.nextLine();
        Player player = new Player();
        PlayerController pl = new PlayerController(player,true);
        player.setName(name);
        try{
            System.out.print("Введите число: ");
            num = IN.nextLine();
            player.setNumber(num);
            String[] number = num.split("");
            int[] intArray = new int[number.length];
            for (int i = 0; i < number.length; i++) {
                String numberAsString = number[i];
                intArray[i] = Integer.parseInt(numberAsString);
            }
            System.out.println(player.getNumber());
        }catch (final InputMismatchException e){
            System.out.println("Это не число");

        }
    }


}
