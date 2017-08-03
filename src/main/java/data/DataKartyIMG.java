package data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ASUS on 19.09.2016.
 */
public class DataKartyIMG {
    private Map<String, String> kolodaSrcImg = new HashMap<String, String>() {{
        put("6_chervi", "karty/6/6_chervi.jpg");
        put("6_kreste", "karty/6/6_kreste.jpg");
        put("6_bubi", "karty/6/6_bubi.jpg");
        put("6_pika", "karty/6/6_pika.jpg");
        put("7_chervi", "karty/7/7_chervi.jpg");
        put("7_bubi", "karty/7/7_bubi.gif");
        put("7_kresti", "karty/7/7_kresti.jpg");
        put("7_pik", "karty/7/7_pik.jpg");
        put("8_pika", "karty/8/8_pika.jpg");
        put("8_kresti", "karty/8/8_kresti.jpg");
        put("8_bubi", "karty/8/8_bubi.gif");
        put("8_chervi", "karty/8/8_chervi.png");
        put("9_chervi", "karty/9/9_chervi.png");
        put("9_buby", "karty/9/9_buby.png");
        put("9_kresti", "karty/9/9_kresti.png");
        put("9_pika", "karty/9/9_pika.png");
        put("10_kresti", "karty/10/10_kresti.gif");
        put("10_pika", "karty/10/10_pika.jpg");
        put("10_bubi", "karty/10/10_bubi.png");
        put("10_chervi", "karty/10/10_chervi.jpg");
        put("valet_bubi", "karty/valet/valet_bubi.jpg");
        put("valet_chervi", "karty/valet/valet_chervi.jpg");
        put("valet_pika", "karty/valet/valet_pika.jpg");
        put("valet_kresti", "karty/valet/valet_kresti.jpg");
        put("dama_kresti", "karty/dama/dama_kresti.jpg");
        put("dama_pika", "karty/dama/dama_pika.jpg");
        put("dama_chirva", "karty/dama/dama_chirva.jpg");
        put("dama_buba", "karty/dama/dama_buba.gif");
        put("korol_bubi", "karty/korol/korol_bubi.jpg");
        put("korol_chirva", "karty/korol/korol_chirva.jpg");
        put("korol_pika", "karty/korol/korol_pika.jpg");
        put("korol_kresti", "karty/korol/korol_kresti.jpg");
        put("tuz_bubi", "karty/tuz/tuz_bubi.gif");
        put("tuz_chirva", "karty/tuz/tuz_chirva.jpg");
        put("tuz_pika", "karty/tuz/tuz_pika.jpg");
        put("tuz_kresti", "karty/tuz/tuz_kresti.jpg");
    }};

    public String getSrsKarty(String nameKarty) {
        return kolodaSrcImg.get(nameKarty);
    }
}
