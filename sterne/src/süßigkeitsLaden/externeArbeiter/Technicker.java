package süßigkeitsLaden.externeArbeiter;

import süßigkeitsLaden.INTERN.Wartbar;


public class Technicker {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Technicker(String neuename) {
        this.setName(neuename);
    }


    public void warte(Wartbar wartbar) {

        wartbar.fuehreWartung();

        wartbar.schalteAus();
        System.out.println(wartbar + " wird von " + this + "  gewartet ");


    }

    @Override
    public String toString() {
        return this.getName();
    }

}
