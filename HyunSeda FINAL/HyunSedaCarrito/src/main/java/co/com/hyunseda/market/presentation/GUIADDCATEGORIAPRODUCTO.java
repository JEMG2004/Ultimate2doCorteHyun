
package co.com.hyunseda.market.presentation;


import co.com.hyunseda.market.service.CategoryService;
import co.com.hyunseda.market.service.ProductService;
import co.com.hyunseda.market.service.ShoppingCartService;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Laura Sofia
 */
public class GUIADDCATEGORIAPRODUCTO extends javax.swing.JFrame {
    
    private CategoryService categoryService;
    private ProductService productService;
    private ShoppingCartService shoppingCartService;
    private int idProducto;
     private boolean addOption = true;

    /**
     * Creates new form GUIMENUCATEGORIA
     */
    public GUIADDCATEGORIAPRODUCTO(int id,CategoryService categoryService,ProductService productService,ShoppingCartService shoppingCartService) {
        
        initComponents();
        this.categoryService = categoryService;
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
        this.idProducto = id;
        
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtIdAgregarCategoria = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombreAgregarCategoria = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ADICIONAR CATEGORIA");
        getContentPane().add(jLabel3, java.awt.BorderLayout.PAGE_START);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdicionar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.GridLayout(2, 2));

        jLabel4.setText("Id:");
        jPanel2.add(jLabel4);
        jPanel2.add(txtIdAgregarCategoria);

        jLabel5.setText("Nombre:");
        jPanel2.add(jLabel5);
        jPanel2.add(txtNombreAgregarCategoria);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        GUIAGREGARPRODUCT abrir = new GUIAGREGARPRODUCT(categoryService,productService,shoppingCartService);
        abrir.setVisible(true);
        this.setVisible(false); 
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
    //Si la categoria ya existe ingrese solo el id, sino, ingrese id y nombre para adicionarla
    String inputText = txtIdAgregarCategoria.getText();
    int id = Integer.parseInt(inputText);
    String nombre = txtNombreAgregarCategoria.getText().trim();
    
    if(categoryService.findCategoryById(id)==null){
        if (nombre.isEmpty()) {
        Messages.showMessageDialog("Debe ingresar el nombre de la categoria ", "Atención");
        return;
        }
        
        categoryService.saveCategory(id, nombre);
        productService.saveProduct_Category(idProducto, id);
        Messages.showMessageDialog("Categoria no existente añadida y enlazada al producto", "OK");
    }else {
        System.out.println("EL ID DEL PRODUCTO QUE TENEMOS ES : "+ idProducto);
        System.out.println("EL ID DE LA CATEGORIA QUE TENEMOS ES : "+ id);
        productService.saveProduct_Category(idProducto, id);
        Messages.showMessageDialog("Categoria añadida al producto", "OK");
    }
    //si no puede guardar la relacion productcategory es porque la categoria no existe, por lo que la crea
    /*    try {
        boolean nexoGuardado = productService.saveProduct_Category(idProducto, id);
        if (nexoGuardado) {
            // Limpiar los campos del formulario
            cleanControls();

            // Notificar al usuario del éxito
            Messages.showMessageDialog("categoria Ingresada", "OK");
        } else {
            // Manejar el error al guardar el producto
            categoryService.saveCategory(id, nombre);
            Messages.showMessageDialog("Categoria no existente añadida", "OK");
        }
    } catch (Exception e) {
        // Manejar errores inesperados
        Messages.showMessageDialog("Error inesperado al guardar el producto", "Error");
        Logger.getLogger(GUIADDCATEGORIAPRODUCTO.class.getName()).log(Level.SEVERE, null, e);
    }*/
    
    // Validar la entrada
    

    // Crear un nuevo objeto 


    // Llamar al servicio de productos para guardar el producto
    /*try {
        boolean categoriaGuardada = categoryService.saveCategory(id,nombre);
        System.out.println(categoryService.saveCategory(id,nombre));
        System.out.println(categoryService.saveCategory(id,nombre));
        System.out.println(categoryService.saveCategory(id,nombre));
        if (categoriaGuardada) {
            // Limpiar los campos del formulario
            cleanControls();

            // Notificar al usuario del éxito
            Messages.showMessageDialog("Producto Ingresado", "OK");
        } else {
            // Manejar el error al guardar el producto
            Messages.showMessageDialog("Error al guardar el producto", "Error");
        }
    } catch (Exception e) {
        // Manejar errores inesperados
        Messages.showMessageDialog("Error inesperado al guardar el producto", "Error");
        Logger.getLogger(GUIADDCATEGORIAPRODUCTO.class.getName()).log(Level.SEVERE, null, e);
    }*/
    }//GEN-LAST:event_btnAdicionarActionPerformed

        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtIdAgregarCategoria;
    private javax.swing.JTextField txtNombreAgregarCategoria;
    // End of variables declaration//GEN-END:variables

        private void cleanControls() {
        txtNombreAgregarCategoria.setText("");
        txtIdAgregarCategoria.setText("");
    }
        private void stateInitial() {
        txtNombreAgregarCategoria.setEnabled(false);
        txtIdAgregarCategoria.setEnabled(true);
    }
    
    private void addProduct() {

        int id = Integer.parseInt(txtIdAgregarCategoria.getText());
        String name = txtIdAgregarCategoria.getText().trim();

        if (categoryService.saveCategory(id,name)) {
            Messages.showMessageDialog("Se grabó con éxito", "Atención");
            cleanControls();
            //stateInitial();
        } else {
            Messages.showMessageDialog("Error al grabar, lo siento mucho", "Atención");
        }
        }
   
}


