package süßigkeitsLaden;

import java.util.*;

public class LadenActiväter {

    public static void main(String argumente[]) {


        ArrayList<Angestellte> arbeiter = new ArrayList<>();

        Angestellte ahmad = new Angestellte("ahmad ☺", Geschlächt.MAENLICH, 20);

        arbeiter.add(new Angestellte("Rani ☺", Geschlächt.MAENLICH, 32));
        arbeiter.add(new Angestellte("Lia ☻", Geschlächt.WEIBLICH, 28));
        arbeiter.add(new Angestellte("Nilo ☺", Geschlächt.MAENLICH, 16));
        arbeiter.add(new Angestellte("Karsten ☻", Geschlächt.SEHR_MAENLICH, 43));
        arbeiter.add(new Angestellte("Dani ☺", Geschlächt.DIVERS, 25));


        for (Angestellte an : arbeiter) {
            System.out.println(an.getName() + "  " + an.getGeschlecht());
        }

        Süß_Laden süßLaden = new Süß_Laden(arbeiter);


        Suesse_Sorten.CUPCAKE.setPreis(40);
        Suesse_Sorten.EISCAKE.setPreis(50);
        Suesse_Sorten.KAESEKUCHEN.setPreis(90);

        HashSet<Suesse_Sorten> ss = new HashSet<Suesse_Sorten>();

        ss.add(Suesse_Sorten.CUPCAKE);
        ss.add(Suesse_Sorten.EISCAKE);
        ss.add(Suesse_Sorten.KAESEKUCHEN);


        ahmad.verkaufe(ss, ahmad);


    }
}
