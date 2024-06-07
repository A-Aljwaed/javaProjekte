package süßigkeitsLaden;

import jdk.jfr.Timestamp;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.SortedSet;
import java.sql.DriverManager;

public class Angestellte {

    public int getAlter() {
        return alter;
    }

    private void setAlter(int alter) {
        this.alter = alter;
    }

    protected String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getGeschlecht() {
        return geschlecht.getName();
    }

    private void setGeschlecht(Geschlächt geschlecht) {
        this.geschlecht = geschlecht;
    }

    private String name;
    private int alter;
    private Geschlächt geschlecht;


    Angestellte(String neueName, Geschlächt geschlechter, int neueAlter) {

        if (neueName.matches("[\\w]+[\\D]")) {
            this.setName(neueName);
        } else {
            throw new IllegalArgumentException("bitte überprüfen Sie Mitarbeiter Namen");
        }


        if (neueAlter < 18) {

            throw new IllegalArgumentException("mitarbeiter darf nicht unter 18 sein");

        } else if (neueAlter > 68) {

            throw new IllegalArgumentException("mitarbeiter hat Rentenalter erreicht !");

        } else {
            this.setAlter(neueAlter);
            this.setGeschlecht(geschlechter);

        }
    }


    protected void verkaufe(Suesse_Sorten... suesseSortens) {
        Double rechnung1 = 0.0;

        for (Suesse_Sorten sss : suesseSortens) {
            System.out.println(this.getName() + " hat " + sss + " für " + sss.getPreis() + " € verkauft");
            rechnung1 += sss.getPreis();
        }
        System.out.println("Rechnung Betrag " + rechnung1 + " €");

        String abfrage = "insert into MitarbeiterDaten values(?,?) ";
        try {
            Class.forName("com.mysql.jdbc.Driver");


            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MitarbeiterDaten", "root", "");

            PreparedStatement st = connection.prepareStatement(abfrage);
            st.setString(1, this.getName());
            st.setDouble(2, rechnung1);
            st.executeUpdate();

            st.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String toString() {
        return this.getName();
    }
}
