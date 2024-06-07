package süßigkeitsLaden.Mitarbeiter;

public enum Suesse_Sorten implements Breisbar{

    CUPCAKE,
    EISCAKE,
    KAESEKUCHEN,
    KAFFEEKUCHEN,
    SAHNEKUCHEN;


    public Double getPreis() {
        return preis;
    }

    private Double preis;

    public void setPreis(String neuerPreis) {

        if(neuerPreis.matches("[\\d]{0,3}[.]{0,1}[\\d]+")){
        this.preis = Double.parseDouble(neuerPreis);}
        else {
            throw new IllegalArgumentException(" bitte überprüfen Sie die Preise   der Süssware !!!!");
        }
    }

    public String toString() {
        String re = name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase();
        return re;

    }


}
