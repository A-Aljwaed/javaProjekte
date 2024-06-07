package süßigkeitsLaden.INTERN;


import süßigkeitsLaden.ablauf.Breisbar;

public class KAFFEE extends Getraenke_Automat {
    private String bezeichnung;
    private String kaffeesorte;
    private int füllstand;


    public KAFFEE(String neuebezeichnung, Integer füllstand1, Sorte kaffeesorte) {
        super(neuebezeichnung, füllstand1);


        this.setKaffeesorte(kaffeesorte);
    }


    private void setKaffeesorte(Sorte sorte) {
        this.kaffeesorte = sorte.toString();
    }

    public KAFFEE(String neuebezeichnung, Sorte sorte, int neuefüllstand) {
        super(neuebezeichnung, neuefüllstand);

        setKaffeesorte(sorte);

    }

    public String fueleBohne(Integer mengeinProzent) {
        Integer bisher = getFüllstand();
        int fuel = Math.min(100, bisher + mengeinProzent);
        mengeinProzent = fuel - bisher;

        return getBezeichnung() + "  wurde  mit " + mengeinProzent + " %  Bohnen aufgefühlt";
    }

    public String getKaffeesorte() {
        return kaffeesorte;
    }

    public String getBeschreibung() {
        return " Automat " + getBezeichnung() + " mit fuelstand " + getFüllstand() + " in " + getKaffeesorte();


    }


    @Override
    public void shalteAn() {
        System.out.println(this.getBezeichnung() + " wird eingeschaltet");
    }

    @Override
    public void schalteAus() {
        System.out.println(this.getBezeichnung() + " wird ausgeschaltet");
    }

    @Override
    public void fuehreWartung() {
        System.out.println(this.getBezeichnung() + " heizkörber muss getauscht");

    }


}

