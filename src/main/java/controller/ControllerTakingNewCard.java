package controller;

import data.DataKartyIMG;
import game.Game;
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
 * Created by ASUS on 23.09.2016.
 */
public class ControllerTakingNewCard extends HttpServlet {
    private Game game = new Game();
    private DataKartyIMG dataKartyIMG = new DataKartyIMG();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        HttpSession session = request.getSession(true);
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        game= (Game) session.getAttribute("Game");
        game.distributionCard(game.player1);
        List<String> dialedCardIMG = new ArrayList<String>();
        for(String card: game.player1.dialedCard){
            dialedCardIMG.add(dataKartyIMG.getSrsKarty(card));
        }
        JSONObject object = new JSONObject();
        try {

            object.put("plauer1CardList", dialedCardIMG.toArray());
            object.put("plauer1CardCount", game.player1.totalPoints);
            object.put("plauer2CardList", game.player2.dialedCard.size());


        } catch (JSONException e) {
            e.printStackTrace();
        }
        response.getWriter().print(object.toString());


    }
}
