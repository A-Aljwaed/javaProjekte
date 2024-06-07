package süßigkeitsLaden.INTERN;

public class Softdrinks extends Getraenke_Automat {
    public String getSoftdrinksorte() {
        return softdrinksorte;
    }

    private String softdrinksorte;


    public Softdrinks(String neuebezeichnung, Softdrinks_sorte softdrinksorte, int neuefüllstand) {
        super(neuebezeichnung, neuefüllstand);

        this.setSoftdrink(softdrinksorte);

    }


    public void fueleSirup(Integer mengeinProzent) {
        Integer prozentAufgefuehlt = fueleAuf(mengeinProzent);
        System.out.println(getBezeichnung() + "  wurde  mit " + prozentAufgefuehlt + "  % Sirup   aufgefühlt");
    }

    private void setSoftdrink(Softdrinks_sorte sorte) {
        this.softdrinksorte = sorte.name();
    }

    public String getBeschreibung() {
        return " Automat " + getBezeichnung() + " mit fuelstand " + getFüllstand() + " in " + getSoftdrinksorte();
    }


    @Override
    public void shalteAn() {
        System.out.println(this.getBezeichnung() + "  wird eingeschaltet");
    }

    @Override
    public void schalteAus() {
        System.out.println(this.getBezeichnung() + "  wird ausgeschaltet");
    }

    @Override
    public void fuehreWartung() {
        System.out.println(this.getBezeichnung() + " kuhler muss getauscht");

    }


}
