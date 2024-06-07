package süßigkeitsLaden.Mitarbeiter;

import java.util.Date;
import java.util.LinkedList;

import static süßigkeitsLaden.Mitarbeiter.Geschlächt.*;

class Süß_Laden {


    private Date offnungszeit;

    private LinkedList<Angestellte> arbeiterteam;


    Süß_Laden(LinkedList<Angestellte> dasTeam) {

        this.setArbeiterteam(dasTeam);

        for (Angestellte an : dasTeam) {
            if (an.getGeschlecht().equalsIgnoreCase(WEIBLICH.getName())) {
                System.out.println("süßladen ist bereit und " + an + " war als  " + (dasTeam.indexOf(an) + 1) + "e am start");
            } else {
                System.out.println("süßladen ist bereit und " + an + " war als  " + (dasTeam.indexOf(an) + 1) + "er am start");
            }
        }
    }


    public LinkedList<Angestellte> getArbeiterteam() {
        return arbeiterteam;
    }

    public void setArbeiterteam(LinkedList<Angestellte> arbeiterteam) {
        this.arbeiterteam = arbeiterteam;
    }

    public String getOffnungszeit() {

        return "laden wurde am |||||||||" + offnungszeit + "  |||||||||||||| geöffnet";
    }




    protected void offnen() {

        Date l = new Date();
        offnungszeit = l;
    }
}
