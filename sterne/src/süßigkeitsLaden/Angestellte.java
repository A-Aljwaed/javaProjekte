package süßigkeitsLaden;

import java.util.HashSet;
import java.util.SortedSet;

public class Angestellte {

    public int getAlter() {
        return alter;
    }

    private void setAlter(int alter) {
        this.alter = alter;
    }

    protected String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getGeschlecht() {
        return geschlecht.getName();
    }

    private void setGeschlecht(Geschlächt geschlecht) {
        this.geschlecht = geschlecht;
    }

    private String name;
    private int alter;
    private Geschlächt geschlecht;


    Angestellte(String neueName, Geschlächt geschlechter, int neueAlter) {

        if (neueAlter < 18) {

                throw new IllegalArgumentException("mitarbeiter darf nicht unter 18 sein");

            }

        else if (neueAlter > 68) {

                throw new IllegalArgumentException("mitarbeiter hat Rentenalter erreicht !");

        } else {
            this.setAlter(neueAlter);
            this.setGeschlecht(geschlechter);
            this.setName(neueName);
        }
    }


    protected void verkaufe(HashSet<Suesse_Sorten> suesseSorten, Angestellte angestellte) {
        Integer rechnung = 0;
        for (Suesse_Sorten ss : suesseSorten) {

            System.out.println(this.getName() + " hat " + ss.getName() + " für " + ss.getPreis() + " € verkauft");
            rechnung += ss.getPreis();
        }
        System.out.println("Rechnung Betrag " + rechnung + " €");
    }


}
