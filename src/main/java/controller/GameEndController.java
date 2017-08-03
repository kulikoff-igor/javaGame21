package controller;

import data.DataKartyIMG;
import game.Game;
import game.Player;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 26.09.2016.
 */
public class GameEndController extends HttpServlet {
    private Game game = new Game();
    private DataKartyIMG dataKartyIMG = new DataKartyIMG();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        HttpSession session = request.getSession(true);
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        game = (Game) session.getAttribute("Game");
        Player player;
        player = game.endGame();

        List<String> dialedCardImgPlauer1 = new ArrayList<String>();
        List<String> dialedCardImgPlauer2 = new ArrayList<String>();
        for (String card : game.player1.dialedCard) {
            dialedCardImgPlauer1.add(dataKartyIMG.getSrsKarty(card));
        }
        for (String card : game.player2.dialedCard) {
            dialedCardImgPlauer2.add(dataKartyIMG.getSrsKarty(card));
        }
        JSONObject object = new JSONObject();
        try {

            object.put("plauer1CardList", dialedCardImgPlauer1.toArray());
            object.put("plauer2CardList", dialedCardImgPlauer2.toArray());
            if (player.equals("draw")) {
                object.put("winner", "draw");
            } else {
                object.put("winner", player.namePlayer);
            }
            object.put("plauer1CardCount", game.player1.totalPoints);
            object.put("plauer2CardCount", game.player2.totalPoints);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        response.getWriter().print(object.toString());


    }
}

