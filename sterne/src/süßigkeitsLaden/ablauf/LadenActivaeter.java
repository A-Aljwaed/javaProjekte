package süßigkeitsLaden.ablauf;

import süßigkeitsLaden.INTERN.KAFFEE;
import süßigkeitsLaden.INTERN.Softdrinks_sorte;
import süßigkeitsLaden.INTERN.Sorte;

import java.util.*;

public class LadenActivaeter {

    public static void main(String argumente[]) {


        LinkedList<Angestellte> arbeiter = new LinkedList<>();

        Angestellte ahmad = new Angestellte("ahmad☻", Geschlecht.MAENLICH, 27);
        arbeiter.push(ahmad);


        arbeiter.push(new Angestellte("nilo☻", Geschlecht.MAENLICH, 32));
        arbeiter.push(new Angestellte("Lia☻", Geschlecht.WEIBLICH, 28));
        arbeiter.push(new Angestellte("Jori☻", Geschlecht.MAENLICH, 19));
        arbeiter.push(new Angestellte("Karsten☻", Geschlecht.SEHR_MAENLICH, 43));
        arbeiter.push(new Angestellte("Dani☻", Geschlecht.DIVERS, 25));





        arbeiter.add(new LeihArbeiter("raj", Geschlecht.MAENLICH, 44, "Randstad"));
        LeihArbeiter adil = new LeihArbeiter("adil", Geschlecht.WEIBLICH, 33, "phantom");

        arbeiter.add(adil);

        for (Angestellte an : arbeiter) {
            System.out.println(an.getName() + "  " + an.getGeschlecht());
        }


        Sueß_Laden süßLaden = new Sueß_Laden(arbeiter);

        süßLaden.offnen();

        süßLaden.getOffnungszeit();

        Suesse_Sorten.CUPCAKE.setPreis("11");
        Suesse_Sorten.EISCAKE.setPreis("4");
        Suesse_Sorten.KAESEKUCHEN.setPreis("0.66");
        Suesse_Sorten.SAHNEKUCHEN.setPreis("0.5");
        Suesse_Sorten.KAFFEEKUCHEN.setPreis("2");
        Sorte.CAPO.setPreis("1.2");
        Softdrinks_sorte.COLA.setPreis("1.2");


        ahmad.verkaufe(Sorte.CAPO, Softdrinks_sorte.COLA, Suesse_Sorten.CUPCAKE);

        KAFFEE k = new KAFFEE("sad", Sorte.CAPO, 50);
        System.out.println(k);
        k.fueleBohne(70);


        adil.arbeitszeit();
        Date l = new Date();
        System.out.println(l);
    }
}
