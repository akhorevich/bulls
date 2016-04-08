package view;

import controller.PlayerController;
import model.Player;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by khoAK on 06.04.2016.
 */
public class ConsoleView {

    String num;
    String name;
    ArrayList<Integer> intArray;
    Player player;
    PlayerController plCont;
    private final static Scanner IN = new Scanner(System.in);

    public void gameStart(){
        player = new Player();
        setName();
        if (name==null){
            System.out.println("Имя не может быть пустым");
            setName();
        }else {
            player.setName(name);
        }


        plCont = new PlayerController(player,true);


    }
    public void setName(){
        System.out.print("Введите свое имя: ");
        name = IN.nextLine();
    }
    public void setNum(){
        if (plCont.isTurn()) {
            try {
                System.out.print("Введите число: ");
                num = IN.nextLine();
                player.setNumber(num);
                String[] number = num.split( "(?<=(.))(?!\\1)" );
                intArray = new ArrayList<>(number.length);
                for (int i = 0; i < number.length; i++) {
                    String numberAsString = number[i];
                    intArray.add(Integer.parseInt(numberAsString));
                }
                plCont.setTurn(false);
                System.out.println("Игрок "+player.getName()+" загадал число "+player.getNumber());
            } catch (final InputMismatchException e) {
                System.out.println("Это не число");

            }
        }
        
    }


}
