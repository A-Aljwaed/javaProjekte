
import com.Daten_Bank_Verbindung;
import static com.Daten_Bank_Verbindung.verbindung;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class signUpSeite extends javax.swing.JFrame {

    /**
     * Creates new form signUpSeite
     */
    public signUpSeite() {
        initComponents();
    }
    
       // um die werte aus sign_up seite in Nutzertabelle ein zu geben
    public void signUpEingabe() {
        String name = nutzername.getText();
        String passwort = passwortFeld.getText();
        String e_Mail = eMailFeld.getText();
        String kontakt = handyFeld.getText();

        // im try catch befindet sich das Driver für jdbc was in mysql-connecter ist
        try {
           // Class.forName("com.mysql.jdbc.Driver");
            // Verbindung Aufbau                                                               
            Connection verbindung = Daten_Bank_Verbindung.getConnection();
            //   diese Abfrage wird an DB gexhickt die ? zeichen sind Platzhalter f
            String sqlAbfrage = "insert into nutzer(name,PASSWORD,email,contact) values(?,?,?,?)";
            PreparedStatement pst = verbindung.prepareStatement(sqlAbfrage);
            // in den statment werden mittels den Platzhalter die Werte übertragen
            pst.setString(1, name);
            pst.setString(2, passwort);
            pst.setString(3, e_Mail);
            pst.setString(4, kontakt);

            // das zeigt die Spalten die von den Statment beeinflusst wurden
            int beeinflussteSpalten = pst.executeUpdate();
            if (beeinflussteSpalten > 0) {
                JOptionPane.showMessageDialog(this, "  Eingabe wurde erfolgreich durchgeführt");
                LoginSeite lgs=new LoginSeite();
                lgs.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "  Eingabe fehlgeschlagen");
            }

            // um aber nicht jedes mal das try catch Block zu schreiben , wird DatenBank_Connection Classe erstellt
        } catch (Exception e) {
            e.printStackTrace();
        }}
