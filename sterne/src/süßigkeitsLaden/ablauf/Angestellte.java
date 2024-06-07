package süßigkeitsLaden.ablauf;



public class Angestellte {

    public int getAlter() {
        return alter;
    }

    private void setAlter(int alter) {
        this.alter = alter;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getGeschlecht() {
        return geschlecht.getName();
    }

    private void setGeschlecht(Geschlecht geschlecht) {
        this.geschlecht = geschlecht;
    }

    private String name;
    private int alter;
    private Geschlecht geschlecht;


    Angestellte(String neueName, Geschlecht geschlechter, int neueAlter) {

        if (neueName.matches("[\\p{Alpha}]{2,20}[\\D]")) {
            this.setName(neueName);
        } else {
            throw new IllegalArgumentException("bitte überprüfen Sie Mitarbeiter Namen");
        }


        if (neueAlter < 18) {
            try {
                throw new IllegalArgumentException("mitarbeiter darf nicht unter 18 sein" +
                        " bitte überprüfen !!!");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (neueAlter > 68) {
            try {
                throw new IllegalArgumentException("mitarbeiter hat Rentenalter erreicht !" +
                        " bitte überprüfen !!!");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            this.setAlter(neueAlter);
            this.setGeschlecht(geschlechter);

        }
    }


    protected void verkaufe(Breisbar... sorten) {


        Double rechnung1 = 0.0;

        for (Breisbar sss : sorten) {
            System.out.println(this.getName() + " hat " + sss + " für " + sss.getPreis() + " € verkauft");
            rechnung1 += sss.getPreis();
        }
        System.out.println("Rechnung Betrag " + rechnung1 + " €");

//        String abfrage = "insert into MitarbeiterDaten values(?,?) ";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//
//
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MitarbeiterDaten", "root", "");
//
//            PreparedStatement st = connection.prepareStatement(abfrage);
//            st.setString(1, this.getName());
//            st.setDouble(2, rechnung1);
//            st.executeUpdate();
//
//            st.close();
//            connection.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }


    public String toString() {
        return this.getName();
    }


}
