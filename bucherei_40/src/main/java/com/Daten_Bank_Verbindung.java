/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ahmad
 */
public class Daten_Bank_Verbindung {
    
/**
 *
 * @author ahmad
 */

    
  public  static Connection verbindung=null;
    
    // jedes Mal wenn wir Verbindung zum DatenBank herstellen , rufen wir einfach diese Methode
    public static Connection getConnection(){
                try{
    Class.forName("com.mysql.jdbc.Driver");
    // Verbindung Aufbau                                                                 //root=username   //password ist leer
     verbindung = DriverManager.getConnection("jdbc:mysql://localhost:3306/bucherei_ms","root","");
}catch(Exception e){
    e.printStackTrace();
}return verbindung;
    }
}


