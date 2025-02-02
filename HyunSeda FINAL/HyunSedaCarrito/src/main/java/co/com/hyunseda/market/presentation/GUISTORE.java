/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.hyunseda.market.presentation;

import co.com.hyunseda.market.domain.Product;
import co.com.hyunseda.market.main.HyunSedaSolid;
import co.com.hyunseda.market.service.ProductService;
import co.com.hyunseda.market.service.ShoppingCartService;
import co.unicauca.pago.core.PagoCore;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import co.com.hyunseda.market.infrastructure.Observer;
import co.com.hyunseda.market.service.CategoryService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class GUISTORE extends javax.swing.JDialog implements Observer{
    private CategoryService categoryService;
    private ProductService productService;
    private ShoppingCartService shoppingCartService;
    /**
     * Creates new form GUIProductsFind
     * @param parent
     */
    public GUISTORE(java.awt.Frame parent,boolean modal,CategoryService categoryService,ProductService productService, ShoppingCartService shoppingCartService) {
        super(parent, modal);
        
        initComponents();
        this.categoryService = categoryService;
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
        initializeTable();
        fillComboBox();
        
        setLocationRelativeTo(null); //centrar al ventana
    }
    
    private void initializeTable() {
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Name","Description","Price" 
                }
        ));
    }
    private void fillComboBox(){
        productService.findAllProducts();
        for(int i =0; i<productService.findAllProducts().size();i++){
        cbxProducts.addItem(productService.findAllProducts().get(i).getProductName());
        }
    }
    
        private void fillTable() {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
        List<Product> listProducts = shoppingCartService.getCart().getCarro();
        Object rowData[] = new Object[4];//No columnas
        for (int i = 0; i < listProducts.size(); i++) {
            rowData[0] = listProducts.get(i).getProductId();
            rowData[1] = listProducts.get(i).getProductName();
            rowData[2] = listProducts.get(i).getProductDescripcion();
            rowData[3] = listProducts.get(i).getProductPrice();
            model.addRow(rowData);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlCenter = new javax.swing.JPanel();
        pnlCbx = new javax.swing.JPanel();
        cbxProducts = new javax.swing.JComboBox<>();
        pnlButtonList = new javax.swing.JPanel();
        btnPreview = new javax.swing.JButton();
        btnAddCart = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        pnlNorth = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        btnGoCart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbxMetodoPago = new javax.swing.JComboBox<>();
        btnPagar = new javax.swing.JButton();
        txtCuenta = new javax.swing.JTextField();
        txtTotal = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Búsqueda de productos");

        pnlCenter.setLayout(new java.awt.BorderLayout());

        pnlCbx.setLayout(new java.awt.GridLayout(1, 2));

        cbxProducts.setToolTipText("");
        cbxProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbxProducts.setName(""); // NOI18N
        cbxProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProductsActionPerformed(evt);
            }
        });
        pnlCbx.add(cbxProducts);

        btnPreview.setText("Vista previa");
        btnPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviewActionPerformed(evt);
            }
        });
        pnlButtonList.add(btnPreview);

        btnAddCart.setText("Agregar al carrito");
        btnAddCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCartActionPerformed(evt);
            }
        });
        pnlButtonList.add(btnAddCart);

        pnlCbx.add(pnlButtonList);

        pnlCenter.add(pnlCbx, java.awt.BorderLayout.PAGE_START);

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Precio", "Cantidad"
            }
        ));
        tblProducts.setColumnSelectionAllowed(true);
        tblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducts);
        tblProducts.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        pnlCenter.add(jScrollPane1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.jpg"))); // NOI18N
        jLabel1.setText("TIENDA HYUNSEDA");

        javax.swing.GroupLayout pnlNorthLayout = new javax.swing.GroupLayout(pnlNorth);
        pnlNorth.setLayout(pnlNorthLayout);
        pnlNorthLayout.setHorizontalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNorthLayout.createSequentialGroup()
                .addContainerGap(223, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(221, 221, 221))
        );
        pnlNorthLayout.setVerticalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNorthLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(pnlNorth, java.awt.BorderLayout.PAGE_START);

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cerrar.png"))); // NOI18N
        btnClose.setText("Cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnGoCart.setBackground(java.awt.SystemColor.control);
        btnGoCart.setForeground(java.awt.SystemColor.menu);
        btnGoCart.setBorder(null);

        jLabel2.setText("Pago:");

        cbxMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paypal", "Google Pay", "Stripe" }));

        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        txtCuenta.setText("#cuenta");

        txtTotal.setText("Total:");

        lblTotal.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cbxMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(btnGoCart))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnPagar)
                        .addGap(18, 18, 18)
                        .addComponent(btnClose)
                        .addGap(141, 141, 141)
                        .addComponent(txtTotal)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(btnPagar)
                    .addComponent(txtTotal)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGoCart))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        GUILOGIN abrir = new GUILOGIN(categoryService,productService,shoppingCartService);
        abrir.setVisible(true);
        this.setVisible(false); 
        //this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnAddCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCartActionPerformed
        String nomProducto = cbxProducts.getSelectedItem().toString();
        Product producto = productService.findProductByName(nomProducto);
        shoppingCartService.aniadirProducto(producto);
        fillTable();
        
        //fillTable(productService.findAllProducts());
    }//GEN-LAST:event_btnAddCartActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        // TODO add your handling code here:
        double total = Double.parseDouble(lblTotal.getText());
        if(total == 0){
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun producto.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String codigoCuenta = txtCuenta.getText();
        Object selectedObject = cbxMetodoPago.getSelectedItem();
        String metodoPago = selectedObject.toString();
        
        PagoCore pg = new PagoCore();
        
        boolean pago =  pg.pagar(codigoCuenta, total, metodoPago,getBaseFilePath());
        if(pago){
            JOptionPane.showMessageDialog(null, "EL pago fue exitoso :", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "EL pago rechazado: ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void cbxProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProductsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProductsActionPerformed

    private void tblProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductsMouseClicked
        /*
        int selectedRow = tblProducts.getSelectedRow();
        
        //se se esta fuera del rango o si el clic ha sido dado sobre la misma columna por segunda vez
        if (selectedRow == -1 ||flagImage == selectedRow)
        {
            return;
        }
        
        //lblImage.setText("value");
        //Se re escala la imagen y se pone en lblImage obteniendo el link de imagen del objeto
        ImageIcon imageIcon = Utilities.loadImageFromCloud(productService.findAllProducts().get(selectedRow).getImageLink());

        //intento de reescalar la imagen:
        int newWidth = 200;
        int newHeight = 200;
        Image resizedImage = imageIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        //Como el label esta con un objeto icon, hay que vover a cear un nuevo objeto para redimensionar bien la imagen
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        if (resizedIcon != null) {
            lblImage.setIcon(resizedIcon);
        }
        
        flagImage = selectedRow;
*/
    }//GEN-LAST:event_tblProductsMouseClicked
//Previsuaizar imagen
    private void btnPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviewActionPerformed
        // TODO add your handling code here:
        String nomProducto = cbxProducts.getSelectedItem().toString();
        Product producto = productService.findProductByName(nomProducto);
        //GUIPREVIEW guiPreview = new GUIPREVIEW();
        GUIPREVIEW guiPreview = new GUIPREVIEW(categoryService,productService,shoppingCartService);
        //guiPreview.setProductName(producto.getProductName()); // Set the product name in GUIPREVIEW
        guiPreview.setSize(1000, 500);
        guiPreview.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPreviewActionPerformed
    
    private void totalPrecio(List<Product> listProducts){
            double total=0;
            for(int i = 0; i < listProducts.size();i++){
                total += listProducts.get(i).getProductPrice();
            }
            lblTotal.setText(String.valueOf(total));
        }
    
        private String getBaseFilePath() {
        try {
            String path = HyunSedaSolid.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            path = URLDecoder.decode(path, "UTF-8"); //This should solve the problem with spaces and special characters.
            File pathFile = new File(path);
            if (pathFile.isFile()) {
                path = pathFile.getParent();
                
                if (!path.endsWith(File.separator)) {
                    path += File.separator;
                }
            }

            return path;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PagoCore.class.getName()).log(Level.SEVERE, "Error al eliminar espacios en la ruta del archivo", ex);
            return null;
        }
    }
    
    public void fillCombo(){
        //for 
        productService.findAllProducts();
        for(int i =0; i<productService.findAllProducts().size();i++){
        cbxProducts.addItem(productService.findAllProducts().get(i).getProductName());
        }
    }
    @Override // total de la compra
    public void update(Object o) {
        ShoppingCartService aux =(ShoppingCartService)o;
        totalPrecio(aux.getCart().getCarro());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCart;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnGoCart;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnPreview;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxMetodoPago;
    private javax.swing.JComboBox<String> cbxProducts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlButtonList;
    private javax.swing.JPanel pnlCbx;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
