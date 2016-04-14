import controller.PlayerController;
import model.Player;
import view.ConsoleView;

/**
 * Created by khoAK on 06.04.2016.
 */
public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        ConsoleView view = new ConsoleView();
        PlayerController controller = new PlayerController(player, view);
        controller.game();

    }
}
