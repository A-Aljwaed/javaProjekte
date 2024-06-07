package süßigkeitsLaden.ablauf;

import java.util.Date;
import java.util.LinkedList;

import static süßigkeitsLaden.ablauf.Geschlächt.*;

class Süß_Laden {


    private Date offnungszeit;

    private LinkedList<Angestellte> arbeiterteam;


    Süß_Laden(LinkedList<Angestellte> dasTeam) {
if (dasTeam.isEmpty()){
    throw new IllegalArgumentException("bitte bereiten Sie einen Team vor");
}else if(dasTeam.size()>11){
    try {
        throw new IllegalArgumentException("komisch !!! es sind mehr Mitarbeiter als nötig da!!!");
    }catch (Exception e){
        e.printStackTrace();
    }
        }else{
        this.setArbeiterteam(dasTeam);}

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

    public void getOffnungszeit() {

        System.out.println("laden wurde am |||||||||" + offnungszeit + "  |||||||||||||| geöffnet");
    }


    protected void offnen() {

        Date l = new Date();
        offnungszeit = l;
    }
}
