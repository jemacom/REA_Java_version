/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import DAO.classes.FavorisDAO;
import de.javasoft.plaf.synthetica.SyntheticaBlueLightLookAndFeel;
import entities.Util;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author jemacom
 */
public class Acceuil_client extends javax.swing.JFrame {

     private JPopupMenu popup;
    /**
     * Creates new form Acceuil
     */
    public Acceuil_client() {
        initComponents();
       login_agent_connecte.setText("Bonjour  "+Util.login_agent_connecte+" ;) ");
        this.setLocationRelativeTo(null);
        login_agent_connecte.setIcon(createIcon("/images/home.gif"));
        popup = new JPopupMenu();
       
        JMenuItem FavorisItem =  new JMenuItem("Ajouter aux favoris");
        popup.add(FavorisItem);
        table_offres.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                JTable table =(JTable) e.getSource();
                Point p = e.getPoint();
                int row = table.rowAtPoint(p);
                
                
                System.out.println(row);
                if (e.getButton() ==  MouseEvent.BUTTON3){
                    popup.show(table , e.getX() , e.getY());
                }
            }
            
        });
        FavorisItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int row =table_offres.getSelectedRow(); 
               int ID = (int)table_offres.getModel().getValueAt(table_offres.getSelectedRow(), 10);
               boolean trouve = FavorisDAO.getInstance().rechercherFavoris(ID);
               if (trouve){
                   JOptionPane.showMessageDialog(null, "l'offre est déjà dans la votre liste favoris", "Information", 1);
               }else{
                    System.out.println("my id "+table_offres.getModel().getValueAt(table_offres.getSelectedRow(), 10));
                    FavorisDAO.getInstance().insertFavoris(ID);
                    JOptionPane.showMessageDialog(null, "L'offre est MAINTENANT dans votre liste favoris !", "Information", 1);
               }
               
              
               
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        bt_mon_compte = new javax.swing.JButton();
        bt_recherche = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_offres = new javax.swing.JTable();
        login_agent_connecte = new javax.swing.JLabel();
        bt_mes_favoris = new javax.swing.JButton();
        bt_a_propos = new javax.swing.JButton();
        bt_mes_offres = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bt_contact = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bt_mon_compte.setText("Mon compte");
        bt_mon_compte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_mon_compteActionPerformed(evt);
            }
        });

        bt_recherche.setText("Recherche Avancee");
        bt_recherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_rechercheActionPerformed(evt);
            }
        });

        table_offres.setModel(new ListOffreValide());
        table_offres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_offresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_offres);

        login_agent_connecte.setText("Acceuil client:");

        bt_mes_favoris.setText("Mes favoris");
        bt_mes_favoris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_mes_favorisActionPerformed(evt);
            }
        });

        bt_a_propos.setText("A propos");
        bt_a_propos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_a_proposActionPerformed(evt);
            }
        });

        bt_mes_offres.setText("Mes offres");
        bt_mes_offres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_mes_offresActionPerformed(evt);
            }
        });

        jLabel1.setText("Liste des offres disponibles :");

        jButton1.setText("Déconnecter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bt_contact.setText("Contact");
        bt_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_contactActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(login_agent_connecte, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 443, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_a_propos)
                    .addComponent(bt_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_recherche)
                    .addComponent(bt_mes_offres)
                    .addComponent(bt_mes_favoris)
                    .addComponent(bt_mon_compte, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(login_agent_connecte, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(bt_mon_compte)
                        .addGap(31, 31, 31)
                        .addComponent(bt_mes_favoris)
                        .addGap(23, 23, 23)
                        .addComponent(bt_mes_offres)
                        .addGap(34, 34, 34)
                        .addComponent(bt_recherche)
                        .addGap(30, 30, 30)
                        .addComponent(bt_contact)
                        .addGap(18, 18, 18)
                        .addComponent(bt_a_propos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_mon_compteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_mon_compteActionPerformed
        CompteClient cc = new CompteClient();
        cc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bt_mon_compteActionPerformed

    private ImageIcon createIcon(String path){
        URL url = getClass().getResource(path);
        if (url == null){
            System.err.println("Unable de load the image !"+path);
            return null;
        }
        
        ImageIcon icon = new ImageIcon(url);
        return icon;
        
    }
    private void bt_rechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_rechercheActionPerformed
        RechercheAvancee ra = new RechercheAvancee();
        ra.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bt_rechercheActionPerformed

    private void bt_a_proposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_a_proposActionPerformed
        Apropos ap = new Apropos();
        ap.setVisible(true);
        
    }//GEN-LAST:event_bt_a_proposActionPerformed

    private void bt_mes_favorisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_mes_favorisActionPerformed
        Client_MesFavoris cmf = new Client_MesFavoris();
        cmf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bt_mes_favorisActionPerformed

    private void bt_mes_offresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_mes_offresActionPerformed
        Client_MesOffres mo = new Client_MesOffres();
        mo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bt_mes_offresActionPerformed

    private void table_offresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_offresMouseClicked
        if (evt.getClickCount() == 2) {
                new DetailOffre().setVisible(true);
            }
        
    }//GEN-LAST:event_table_offresMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Util.id_agent_connecte = 0;
        Util.role_agent_connecte = "";
        Util.login_agent_connecte = "";
        Util.nom_agent_connecte = "";
        Util.prenom_agent_connecte = "";
        Util.adresse_agent_connecte = "";
        Util.email_agent_connecte = "";
        Util.telephone_agent_connecte ="";        
        Authentification au = new Authentification();
        au.setVisible(true);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
//        System.exit(WIDTH);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_contactActionPerformed
        Message_client mc = new Message_client();
        mc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bt_contactActionPerformed
    
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
            java.util.logging.Logger.getLogger(Acceuil_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acceuil_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acceuil_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acceuil_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    UIManager.setLookAndFeel(new SyntheticaBlueLightLookAndFeel());
                    
                    new Acceuil_client().setVisible(true);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Acceuil_client.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Acceuil_client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_a_propos;
    private javax.swing.JButton bt_contact;
    private javax.swing.JButton bt_mes_favoris;
    private javax.swing.JButton bt_mes_offres;
    private javax.swing.JButton bt_mon_compte;
    private javax.swing.JButton bt_recherche;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel login_agent_connecte;
    private javax.swing.JTable table_offres;
    // End of variables declaration//GEN-END:variables

}
