package süßigkeitsLaden.Mitarbeiter;

import java.text.SimpleDateFormat;
import java.util.Date;


public class LeihArbeiter extends Angestellte {

    private String leiFirma;


    LeihArbeiter(String neueName, Geschlächt geschlechter, int neueAlter, String firma) {

        super(neueName, geschlechter, neueAlter);
        this.leiFirma = firma;
    }

    protected Long zeitStaembel() {

        java.util.Date date = new Date();

        long zeit = date.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(" mitarbeiter " + this.getName() + " hat gestaembelt " + formatter.format(zeit));
        return zeit;
    }

    protected Long AbStaembel() {

        java.util.Date date = new Date();

        long zeit = date.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(" mitarbeiter " + this.getName() + " hat gestaembelt " + formatter.format(zeit));
        return zeit;
    }

    protected void arbeitszeit() {

        System.out.println(zeitStaembel() - AbStaembel());

    }


}
