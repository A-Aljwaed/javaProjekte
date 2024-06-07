package süßigkeitsLaden.INTERN;

public abstract class Getraenke_Automat implements Wartbar {

    private String bezeichnung;

    private int füllstand;


    public Getraenke_Automat(String neuebezeichnung, int neuefüllstand) {
        setBezeichnung(neuebezeichnung);

        setFüllstand(neuefüllstand);
    }

    private final void setBezeichnung(String neuebezeichnung) {
        this.bezeichnung = neuebezeichnung;

        if (neuebezeichnung == null || neuebezeichnung.equals("(\\s)")) {
            throw new IllegalArgumentException("keine gültige angabe drf nicht leer sein");
        } else bezeichnung = neuebezeichnung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }


    final private void setFüllstand(int neuefüllstand) {
     /* if ( neuefüllstand <0){
           throw new IllegalArgumentException("darf nicht kleiner als null sein");
       } else if (neuefüllstand==0) {System.out.println("bitte nachfüllen");
       } else if (neuefüllstand>100) {
           throw new IllegalArgumentException("darf 100 nicht überschreiten");
       } else*/
        füllstand = neuefüllstand;
    }


    public int getFüllstand() {
        return füllstand;
    }


    final protected Integer fueleAuf(Integer fuehler) {

        Integer bisher = getFüllstand();
        int fuel = Math.min(100, bisher + fuehler);
        Integer prozentbohnenaufgefühlt = fuel - bisher;
        System.out.println("fuel: " + fuel);
        setFüllstand(fuehler + getFüllstand());

        return prozentbohnenaufgefühlt;

    }

    public String getBeschreibung() {
        return getBezeichnung() + "mit füllstand  " + getFüllstand() + " %";
    }

    abstract public void fuehreWartung();


    public void schalteAus(Getraenke_Automat ga) {

        System.out.println(ga.getBezeichnung() + " wird ausgeschaltet");

    }

    public void shalteAn(Getraenke_Automat ga) {
        System.out.println(this.getBezeichnung() + "  wird eingeschaltet");
    }

    @Override
    public String toString() {
        return this.getBeschreibung();


    }
}


