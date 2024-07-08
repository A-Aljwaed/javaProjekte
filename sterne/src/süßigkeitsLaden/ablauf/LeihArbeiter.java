package süßigkeitsLaden.ablauf;

import java.text.SimpleDateFormat;

import java.time.LocalTime;

public class LeihArbeiter extends Angestellte {

    private String leiFirma;


    LeihArbeiter(String neueName, Geschlecht geschlechter, int neueAlter, String firma) {

        super(neueName, geschlechter, neueAlter);
        this.leiFirma = firma;
    }

    protected LocalTime zeitStaembel() {

        LocalTime lt1= LocalTime.now();

        long zeit = date.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(" mitarbeiter " + this.getName() + " hat gestaembelt " + formatter.format(zeit));
        return lt1;
    }

    protected LocalTime AbStaembel() {

        LocalTime lt= LocalTime.now();
        long zeit = date.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(" mitarbeiter " + this.getName() + " hat gestaembelt " + lt);
        return lt;
    }

    protected void arbeitszeit() {

        System.out.println(AbStaembel() - zeitStaembel());

    }


}
