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
public class CriarConta extends javax.swing.JFrame {

    public boolean consultar(String login) throws ClassNotFoundException {
        boolean autenticado = true;
        String sql;
        try {
            
        String myDriver = "com.mysql.jdbc.Driver";
        String myUrl = "jdbc:mysql://127.0.0.1:3306/urmovie";
        Class.forName(myDriver);
        Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "1234");

            sql = "SELECT login FROM usuarios";
            PreparedStatement ps;
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();

            while (rs.next()) {
                if(txtUsername.getText().equals(rs.getString("login"))) autenticado = false;
            } 
                ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        return autenticado;
    }
    
    
    public CriarConta() {
        initComponents();
        txtUsername.setBackground(new Color(0, 0, 0, 0));
        txtEmail.setBackground(new Color(0, 0, 0, 0));
        txtPassword.setBackground(new Color(0, 0, 0, 0));
        txtConfirmPassword.setBackground(new Color(0, 0, 0, 0));
        txtUsername.setVisible(false);
        txtEmail.setVisible(false);
        txtPassword.setVisible(false);
        txtConfirmPassword.setVisible(false);
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
        lblConfirmPassword = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        txtUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnCriar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblConfirmPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblConfirmPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConfirmPassword.setText("CONFIRM PASSWORD");
        lblConfirmPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblConfirmPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblConfirmPasswordMouseClicked(evt);
            }
        });
        jPanel1.add(lblConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 250, 50));

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("USERNAME");
        lblUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUsernameMouseClicked(evt);
            }
        });
        jPanel1.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 250, 50));

        txtConfirmPassword.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtConfirmPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtConfirmPassword.setBorder(null);
        jPanel1.add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 250, 30));

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
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 250, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/Username.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 250, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/Username.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Avengeance Heroic Avenger", 0, 48)); // NOI18N
        jLabel4.setText("Crie sua conta");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 10, 250, -1));

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPassword.setText("PASSWORD");
        lblPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPasswordMouseClicked(evt);
            }
        });
        jPanel1.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 250, 50));

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setBorder(null);
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 250, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/Username.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 250, -1));

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmail.setText("EMAIL");
        lblEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEmailMouseClicked(evt);
            }
        });
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 250, 50));

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(null);
        txtEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEmail.setDragEnabled(true);
        txtEmail.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 250, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/Username.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

        btnCriar.setBackground(new java.awt.Color(204, 255, 255));
        btnCriar.setText("Criar");
        btnCriar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCriar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(204, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblConfirmPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConfirmPasswordMouseClicked
        txtConfirmPassword.setVisible(true);
        lblConfirmPassword.setVisible(false);
        if(txtUsername.getText().trim().isEmpty()){
            txtUsername.setVisible(false);
            lblUsername.setVisible(true);
        }
        if(txtEmail.getText().trim().isEmpty()){
            txtEmail.setVisible(false);
            lblEmail.setVisible(true);
        }
        if(txtPassword.getText().trim().isEmpty()){
            txtPassword.setVisible(false);
            lblPassword.setVisible(true);
        }
    }//GEN-LAST:event_lblConfirmPasswordMouseClicked

    private void lblUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUsernameMouseClicked
        txtUsername.setVisible(true);
        lblUsername.setVisible(false);
        if(txtConfirmPassword.getText().trim().isEmpty()){
            txtConfirmPassword.setVisible(false);
            lblConfirmPassword.setVisible(true);
        }
        if(txtEmail.getText().trim().isEmpty()){
            txtEmail.setVisible(false);
            lblEmail.setVisible(true);
        }
        if(txtPassword.getText().trim().isEmpty()){
            txtPassword.setVisible(false);
            lblPassword.setVisible(true);
        }
    }//GEN-LAST:event_lblUsernameMouseClicked

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void lblPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPasswordMouseClicked
        txtPassword.setVisible(true);
        lblPassword.setVisible(false);
        if(txtConfirmPassword.getText().trim().isEmpty()){
            txtConfirmPassword.setVisible(false);
            lblConfirmPassword.setVisible(true);
        }
        if(txtEmail.getText().trim().isEmpty()){
            txtEmail.setVisible(false);
            lblEmail.setVisible(true);
        }
        if(txtUsername.getText().trim().isEmpty()){
            txtUsername.setVisible(false);
            lblUsername.setVisible(true);
        }
    }//GEN-LAST:event_lblPasswordMouseClicked

    private void lblEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEmailMouseClicked
        txtEmail.setVisible(true);
        lblEmail.setVisible(false);
        if(txtConfirmPassword.getText().trim().isEmpty()){
            txtConfirmPassword.setVisible(false);
            lblConfirmPassword.setVisible(true);
        }
        if(txtUsername.getText().trim().isEmpty()){
            txtUsername.setVisible(false);
            lblUsername.setVisible(true);
        }
        if(txtPassword.getText().trim().isEmpty()){
            txtPassword.setVisible(false);
            lblPassword.setVisible(true);
        }
    }//GEN-LAST:event_lblEmailMouseClicked

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Login a = new Login();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed
    boolean resposta = false;
    if(!txtConfirmPassword.getText().isEmpty()&&!txtPassword.getText().isEmpty()&&!txtUsername.getText().isEmpty()){
    try { 
        resposta = consultar(txtUsername.getText());
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    if(resposta == true)
    {
        if(txtPassword.getText().equals(txtConfirmPassword.getText())){
            try {
                String myDriver = "com.mysql.jdbc.Driver";
                String myUrl = "jdbc:mysql://127.0.0.1:3306/urmovie";
                Class.forName(myDriver);
                Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "1234");
                String query = "INSERT INTO usuarios(login, senha, email)"
                    + " VALUES (?, ?, ?)";
        
                PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
                preparedStmt.setString (1, txtUsername.getText());
                preparedStmt.setString (2, txtPassword.getText());
                preparedStmt.setString(3, txtEmail.getText());
                preparedStmt.execute();
                conn.close();
        
            }catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Sua conta foi criada, "+txtUsername.getText()+"!");
 
            Login a = new Login();
            this.setVisible(false);
            a.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Senhas não coincidem");
            txtPassword.setBackground(Color.red);
            txtConfirmPassword.setBackground(Color.red);
        }
    }else{
        int aux = JOptionPane.showConfirmDialog(this, "O usuário "+txtUsername.getText()+" já existe. "
                + "Você já possui alguma conta aqui?", null, JOptionPane.YES_NO_OPTION);
        if(aux == 0)
        {
            EsqueceuSenha a = new EsqueceuSenha();
            a.setVisible(true);
            this.setVisible(false);
        }
    }
    }
    else{
        JOptionPane.showMessageDialog(this, "Existe(m) dado(s) vazios! Preencha o(s) campo(s).");
    }
    }//GEN-LAST:event_btnCriarActionPerformed

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
            java.util.logging.Logger.getLogger(CriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCriar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
