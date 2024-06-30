
import com.Daten_Bank_Verbindung;
import static com.Daten_Bank_Verbindung.verbindung;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import webit.script.core.ast.Statment;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ahmad
 */
public class Bestandverwalten extends javax.swing.JFrame {

    /**
     * Creates new form Buecherverwalten
     */
    
  
    DefaultTableModel model;
    
    public Bestandverwalten() {
        initComponents();
        setProdujtDeteilsToTable();
    }

    
    // um bucher in die Tabelle einzutragen
    public void setProdujtDeteilsToTable(){
          try {
           // Class.forName("com.mysql.jdbc.Driver");
            // Verbindung Aufbau                                                               
          
          Connection verbindung= DriverManager.getConnection("jdbc:mysql://localhost:3306/Lager_ms","root","");
          Statement st=verbindung.createStatement();
       ResultSet rs= st.executeQuery("select * from lager_deteils");
       
       
       while(rs.next()){
           String ReifenID=rs.getString("reifen_id");
           int Durchmesser=rs.getInt("durchmesser");
           String Hersteller=rs.getString("Hersteller");
           int menge=rs.getInt("menge");
           
           Object obj[]={ReifenID,Durchmesser,Hersteller,menge};
           
           model=(DefaultTableModel) tabelle_producktDeteils.getModel();
           
           model.addRow(obj);
           
       }
          }
          catch(Exception e){
              e.printStackTrace();
          }
        
    }
    public void produktEingabe() {
        String reifen_id = reifenID.getText();
       int durchMesser = Integer.parseInt(durchmesser.getText());
        String herSteller = hersteller.getText();
        int Menge  =Integer.parseInt(reifenmenge.getText());

        // im try catch befindet sich das Driver für jdbc was in mysql-connecter ist
        try {
           // Class.forName("com.mysql.jdbc.Driver");
            // Verbindung Aufbau                                                               
            Connection verbindung = Daten_Bank_Verbindung.getConnection();
            //   diese Abfrage wird an DB gexhickt die ? zeichen sind Platzhalter f
            String sqlAbfrage = "insert into lager_deteils(reifen_id,durchmesser,Hersteller,menge) values(?,?,?,?)";
            PreparedStatement pst = verbindung.prepareStatement(sqlAbfrage);
            // in den statment werden mittels den Platzhalter die Werte übertragen
            pst.setString(1, reifen_id);
            pst.setInt(2, durchMesser);
            pst.setString(3, herSteller);
            pst.setInt(4, Menge);

            // das zeigt die Spalten die von den Statment beeinflusst wurden
            int beeinflussteSpalten = pst.executeUpdate();
            if (beeinflussteSpalten > 0) {
                JOptionPane.showMessageDialog(this, "  Eingabe wurde erfolgreich durchgeführt");
             
            } else {
                JOptionPane.showMessageDialog(this, "  Eingabe fehlgeschlagen");
            }
          } catch (Exception e) {
            e.printStackTrace();
        }}
    
    
    
    
       public void loechen(){
        
           String id=reifenID.getText();
        String herSteller=hersteller.getText();
        try {
                Connection verbindung= DriverManager.getConnection("jdbc:mysql://localhost:3306/lager_ms","root","");
                PreparedStatement pst=verbindung.prepareStatement("delete from lager_deteils where reifen_id = ? and Hersteller = ?");
                
                pst.setString(1, id);
                pst.setString(2, herSteller);
                
                ResultSet rs=pst.executeQuery();
                if(rs.next()){
                    //JOptionPane.showConfirmDialog(this,"login war erfolgreich");
                JOptionPane.showConfirmDialog(this," Daten Erfolgreich gelöscht");
                    
                }else{
                JOptionPane.showConfirmDialog(this, " falsche Eingabe !!");
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
       
   public void aktualisieren() {
        String Reifen_id = reifenID.getText();
       int durchMesser = Integer.parseInt(durchmesser.getText());
        String herSteller = hersteller.getText();
        int Menge  =Integer.parseInt(reifenmenge.getText());

        // im try catch befindet sich das Driver für jdbc was in mysql-connecter ist
        try {
           // Class.forName("com.mysql.jdbc.Driver");
            // Verbindung Aufbau                                                               
            Connection verbindung = Daten_Bank_Verbindung.getConnection();
            //   diese Abfrage wird an DB gexhickt die ? zeichen sind Platzhalter f
            String sqlAbfrage = "update lager_deteils set durchmesser=?,Hersteller=?,menge=? where reifen_id=? ";
            PreparedStatement pst = verbindung.prepareStatement(sqlAbfrage);
            // in den statment werden mittels den Platzhalter die Werte übertragen
            pst.setString(4, Reifen_id);
            pst.setInt(1, durchMesser);
            pst.setString(2, herSteller);
            pst.setInt(3, Menge);

            // das zeigt die Spalten die von den Statment beeinflusst wurden
            int beeinflussteSpalten = pst.executeUpdate();
            if (beeinflussteSpalten > 0) {
                JOptionPane.showMessageDialog(this, "  daten wurden erfolgreich aktualisiert");
             
            } else {
                JOptionPane.showMessageDialog(this, "  Eingabe fehlgeschlagen");
            }
          } catch (Exception e) {
            e.printStackTrace();
        }}
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        reifenID = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        durchmesser = new app.bolivia.swing.JCTextField();
        jLabel16 = new javax.swing.JLabel();
        hersteller = new app.bolivia.swing.JCTextField();
        jLabel18 = new javax.swing.JLabel();
        reifenmenge = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle3 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle5 = new necesario.RSMaterialButtonCircle();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelle_producktDeteils = new rojeru_san.complementos.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ahmad\\Documents\\NetBeansProjects\\bucherei_40\\src\\main\\jFrame\\AddNewBookIcons\\icons8_Rewind_48px.png")); // NOI18N
        jLabel1.setText("zurück");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\ahmad\\Desktop\\ihleProject\\Siehle\\src\\main\\jFrame\\adminIcons\\icons8_View_Details_26px.png")); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 40, 40));

        jLabel12.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel12.setText("    ID eingeben");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 100, -1));

        reifenID.setBackground(new java.awt.Color(255, 102, 102));
        reifenID.setPlaceholder("bitte Serienummer  eingeben");
        reifenID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                reifenIDFocusLost(evt);
            }
        });
        jPanel1.add(reifenID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 270, -1));

        jLabel14.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel14.setText("Durchmesser");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 80, -1));

        durchmesser.setBackground(new java.awt.Color(255, 102, 102));
        durchmesser.setPlaceholder("bitte geben Sie das Durchmesser ein");
        durchmesser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                durchmesserFocusLost(evt);
            }
        });
        jPanel1.add(durchmesser, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 270, -1));

        jLabel16.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel16.setText("Hersteller");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 80, -1));

        hersteller.setBackground(new java.awt.Color(255, 102, 102));
        hersteller.setPlaceholder("bitte geben Sie  Name des Herstellers ein");
        hersteller.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                herstellerFocusLost(evt);
            }
        });
        jPanel1.add(hersteller, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 270, -1));

        jLabel18.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel18.setText("Menge");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 80, -1));

        reifenmenge.setBackground(new java.awt.Color(255, 102, 102));
        reifenmenge.setPlaceholder("bitte geben Sie die Menge ein");
        reifenmenge.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                reifenmengeFocusLost(evt);
            }
        });
        jPanel1.add(reifenmenge, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 270, -1));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(51, 0, 0));
        rSMaterialButtonCircle3.setText("Hinfügen");
        rSMaterialButtonCircle3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle3MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 150, 60));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(51, 0, 0));
        rSMaterialButtonCircle4.setText("Aktualisieren");
        rSMaterialButtonCircle4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle4MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 570, 150, 60));

        rSMaterialButtonCircle5.setBackground(new java.awt.Color(51, 0, 0));
        rSMaterialButtonCircle5.setText("Löschen");
        rSMaterialButtonCircle5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle5MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle5ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 570, 90, 60));

        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\ahmad\\Desktop\\ihleProject\\Siehle\\src\\main\\jFrame\\adminIcons\\icons8_View_Details_26px.png")); // NOI18N
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 40, 40));

        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\ahmad\\Desktop\\ihleProject\\Siehle\\src\\main\\jFrame\\adminIcons\\icons8_View_Details_26px.png")); // NOI18N
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 40, 40));

        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Users\\ahmad\\Desktop\\ihleProject\\Siehle\\src\\main\\jFrame\\adminIcons\\icons8_View_Details_26px.png")); // NOI18N
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 820));

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("zurück");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, -1, -1));

        tabelle_producktDeteils.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "reifenID", "Durchmesser", "Hersteller", "Menge"
            }
        ));
        tabelle_producktDeteils.setColorBackgoundHead(new java.awt.Color(255, 51, 51));
        tabelle_producktDeteils.setRowHeight(40);
        tabelle_producktDeteils.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelle_producktDeteilsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelle_producktDeteils);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 700, 220));

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ahmad\\Desktop\\ihleProject\\uniroyal-tyre-size-black.jpg")); // NOI18N
        jLabel3.setText("Bestand Verwalten");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        jPanel5.setBackground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 200, 5));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 1030, 820));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reifenIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_reifenIDFocusLost

    }//GEN-LAST:event_reifenIDFocusLost

    private void durchmesserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_durchmesserFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_durchmesserFocusLost

    private void herstellerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_herstellerFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_herstellerFocusLost

    private void reifenmengeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_reifenmengeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_reifenmengeFocusLost

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tabelle_producktDeteilsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelle_producktDeteilsMouseClicked
int rowNo=tabelle_producktDeteils.getSelectedRow();
TableModel model=tabelle_producktDeteils.getModel();

