package süßigkeitsLaden.INTERN;

public class Kasse implements Wartbar {
    private int kassenummer;

    public Kasse(int nummer) {
        if (nummer > 10) {
            throw new IllegalArgumentException("Kassenanzahl erreicht");
        } else
            this.kassenummer = nummer;
        this.setKassenKennung("KASSE-- " + nummer);
    }

    public String getKassenKennung() {
        return kassenKennung;
    }

    private void setKassenKennung(String kassenKennung) {
        this.kassenKennung = kassenKennung;
    }

    private String kassenKennung;


    @Override
    public String toString() {
        return getKassenKennung();
    }

    @Override
    public void shalteAn() {
        System.out.println(getKassenKennung() + " wird eingeschaltet");
    }

    @Override
    public void schalteAus() {
        System.out.println(getKassenKennung() + " wird ausgeschaltet");
    }

    @Override
    public void fuehreWartung() {
        System.out.println(this.getKassenKennung() + "  braucht WARTUNG");
    }
}
