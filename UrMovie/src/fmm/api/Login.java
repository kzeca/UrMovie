/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.api;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pichau
 */
public class Login extends javax.swing.JFrame {

    
    public boolean consultar(String login, String senha) throws ClassNotFoundException {
        boolean autenticado = false;
        String sql;
        try {
            
        String myDriver = "com.mysql.jdbc.Driver";
        String myUrl = "jdbc:mysql://127.0.0.1:3306/urmovie";
        Class.forName(myDriver);
        Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "1234");

            sql = "SELECT login, senha, email, id FROM usuarios WHERE login=? and senha=?";
            PreparedStatement ps;
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            
            ResultSet rs;
            rs = ps.executeQuery();

            if (rs.next()) {
                String user = rs.getString("login");
                String pass = rs.getString("senha");
                Usuario usuario = new Usuario(); 
                usuario.email = rs.getString("email");
                Usuario.id = rs.getInt("id");
                autenticado = true;
            } else {
                ps.close();
                return autenticado;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        return autenticado;
    }

    public Login() {
        initComponents();
        txtUsername.setBackground(new Color(0, 0, 0, 0));
        txtPassword.setBackground(new Color(0, 0, 0, 0));
        txtUsername.setVisible(false);
        txtPassword.setVisible(false);
        setSize(491, 400);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPassword = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCriar = new javax.swing.JLabel();
        lblEsqueceu = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPassword.setText("PASSWORD");
        lblPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPasswordMouseClicked(evt);
            }
        });
        jPanel1.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, -1, 50));

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUsername.setText("USERNAME");
        lblUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUsernameMouseClicked(evt);
            }
        });
        jPanel1.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 90, 50));

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setBorder(null);
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 250, 30));

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsername.setBorder(null);
        txtUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUsername.setDragEnabled(true);
        txtUsername.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 250, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/Username.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 250, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/Username.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        lblCriar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCriar.setText("Criar conta");
        lblCriar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCriar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCriarMouseClicked(evt);
            }
        });
        jPanel1.add(lblCriar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, -1));

        lblEsqueceu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblEsqueceu.setText("Esqueceu sua senha?");
        lblEsqueceu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEsqueceu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEsqueceuMouseClicked(evt);
            }
        });
        jPanel1.add(lblEsqueceu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/Logo.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, -10, -1, -1));

        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/CheckIcon.png"))); // NOI18N
        lblLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
        });
        jPanel1.add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void lblUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsernameMouseClicked
        txtUsername.setVisible(true);
        lblUsername.setVisible(false);
        if(txtPassword.getText().trim().isEmpty()){
            txtPassword.setVisible(false);
            lblPassword.setVisible(true);
        }
    }//GEN-LAST:event_lblUsernameMouseClicked

    private void lblPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPasswordMouseClicked
        txtPassword.setVisible(true);
        lblPassword.setVisible(false);
        if(txtUsername.getText().trim().isEmpty()){
            txtUsername.setVisible(false);
            lblUsername.setVisible(true);
        }
    }//GEN-LAST:event_lblPasswordMouseClicked

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
        boolean resposta = false;
        try { 
            resposta = consultar(txtUsername.getText(), txtPassword.getText());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (resposta == true) {
            JOptionPane.showMessageDialog(rootPane, "Seja bem-vindo de volta, "+txtUsername.getText()+"!");
            Usuario user = new Usuario();
            user.username = txtUsername.getText();
            user.password = txtPassword.getText();
            HomeFrame a = new HomeFrame();
            a.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário e(ou) senha incorretos!\nPor Favor, confira seus dados");
        }
     
    }//GEN-LAST:event_lblLoginMouseClicked

    private void lblEsqueceuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEsqueceuMouseClicked
        EsqueceuSenha a = new EsqueceuSenha();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblEsqueceuMouseClicked

    private void lblCriarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCriarMouseClicked
        CriarConta a = new CriarConta();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblCriarMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCriar;
    private javax.swing.JLabel lblEsqueceu;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}