//validieren 
    public boolean validesRegistrieren(){
          String name = nutzername.getText();
        String passwort = passwortFeld.getText();
        String e_Mail = eMailFeld.getText();
        String kontakt = handyFeld.getText();

        if (name.equals("")){
            JOptionPane.showConfirmDialog(this,"Bitte geben Sie eine Gülltige Nutzername ein");
return false;  
        
        }      if (passwort.equals("")){
            JOptionPane.showConfirmDialog(this,"Bitte geben Sie eine Gülltiges Passwort ein");
return false;  
        
        }      if (e_Mail.equals("")|| !e_Mail.matches("^.+@siehle.de")){
            JOptionPane.showConfirmDialog(this,"Bitte geben Sie eine Gülltige EmailAdresse ein");
return false;  
        
        }      if (kontakt.equals("")){
            JOptionPane.showConfirmDialog(this,"Bitte geben Sie eine Gülltige Handynummer ein");
return false;  
        
        }
        return true;
        
    }
    
    // Redundanz Prüfen
    //schickt eine SQL abfrage um zu pruefen ob der Nuzer schon vorliegt
    public boolean pruefeRedundanz(){
        
       String name = nutzername.getText();
       boolean vorhanden=false;
       try{
        Connection verbindung= DriverManager.getConnection("jdbc:mysql://localhost:3306/lager_ms","root","");
        PreparedStatement pst=verbindung.prepareCall("select * from nutzer where name= ?");
        pst.setString(1, name);
        ResultSet ergebniss = pst.executeQuery();

if(ergebniss.next()){
vorhanden=true;}
else {
    vorhanden =false;}

       }
       
       catch(Exception e){
           e.printStackTrace();
       }
        
    return vorhanden;    
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jFrame3 = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();
        nutzername = new app.bolivia.swing.JCTextField();
        eMailFeld = new app.bolivia.swing.JCTextField();
        passwortFeld = new app.bolivia.swing.JCTextField();
        handyFeld = new app.bolivia.swing.JCTextField();
        jLabel19 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(153, 153, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 50, -1));

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel5.setText("E-mail Addresse");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 110, -1));

        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Haben Sie kein Konto");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Erstellen Sie Ihren Konto");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 140, -1));

        jLabel8.setText("jLabel8");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lager Bereich");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Willkommen");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 130, 30));

        jPanel5.setBackground(new java.awt.Color(51, 102, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, -1, -1));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ahmad\\Desktop\\ihleProject\\Firefly i need a company logo thats name is Siehle(R) , the background should be in red and the logo(2).jpg")); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 790));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 800));

        jPanel9.setBackground(new java.awt.Color(172, 35, 75));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(188, 91, 91));
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 20, -1));

        jLabel10.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("jetzt Konto anlegen");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\ahmad\\Documents\\NetBeansProjects\\bucherei_40\\src\\main\\jFrame\\adminIcons\\male_user_50px.png")); // NOI18N
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 50, 40));

        jLabel12.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel12.setText("Nutzer-Name");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 80, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\ahmad\\Documents\\NetBeansProjects\\bucherei_40\\src\\main\\jFrame\\icons\\icons8_Secured_Letter_50px.png")); // NOI18N
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 40));

        jLabel14.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel14.setText("E-Mail");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\ahmad\\Documents\\NetBeansProjects\\bucherei_40\\src\\main\\jFrame\\icons\\icons8_Secure_50px.png")); // NOI18N
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 40, 40));

        jLabel16.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel16.setText("Passwort");
        jPanel9.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        jLabel17.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel17.setText("Handy-Nummer");
        jPanel9.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\ahmad\\Documents\\NetBeansProjects\\bucherei_40\\src\\main\\jFrame\\icons\\icons8_Google_Mobile_50px.png")); // NOI18N
        jPanel9.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 102, 102));
        rSMaterialButtonCircle1.setText("Registrieren");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel9.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 280, 60));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 204, 204));
        rSMaterialButtonCircle2.setForeground(new java.awt.Color(255, 102, 102));
        rSMaterialButtonCircle2.setText("Einlogen");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel9.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 620, 190, 50));

        nutzername.setBackground(new java.awt.Color(255, 204, 204));
        nutzername.setPlaceholder("bitte geben Sie Ihen Name ein");
        nutzername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nutzernameFocusLost(evt);
            }
        });
        jPanel9.add(nutzername, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        eMailFeld.setBackground(new java.awt.Color(255, 204, 204));
        eMailFeld.setPlaceholder("geben Sie Ihre E-Mail Adresse");
        jPanel9.add(eMailFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        passwortFeld.setBackground(new java.awt.Color(255, 204, 204));
        passwortFeld.setPlaceholder("geben Sie ein Starkes Passwort[ab 8 Zeichen]");
        passwortFeld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwortFeldActionPerformed(evt);
            }
        });
        jPanel9.add(passwortFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        handyFeld.setBackground(new java.awt.Color(255, 204, 204));
        handyFeld.setPlaceholder("geben Sie Ihre Handy Nummer");
        jPanel9.add(handyFeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, -1, -1));

        jLabel19.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Haben Sie keinen Konto");
        jPanel9.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 170, -1));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 0, 370, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void passwortFeldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwortFeldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwortFeldActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
if(validesRegistrieren()==true){  
    if(pruefeRedundanz()==false){
                             signUpEingabe(); }     }     
//else if (pruefeRedundanz()==true){
  //  JOptionPane.showConfirmDialog(this, "Nutzername liegt schon vor!!!");
    //   } 
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        System.exit(0);
        
    }//GEN-LAST:event_jLabel9MouseClicked

    private void nutzernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nutzernameFocusLost
       if(pruefeRedundanz()==true){
           JOptionPane.showConfirmDialog(this, "die Name liegt schon vor");
       }
    }//GEN-LAST:event_nutzernameFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(signUpSeite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signUpSeite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signUpSeite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signUpSeite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signUpSeite().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.bolivia.swing.JCTextField eMailFeld;
    private app.bolivia.swing.JCTextField handyFeld;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private app.bolivia.swing.JCTextField nutzername;
    private app.bolivia.swing.JCTextField passwortFeld;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    // End of variables declaration//GEN-END:variables
}
