package süßigkeitsLaden.ablauf;

public enum Geschlecht {

    MAENLICH,
    WEIBLICH,
    SEHR_MAENLICH,
    DIVERS;


    public String getName() {
        String re = name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase();
        return re;

    }


}
