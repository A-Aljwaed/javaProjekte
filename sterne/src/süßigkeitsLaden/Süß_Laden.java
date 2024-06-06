package süßigkeitsLaden;

import java.util.ArrayList;

import static süßigkeitsLaden.Geschlächt.*;

class Süß_Laden {

    private ArrayList<Angestellte> arbeiterteam;


    Süß_Laden(ArrayList<Angestellte> dasTeam) {
        this.setArbeiterteam(dasTeam);

        for (Angestellte an : dasTeam) {
            if (an.getGeschlecht().equalsIgnoreCase(WEIBLICH.getName())) {
                System.out.println("süßladen ist bereit und " + an.getName() + " war als  " + (dasTeam.indexOf(an) + 1) + "e am start");
            } else {
                System.out.println("süßladen ist bereit und " + an.getName() + " war als  " + (dasTeam.indexOf(an) + 1) + "er am start");
            }
        }
    }


    public ArrayList<Angestellte> getArbeiterteam() {
        return arbeiterteam;
    }

    public void setArbeiterteam(ArrayList<Angestellte> arbeiterteam) {
        this.arbeiterteam = arbeiterteam;
    }
}
