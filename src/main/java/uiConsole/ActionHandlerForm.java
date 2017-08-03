package uiConsole;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ActionHandlerForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPane;
    public Boolean flag = false;
    private String your_session_id;
    private JPanel computerCards;
    private final JPanel cardPlayer;
    private final JLabel playerPointsLabel;
    private final JLabel playerPointsCount;
    private final JButton vzatKartyButton;
    private final JButton endGameButton;
    private final JLabel cartColodaLabel;
    private final JLabel cartColodaCount;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ActionHandlerForm frame = new ActionHandlerForm();
                    frame.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public ActionHandlerForm() {
        setFont(new Font("Tahoma", Font.PLAIN, 10));
        setType(Type.POPUP);
        setResizable(false);
        setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
        setLocationByPlatform(true);
        setTitle("Игра 21 очко");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 470);
        contentPane = new JPanel();
        contentPane.setFocusable(false);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        computerCards = new JPanel(new FlowLayout(FlowLayout.CENTER));
        computerCards.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
        computerCards.setBounds(10, 10, 775, 150);
        contentPane.add(computerCards);

        JPanel actionGames = new JPanel();
        actionGames.setBounds(10, 170, 775, 100);
        contentPane.add(actionGames);
        actionGames.setLayout(null);

        cardPlayer = new JPanel();
        cardPlayer.setBackground(UIManager.getColor("Label.disabledForeground"));
        cardPlayer.setBounds(100, 280, 600, 150);
        contentPane.add(cardPlayer);
        cardPlayer.setLayout(new FlowLayout(FlowLayout.CENTER));
        playerPointsLabel = new JLabel("<html>Очки игрока");
        playerPointsLabel.setBounds(715, 300, 80, 30);
        contentPane.add(playerPointsLabel);

        playerPointsCount = new JLabel();
        playerPointsCount.setBounds(745, 320, 80, 60);
        playerPointsCount.setVisible(false);
        contentPane.add(playerPointsCount);

        cartColodaLabel = new JLabel("Карт в колоде");
        cartColodaLabel.setBounds(600, 15, 100, 30);
        actionGames.add(cartColodaLabel);

        cartColodaCount = new JLabel("36");
        cartColodaCount.setBounds(635, 35, 100, 30);
        actionGames.add(cartColodaCount);

        final JButton startGameButton = new JButton("Начать игру");
        startGameButton.setFocusable(false);
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGameButton.setVisible(false);
                vzatKartyButton.setVisible(true);
                endGameButton.setVisible(true);
                playerPointsCount.setVisible(true);
                startGame();
            }
        });
        startGameButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        startGameButton.setBounds(330, 35, 100, 30);
        actionGames.add(startGameButton);

        vzatKartyButton = new JButton("Взять карту");
        vzatKartyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vzatKarty();
            }
        });
        vzatKartyButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        vzatKartyButton.setBounds(270, 35, 100, 30);
        vzatKartyButton.setVisible(false);
        actionGames.add(vzatKartyButton);

        endGameButton = new JButton("Хватит");
        endGameButton.setFocusable(false);
        endGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        endGameButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        endGameButton.setBounds(380, 35, 100, 30);
        endGameButton.setVisible(false);
        actionGames.add(endGameButton);


    }

    public void startGame() {
        String toservlet = "http://localhost:8080/Games21/GamesStartController";
        JSONParser parser = null;
        JSONObject json = null;
        JSONArray jsonArray = null;
        try {
            URL servleturl = new URL(toservlet);
            URLConnection servletconnection = servleturl.openConnection();
            servletconnection.setDoInput(true);
            servletconnection.setDoOutput(true);
            servletconnection.setUseCaches(true);
            servletconnection.setDefaultUseCaches(true);

            DataOutputStream out = new DataOutputStream(servletconnection.getOutputStream());

            DataInputStream inputFromClient = new DataInputStream(servletconnection.getInputStream());
            your_session_id = servletconnection.getHeaderField("Set-Cookie");
            System.out.println(your_session_id);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputFromClient));
            StringBuilder sb = new StringBuilder();

            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                try {
                    inputFromClient.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }

            parser = new JSONParser();
            Object obj = parser.parse(sb.toString());
            json = (JSONObject) obj;
            playerPointsCount.setText(json.get("plauer1CardCount").toString());
            jsonArray = (JSONArray) json.get("plauer1CardList");
            System.out.println(jsonArray.size());
            int x = 10;
            ArrayList<JLabel> imegeCardPlauer = new ArrayList<JLabel>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JLabel label = new JLabel();
                ImageIcon ii = new ImageIcon(jsonArray.get(i).toString());
                label.setIcon(new ImageIcon(ii.getImage().getScaledInstance(80, 100, ii.getImage().SCALE_DEFAULT)));
                System.out.println(jsonArray.get(i).toString());
                imegeCardPlauer.add(label);
                cardPlayer.add(imegeCardPlauer.get(i));
                cardPlayer.validate();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        ArrayList<JLabel> imegeCardComputer = new ArrayList<JLabel>();
        for (int i = 0; i < 2; i++) {
            JLabel label = new JLabel();
            ImageIcon ii = new ImageIcon("koloda.gif");
            label.setIcon(new ImageIcon(ii.getImage().getScaledInstance(80, 100, ii.getImage().SCALE_DEFAULT)));
            imegeCardComputer.add(label);
            computerCards.add(imegeCardComputer.get(i));
            computerCards.validate();
        }
        int tmp = 36 - Integer.parseInt(json.get("plauer2CardList").toString()) - jsonArray.size();
        cartColodaCount.setText(Integer.toString(tmp));
    }

    public void vzatKarty() {
        JSONParser parser = null;
        JSONObject json = null;
        JSONArray jsonArray = null;
        String toservlet = "http://localhost:8080/Games21/ControllerTakingNewCard";
        try {
            URL servleturl = new URL(toservlet);
            URLConnection servletconnection = servleturl.openConnection();
            servletconnection.setDoInput(true);
            servletconnection.setDoOutput(true);
            servletconnection.setUseCaches(true);
            servletconnection.setDefaultUseCaches(true);
            servletconnection.setRequestProperty("Cookie", your_session_id);

            DataOutputStream out = new DataOutputStream(servletconnection.getOutputStream());

            DataInputStream inputFromClient = new DataInputStream(servletconnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputFromClient));
            StringBuilder sb = new StringBuilder();

            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                try {
                    inputFromClient.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }

            parser = new JSONParser();
            Object obj = parser.parse(sb.toString());
            json = (JSONObject) obj;
            playerPointsCount.setText(json.get("plauer1CardCount").toString());
            jsonArray = (JSONArray) json.get("plauer1CardList");

            JLabel label = new JLabel();
            ImageIcon ii = new ImageIcon(jsonArray.get(jsonArray.size() - 1).toString());
            label.setIcon(new ImageIcon(ii.getImage().getScaledInstance(80, 100, ii.getImage().SCALE_DEFAULT)));

            cardPlayer.add(label);
            cardPlayer.validate();

        } catch (Exception e3) {
            e3.printStackTrace();
        }
        int tmp = 36 - Integer.parseInt(json.get("plauer2CardList").toString()) - jsonArray.size();
        cartColodaCount.setText(Integer.toString(tmp));
    }
}