reifenID.setText(model.getValueAt(rowNo, 0).toString());
durchmesser.setText(model.getValueAt(rowNo, 1).toString());
hersteller.setText(model.getValueAt(rowNo, 2).toString());
reifenmenge.setText(model.getValueAt(rowNo, 3).toString());
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelle_producktDeteilsMouseClicked

    private void rSMaterialButtonCircle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3MouseClicked
     produktEingabe();
        
    }//GEN-LAST:event_rSMaterialButtonCircle3MouseClicked

    private void rSMaterialButtonCircle5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5MouseClicked
loechen();        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle5MouseClicked

    private void rSMaterialButtonCircle4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4MouseClicked
aktualisieren();
new Bestandverwalten().setVisible(true);
this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle4MouseClicked

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
            java.util.logging.Logger.getLogger(Bestandverwalten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bestandverwalten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bestandverwalten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bestandverwalten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bestandverwalten().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.bolivia.swing.JCTextField durchmesser;
    private app.bolivia.swing.JCTextField hersteller;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle5;
    private app.bolivia.swing.JCTextField reifenID;
    private app.bolivia.swing.JCTextField reifenmenge;
    private rojeru_san.complementos.RSTableMetro tabelle_producktDeteils;
    // End of variables declaration//GEN-END:variables
}
