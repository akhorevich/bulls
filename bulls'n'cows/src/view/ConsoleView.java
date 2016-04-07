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
    private final static Scanner IN = new Scanner(System.in);

    public void gameStart(){

        try{
            System.out.print("Введите число: ");
            num = IN.nextLine();
            String[] number = num.split("");
            int[] intArray = new int[number.length];
            for (int i = 0; i < number.length; i++) {
                String numberAsString = number[i];
                intArray[i] = Integer.parseInt(numberAsString);
            }
        }catch (final InputMismatchException e){
            System.out.println("Это не число");

        }
    }


}
