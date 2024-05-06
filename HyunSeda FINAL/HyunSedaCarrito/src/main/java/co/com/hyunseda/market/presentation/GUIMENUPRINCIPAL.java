/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.com.hyunseda.market.presentation;

import co.com.hyunseda.market.domain.User;
import co.com.hyunseda.market.domain.acess.CategoryRepository;
import co.com.hyunseda.market.domain.acess.ProductRepository;
import co.com.hyunseda.market.service.CategoryService;
import co.com.hyunseda.market.service.ProductService;
import co.com.hyunseda.market.service.ShoppingCartService;

/**
 *
 * @author Laura Sofia
 */
public class GUIMENUPRINCIPAL extends javax.swing.JFrame {

    /*ProductRepository productRepository = new ProductRepository();
    ProductService productService = new ProductService(productRepository);
    ShoppingCartService shoppingCartService = new ShoppingCartService(new User());*/
    //CategoryRepository categoryRepository = new CategoryRepository();
    //CategoryService categoryService = new CategoryService(categoryRepository);
    
    private CategoryService categoryService;
    private ShoppingCartService shoppingCartService;
    private ProductService productService;
    
    
    
    /**
     * Creates new form GUIMENUPRINCIPAL
     * @param productService
     */
    /*public GUIMENUPRINCIPAL(ProductService productService, ShoppingCartService shoppingCartService) {
        initComponents();
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
        //this.categoryService = categoryService;
    }*/
    public GUIMENUPRINCIPAL(CategoryService categoryService,ProductService productService, ShoppingCartService shoppingCartService) {
        initComponents();
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
        this.categoryService = categoryService;
    }

    private GUIMENUPRINCIPAL() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnRegresarLogin = new javax.swing.JButton();
        btnSalirMenuPrincipal = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnProducto = new javax.swing.JButton();
        btnCategoria = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU PRINCIPAL");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        btnRegresarLogin.setText("Regresar al Login");
        btnRegresarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresarLogin);

        btnSalirMenuPrincipal.setText("Salir");
        btnSalirMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirMenuPrincipalActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalirMenuPrincipal);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        btnProducto.setText("Producto");
        btnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoActionPerformed(evt);
            }
        });
        jPanel2.add(btnProducto);

        btnCategoria.setText("Categoria");
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });
        jPanel2.add(btnCategoria);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirMenuPrincipalActionPerformed
           System.exit(0);
    }//GEN-LAST:event_btnSalirMenuPrincipalActionPerformed

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
        GUIMENUPRODUCTO abrir = new GUIMENUPRODUCTO(categoryService,productService,shoppingCartService);
        abrir.setVisible(true);
        this.setVisible(false);      
    }//GEN-LAST:event_btnProductoActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        GUIMENUCATEGORIA abrir = new GUIMENUCATEGORIA(categoryService,productService, shoppingCartService);
        abrir.setVisible(true);
        this.setVisible(false);    
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnRegresarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarLoginActionPerformed
        // TODO add your handling code here:
        GUILOGIN abrir = new GUILOGIN(categoryService,productService,shoppingCartService);
         abrir.setSize(400, 300);
       
        abrir.setVisible(true);
        this.setVisible(false); 
    }//GEN-LAST:event_btnRegresarLoginActionPerformed

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
            java.util.logging.Logger.getLogger(GUIMENUPRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIMENUPRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIMENUPRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIMENUPRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIMENUPRINCIPAL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnProducto;
    private javax.swing.JButton btnRegresarLogin;
    private javax.swing.JButton btnSalirMenuPrincipal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
