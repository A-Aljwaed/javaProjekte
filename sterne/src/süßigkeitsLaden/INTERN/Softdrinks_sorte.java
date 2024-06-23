package süßigkeitsLaden.INTERN;

import süßigkeitsLaden.ablauf.Breisbar;

public enum Softdrinks_sorte implements Breisbar {

    COLA,
    FANTA,
    SPRIT;

    @Override
    public Double getPreis() {
        return preis;
    }

    private Double preis;

    public void setPreis(String neuerPreis) {

        if (neuerPreis.matches("[\\d]{0,3}[.]{0,1}[\\d]+")) {
            this.preis = Double.parseDouble(neuerPreis);
        } else {
            throw new IllegalArgumentException(" bitte überprüfen Sie die Preise der Softdrinks!!!!");
        }
    }

    @Override
    public String toString() {
        String re = name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase();
        return re;
    }


}
