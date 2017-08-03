package game;

import data.Koloda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 20.09.2016.
 */
public class Player {
    public String namePlayer = " ";
    public List<String> dialedCard = new ArrayList<String>();
    public Integer totalPoints = 0;

    public Player(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public void takeCard(String namberKarty) {
        Koloda koloda = new Koloda();
        dialedCard.add(namberKarty);
        totalPoints += koloda.getCardValue(namberKarty);

    }
}
