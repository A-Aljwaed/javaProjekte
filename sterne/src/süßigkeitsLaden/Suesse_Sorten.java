package süßigkeitsLaden;

public enum Suesse_Sorten {

    CUPCAKE,
    EISCAKE,
    KAESEKUCHEN,
    KAFFEEKUCHEN,
    SAHNEKUCHEN;


    Suesse_Sorten() {

    }

    public int getPreis() {
        return preis;
    }

    private int preis;

    public void setPreis(Integer neuerPreis) {
        this.preis = neuerPreis;
    }

    public String getName() {
        String re = name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase();
        return re;

    }


}
