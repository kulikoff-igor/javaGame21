package game;

import data.Koloda;

import java.util.Random;

/**
 * Created by ASUS on 19.09.2016.
 */
public class Game {

    public Koloda koloda;
    public Player player1;
    public Player player2;

    public void gameStart() {
        koloda = new Koloda();
        player1 = new Player("player1");
        distributionCard(player1);
        distributionCard(player1);
        player2 = new Player("player2");
        distributionCard(player2);
        distributionCard(player2);

    }

    public Player endGame() {
        Player winner = null;
        do {
            if (player2.totalPoints <= 17) {
                distributionCard(player2);
            }
            if (player2.totalPoints >= 18) {
                break;
            }
        } while (true);
        Integer player1PointsDifference = 21 - player1.totalPoints;
        Integer player2PointsDifference = 21 - player2.totalPoints;
        if (player1PointsDifference == 0) {
            winner = player1;
        }
        if (player2PointsDifference == 0) {
            winner = player2;
        }
        if (player1PointsDifference == 0 && player2PointsDifference == 0) {
            System.out.print("++");
           // winner = null;
            winner = new Player("draw");
        }
        if (player1PointsDifference > 0 && player2PointsDifference < 0) {
            winner = player1;
        }
        if (player1PointsDifference < 0 && player2PointsDifference > 0) {
            winner = player2;
        }
        if (player1PointsDifference > 0 && player2PointsDifference > 0) {
            if (player1PointsDifference < player2PointsDifference) {
                winner = player1;
            } else {
                winner = player2;
            }
        }
        if (player1PointsDifference < 0 && player2PointsDifference < 0) {
            /*if (player1PointsDifference > player2PointsDifference) {
                winner = player1;
            } else {
                winner = player2;
            }*/
            winner = new Player("draw");
        }

        return winner;
    }

    public void distributionCard(Player player) {
        player.takeCard(cardPicks());

    }

    public String cardPicks() {
        Integer namberCard;
        String nameCard;
        Random random = new Random(System.currentTimeMillis());
        Boolean flag = true;
        do {
            namberCard = random.nextInt(36) + 1;

            nameCard = koloda.getCard(namberCard);
            // System.out.println(namberCard + "   " + nameCard);
            if (nameCard.equals("null") == true) {
                flag = false;
            }
            if (nameCard.equals("null") == false) {
                flag = true;
                koloda.koloda.set(namberCard, "null");
                break;
            }
        } while (flag = true);

        return nameCard;
    }


}
