package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ASUS on 19.09.2016.
 */
public class Koloda {

    public ArrayList<String> koloda = new ArrayList<String>(Arrays.asList("")) {
        {
            add(1, "6_chervi");
            add(2, "6_kreste");
            add(3, "6_bubi");
            add(4, "6_pika");
            add(5, "7_chervi");
            add(6, "7_bubi");
            add(7, "7_kresti");
            add(8, "7_pik");
            add(9, "8_pika");
            add(10, "8_kresti");
            add(11, "8_bubi");
            add(12, "8_chervi");
            add(13, "9_chervi");
            add(14, "9_buby");
            add(15, "9_kresti");
            add(16, "9_pika");
            add(17, "10_kresti");
            add(18, "10_pika");
            add(19, "10_bubi");
            add(20, "10_chervi");
            add(21, "valet_bubi");
            add(22, "valet_chervi");
            add(23, "valet_pika");
            add(24, "valet_kresti");
            add(25, "dama_kresti");
            add(26, "dama_pika");
            add(27, "dama_chirva");
            add(28, "dama_buba");
            add(29, "korol_bubi");
            add(30, "korol_chirva");
            add(31, "korol_pika");
            add(32, "korol_kresti");
            add(33, "tuz_bubi");
            add(34, "tuz_chirva");
            add(35, "tuz_pika");
            add(36, "tuz_kresti");
        }
    };
    public Map<String, Integer> cardValue = new HashMap<String, Integer>() {{
        put("6_chervi", 6);
        put("6_kreste", 6);
        put("6_bubi", 6);
        put("6_pika", 6);
        put("7_chervi", 7);
        put("7_bubi", 7);
        put("7_kresti", 7);
        put("7_pik", 7);
        put("8_pika", 8);
        put("8_kresti", 8);
        put("8_bubi", 8);
        put("8_chervi", 8);
        put("9_chervi", 9);
        put("9_buby", 9);
        put("9_kresti", 9);
        put("9_pika", 9);
        put("10_kresti", 10);
        put("10_pika", 10);
        put("10_bubi", 10);
        put("10_chervi", 10);
        put("valet_bubi", 2);
        put("valet_chervi", 2);
        put("valet_pika", 2);
        put("valet_kresti", 2);
        put("dama_kresti", 3);
        put("dama_pika", 3);
        put("dama_chirva", 3);
        put("dama_buba", 3);
        put("korol_bubi", 4);
        put("korol_chirva", 4);
        put("korol_pika", 4);
        put("korol_kresti", 4);
        put("tuz_bubi", 1);
        put("tuz_chirva", 1);
        put("tuz_pika", 1);
        put("tuz_kresti", 1);
    }};


    public String getCard(Integer namberKarty) {
        return koloda.get(namberKarty);
    }

    public Integer getCardValue(String nameKarty) {
        return cardValue.get(nameKarty);
    }
}
