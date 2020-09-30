
package Model;

import javax.swing.table.DefaultTableModel;


public interface IProductoDao {
    
    public int AgregarProducto(ProductoEntity producto);

    public DefaultTableModel Reed();
    
    public int ActualizarProducto(ProductoEntity producto);
    
    public int EliminarProducto(int idproducto);

    
}
