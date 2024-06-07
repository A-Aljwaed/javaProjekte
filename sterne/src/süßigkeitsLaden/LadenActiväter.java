package süßigkeitsLaden;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.security.Timestamp;
import java.util.*;
import java.sql.DriverManager;

public class LadenActiväter {

    public static void main(String argumente[]) {


        LinkedList<Angestellte> arbeiter = new LinkedList<>();

        Angestellte ahmad = new Angestellte("ahmad☻", Geschlächt.MAENLICH, 27);
        arbeiter.add(ahmad);

        arbeiter.add(new Angestellte("nilo☻", Geschlächt.MAENLICH, 32));
        arbeiter.add(new Angestellte("Lia☻", Geschlächt.WEIBLICH, 28));
        arbeiter.add(new Angestellte("Jori☻", Geschlächt.MAENLICH, 19));
        arbeiter.add(new Angestellte("Karsten☻", Geschlächt.SEHR_MAENLICH, 43));
        arbeiter.add(new Angestellte("Dani☻", Geschlächt.DIVERS, 25));


        arbeiter.add(new LeihArbeiter("raj", Geschlächt.MAENLICH, 44, "Randstad"));


        for (Angestellte an : arbeiter) {
            System.out.println(an.getName() + "  " + an.getGeschlecht());
        }

        Süß_Laden süßLaden =new Süß_Laden(arbeiter);
        süßLaden.offnen();
        System.out.println(süßLaden.getOffnungszeit());

        Suesse_Sorten.CUPCAKE.setPreis("11");
        Suesse_Sorten.EISCAKE.setPreis("4");
        Suesse_Sorten.KAESEKUCHEN.setPreis("0.66");
        Suesse_Sorten.SAHNEKUCHEN.setPreis("4");
        Suesse_Sorten.KAFFEEKUCHEN.setPreis("2.3");

        LeihArbeiter adil = new LeihArbeiter("adil", Geschlächt.WEIBLICH, 33, "phantom");

        adil.zeitStaembel();

//adil.arbeitszeit();
        ahmad.verkaufe(Suesse_Sorten.CUPCAKE, Suesse_Sorten.CUPCAKE, Suesse_Sorten.KAESEKUCHEN, Suesse_Sorten.SAHNEKUCHEN);


//
//        Date l=new Date();
//        System.out.println(l);
    }
}
