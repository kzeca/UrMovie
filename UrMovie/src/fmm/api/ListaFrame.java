/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fmm.api;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Image;
import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pichau
 */
public class ListaFrame extends javax.swing.JFrame {
    
    boolean autenticar = false;
    
    public void SalvarInformações() throws ClassNotFoundException, SQLException{
        String myDriver = "com.mysql.jdbc.Driver";
        String myUrl = "jdbc:mysql://127.0.0.1:3306/urmovie";
        Class.forName(myDriver);
        Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "1234");
        
        String query = "UPDATE filme SET nome = ?, diretor = ?, ano = ?, descricao = ?, classificao = ?,"
            + " caminho_foto = ? WHERE id = "+Filme.id;

        PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
        preparedStmt.setString (1, txtNome.getText());
        preparedStmt.setString (2, txtDiretor.getText());
        preparedStmt.setInt (3, Integer.parseInt(txtAno.getText()));
        preparedStmt.setString (4, Filme.descricao);
        preparedStmt.setInt (5, Filme.classificao);
        preparedStmt.setString(6, Filme.caminho_foto);
        preparedStmt.execute();
        conn.close();
    }
    
    public void Estrela(){
        if(Filme.classificao==1)
        {
            lblCheio1.setVisible(true);
            lblCheio2.setVisible(false);
            lblCheio3.setVisible(false);
            lblCheio4.setVisible(false);
            lblCheio5.setVisible(false);
        }
        if(Filme.classificao==2)
        {
            lblCheio1.setVisible(true);
            lblCheio2.setVisible(true);
            lblCheio3.setVisible(false);
            lblCheio4.setVisible(false);
            lblCheio5.setVisible(false);
        }
        if(Filme.classificao==3)
        {
            lblCheio1.setVisible(true);
            lblCheio2.setVisible(true);
            lblCheio3.setVisible(true);
            lblCheio4.setVisible(false);
            lblCheio5.setVisible(false);
        }
        if(Filme.classificao==4)
        {
            lblCheio1.setVisible(true);
            lblCheio2.setVisible(true);
            lblCheio3.setVisible(true);
            lblCheio4.setVisible(true);
            lblCheio5.setVisible(false);
        }
        if(Filme.classificao==5)
        {
            lblCheio1.setVisible(true);
            lblCheio2.setVisible(true);
            lblCheio3.setVisible(true);
            lblCheio4.setVisible(true);
            lblCheio5.setVisible(true);
        }
    }
    
    public void Foto(){
        if(Filme.caminho_foto != null){
            ImageIcon icon = new ImageIcon(Filme.caminho_foto);
            Image img = icon.getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH);
            lblCapa.setIcon(new ImageIcon(img));
            lblCapa.setToolTipText("Descrição: "+Filme.descricao);
        }
    }
    
    public void InformacaoFilme() throws ClassNotFoundException, SQLException {
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://127.0.0.1:3306/urmovie";
            Class.forName(myDriver);
            Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "1234");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM filme WHERE nome LIKE '"+txtNome.getText()+"'";
            ResultSet rs;
            rs = stmt.executeQuery(query);
            if(rs.next()){
                Filme.nome = rs.getString("nome");
                Filme.diretor = rs.getString("diretor");
                Filme.ano = rs.getInt("ano");
                Filme.descricao = rs.getString("descricao");
                Filme.classificao = rs.getInt("classificao");
                Filme.caminho_foto = rs.getString("caminho_foto");
                Filme.id = rs.getInt("id");
            }
            conn.close();
            Estrela();
            Foto();
}
    
    public void ConectarBanco(){
        try {
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://127.0.0.1:3306/urmovie";
            Class.forName(myDriver);
            Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "1234");
            
            Statement stmt = conn.createStatement();
            String query = "SELECT nome, diretor, ano FROM filme WHERE usuario_id = "+Usuario.id;
            ResultSet rs;
            rs = stmt.executeQuery(query);
            
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("Nome");
            dtm.addColumn("Diretor");
            dtm.addColumn("Ano");
            while(rs.next()){
                dtm.addRow(new Object[]{
                    rs.getString("nome"),
                    rs.getString("diretor"),
                    rs.getString("ano")
            });
        }
            
            tblFilmes.setModel(dtm);
            conn.close();
            
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    
    
    
    public ListaFrame() {
        initComponents();
        Filme.caminho_foto = null;
        setResizable(false);
        ConectarBanco();
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
        jLabel1 = new javax.swing.JLabel();
        lblCapa = new javax.swing.JLabel();
        btnUpload = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtDiretor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnDescricao = new javax.swing.JButton();
        lblCheio3 = new javax.swing.JLabel();
        lblVazio1 = new javax.swing.JLabel();
        lblVazio5 = new javax.swing.JLabel();
        lblCheio4 = new javax.swing.JLabel();
        lblVazio2 = new javax.swing.JLabel();
        lblVazio4 = new javax.swing.JLabel();
        lblVazio3 = new javax.swing.JLabel();
        lblCheio1 = new javax.swing.JLabel();
        lblCheio2 = new javax.swing.JLabel();
        lblCheio5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFilmes = new javax.swing.JTable();
        btnAlterar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Jokerman", 0, 24)); // NOI18N
        jLabel1.setText("LISTA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, -1));

        lblCapa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/FormaImagem.png"))); // NOI18N
        jPanel1.add(lblCapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 170, 170));

        btnUpload.setBackground(new java.awt.Color(204, 255, 255));
        btnUpload.setText("Fazer Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nome:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 170, -1));

        txtDiretor.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel1.add(txtDiretor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 170, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Diretor:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Ano:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        txtAno.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnoActionPerformed(evt);
            }
        });
        jPanel1.add(txtAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 50, -1));

        btnVoltar.setBackground(new java.awt.Color(204, 255, 255));
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 210, -1));

        btnExcluir.setBackground(new java.awt.Color(204, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 210, -1));

        btnDescricao.setBackground(new java.awt.Color(204, 255, 255));
        btnDescricao.setText("Adicionar Descrição");
        btnDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescricaoActionPerformed(evt);
            }
        });
        jPanel1.add(btnDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 210, -1));

        lblCheio3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/Estrela_Cheia.png"))); // NOI18N
        lblCheio3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(lblCheio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 30, 30));

        lblVazio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/Estrela_Vazia.png"))); // NOI18N
        lblVazio1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVazio1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVazio1MouseClicked(evt);
            }
        });
        jPanel1.add(lblVazio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 30, 30));

        lblVazio5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/Estrela_Vazia.png"))); // NOI18N
        lblVazio5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVazio5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVazio5MouseClicked(evt);
            }
        });
        jPanel1.add(lblVazio5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 30, 30));

        lblCheio4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/Estrela_Cheia.png"))); // NOI18N
        lblCheio4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(lblCheio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 30, 30));

        lblVazio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/Estrela_Vazia.png"))); // NOI18N
        lblVazio2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVazio2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVazio2MouseClicked(evt);
            }
        });
        jPanel1.add(lblVazio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 30, 30));

        lblVazio4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/Estrela_Vazia.png"))); // NOI18N
        lblVazio4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVazio4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVazio4MouseClicked(evt);
            }
        });
        jPanel1.add(lblVazio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 30, 30));

        lblVazio3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/Estrela_Vazia.png"))); // NOI18N
        lblVazio3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVazio3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVazio3MouseClicked(evt);
            }
        });
        jPanel1.add(lblVazio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 30, 30));

        lblCheio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/Estrela_Cheia.png"))); // NOI18N
        lblCheio1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(lblCheio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 30, 30));

        lblCheio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/Estrela_Cheia.png"))); // NOI18N
        lblCheio2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(lblCheio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 30, 30));

        lblCheio5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fmm/assets/Estrela_Cheia.png"))); // NOI18N
        lblCheio5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(lblCheio5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 30, 30));

        tblFilmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Diretor", "Ano"
            }
        ));
        jScrollPane2.setViewportView(tblFilmes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 700, 200));

        btnAlterar.setBackground(new java.awt.Color(204, 255, 255));
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 210, -1));

        btnSalvar.setBackground(new java.awt.Color(204, 255, 255));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnoActionPerformed

    }//GEN-LAST:event_txtAnoActionPerformed

    private void lblVazio1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVazio1MouseClicked
        lblCheio1.setVisible(true);
        lblCheio2.setVisible(false);
        lblCheio3.setVisible(false);
        lblCheio4.setVisible(false);
        lblCheio5.setVisible(false);
        Filme.classificao = 1;
    }//GEN-LAST:event_lblVazio1MouseClicked

    private void lblVazio5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVazio5MouseClicked
        lblCheio1.setVisible(true);
        lblCheio2.setVisible(true);
        lblCheio3.setVisible(true);
        lblCheio4.setVisible(true);
        lblCheio5.setVisible(true);
        Filme.classificao = 5;
    }//GEN-LAST:event_lblVazio5MouseClicked

    private void lblVazio2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVazio2MouseClicked
        lblCheio1.setVisible(true);
        lblCheio2.setVisible(true);
        lblCheio3.setVisible(false);
        lblCheio4.setVisible(false);
        lblCheio5.setVisible(false);
        Filme.classificao = 2;
    }//GEN-LAST:event_lblVazio2MouseClicked

    private void lblVazio4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVazio4MouseClicked
        lblCheio1.setVisible(true);
        lblCheio2.setVisible(true);
        lblCheio3.setVisible(true);
        lblCheio4.setVisible(true);
        lblCheio5.setVisible(false);
        Filme.classificao = 4;
    }//GEN-LAST:event_lblVazio4MouseClicked

    private void lblVazio3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVazio3MouseClicked
        lblCheio1.setVisible(true);
        lblCheio2.setVisible(true);
        lblCheio3.setVisible(true);
        lblCheio4.setVisible(false);
        lblCheio5.setVisible(false);
        Filme.classificao = 3;
    }//GEN-LAST:event_lblVazio3MouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int row = tblFilmes.getSelectedRow();
            txtNome.setText(tblFilmes.getValueAt(row, 0).toString());
            txtDiretor.setText(tblFilmes.getValueAt(row, 1).toString());
            txtAno.setText(tblFilmes.getValueAt(row, 2).toString());
            try {
            InformacaoFilme();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        autenticar = true;    
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(autenticar){
        int aux = JOptionPane.showConfirmDialog(this, "Você deseja salvar suas alterações?", 
                "Salvar nos informações", JOptionPane.YES_NO_OPTION);
        if(aux==0){
            try {
                SalvarInformações();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListaFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ListaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        else JOptionPane.showMessageDialog(this , "Por favor, selecione um registro e clique em Alterar!");
        ConectarBanco();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        HomeFrame a = new HomeFrame();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(autenticar)
        
        {
            int aux = JOptionPane.showConfirmDialog(this, "Você realmente deseja excluir esse filme?", 
                    "Excluir filme", JOptionPane.YES_NO_OPTION);
            if(aux==0){
                try{
                    String myDriver = "com.mysql.jdbc.Driver";
                    String myUrl = "jdbc:mysql://127.0.0.1:3306/urmovie";
                    Class.forName(myDriver);
                    Connection conn = (Connection) DriverManager.getConnection(myUrl, "root", "1234");
        
                    String query = "DELETE FROM filme WHERE id = "+Filme.id;
                    PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
                    preparedStmt.execute();
                    conn.close();
                }catch(Exception e) {
                    System.err.println("Got an exception!");
                    System.err.println(e.getMessage());
                }
            }
        }else JOptionPane.showMessageDialog(this , "Por favor, selecione um registro e clique em Alterar!");
        ConectarBanco();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescricaoActionPerformed
        DescricaoFrame a = new DescricaoFrame();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDescricaoActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecionar Arquivo");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagem", "jpg", "png");
        fileChooser.setFileFilter(filter);
        int retorno = fileChooser.showOpenDialog(this);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            Filme.caminho_foto = file.getPath();
            ImageIcon icon = new ImageIcon(file.getPath());
            Image img = icon.getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH);
            lblCapa.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_btnUploadActionPerformed

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
            java.util.logging.Logger.getLogger(ListaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnDescricao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnUpload;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCapa;
    private javax.swing.JLabel lblCheio1;
    private javax.swing.JLabel lblCheio2;
    private javax.swing.JLabel lblCheio3;
    private javax.swing.JLabel lblCheio4;
    private javax.swing.JLabel lblCheio5;
    private javax.swing.JLabel lblVazio1;
    private javax.swing.JLabel lblVazio2;
    private javax.swing.JLabel lblVazio3;
    private javax.swing.JLabel lblVazio4;
    private javax.swing.JLabel lblVazio5;
    private javax.swing.JTable tblFilmes;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtDiretor;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
