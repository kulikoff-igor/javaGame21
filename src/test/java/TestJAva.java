import data.Koloda;
import game.Game;
import org.junit.Test;

import java.util.List;

/**
 * Created by ASUS on 15.09.2016.
 */
public class TestJAva {
    @Test
    public void test() {
        Game game=new Game();
        game.gameStart();
        game.distributionCard( game.player1);
        game.distributionCard( game.player1);

        if (game.endGame().namePlayer.equals("draw")) {
            System.out.println("Nicya ");
        } else {
            System.out.println("Winer : "+game.endGame().namePlayer.toString());
        }
        //System.out.println("Winer : "+game.endGame().namePlayer.toString());
        System.out.println(game.player1.dialedCard.toString()+ "  " +game.player1.totalPoints);
        System.out.println(game.player2.dialedCard.toString()+ "  " +game.player2.totalPoints);

    }
}
