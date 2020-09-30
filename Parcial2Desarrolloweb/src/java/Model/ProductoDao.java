
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ProductoDao implements IProductoDao{
    
    PreparedStatement parametro;
    ResultSet consulta;
    Conexion con;

    @Override
    public int AgregarProducto(ProductoEntity producto) {
    
        int retorno = 0;

        try {
            
            con = new Conexion();
            
            String query = "insert into productos(producto,idMarca,descripcion,precio_costo,precio_venta,existencias) values (?, ?, ?, ?, ?, ?);";
            
            con.OpenConnection();
            
            
            parametro = (PreparedStatement) con.conexionBD.prepareStatement(query);
            
            parametro.setString(1, producto.getNombreObjeto());
            parametro.setInt(2, producto.getId_marca());
            parametro.setString(3, producto.getDescripcion());
            parametro.setDouble(4, producto.getPrecioCosto());
            parametro.setDouble(5, producto.getPrecioVenta());
            parametro.setInt(6, producto.getExistencia());
            
            retorno = parametro.executeUpdate();
            
           //------------------------------------------------------------------
            //debugging
            System.out.println(producto.getNombreObjeto());
            System.out.println(producto.getId_marca());
            System.out.println(producto.getDescripcion());
            System.out.println(producto.getPrecioCosto());
            System.out.println(producto.getPrecioVenta());
            System.out.println(producto.getExistencia());
          

            System.out.println(retorno);

            System.out.println("---------------------------------");
            
            //end debugging
            //------------------------------------------------------------------
         
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
            
        }finally{
         
            con.Closeconnection();
        }
        
        
        return retorno;
    }
    
    
    
    

    @Override
    public DefaultTableModel Reed() {
        DefaultTableModel table = new DefaultTableModel();
        
        try {
            
            con = new Conexion();
            
            con.OpenConnection();
            
            String query = "select p.idProducto as id, p.producto, p.descripcion, p.precio_costo, p.precio_venta, p.existencias, m.marca, m.idMarca from productos as p inner join marcas as m on p.idMarca = m.idMarca;";
            
            
            consulta = con.conexionBD.createStatement().executeQuery(query);
            
            String header [] = {"id", "producto", "descripcion", "precio_costo", "precio_venta", "existencias", "marca", "idMarca"};
            
            table.setColumnIdentifiers(header);
            
            String datos[] = new String[8];
            
            while (consulta.next()) {
                
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("producto");
                datos[2] = consulta.getString("descripcion");
                datos[3] = consulta.getString("precio_costo");
                datos[4] = consulta.getString("precio_venta");
                datos[5] = consulta.getString("existencias");
                datos[6] = consulta.getString("marca");
                datos[7] = consulta.getString("idMarca");
                
                table.addRow(datos);
                                               
            }

        } catch (SQLException ex) {
        
            System.out.println(ex.getMessage());
        
        }finally{
        
            con.Closeconnection();
        }
        
        
        return table;
    }

    
    
    
    
    @Override
    public int ActualizarProducto(ProductoEntity producto) {
        int retorno = 0;
        
        try {
            con = new Conexion();
            
            String query = "update productos set producto = ?, idMarca = ?, descripcion = ?, precio_costo = ?, precio_venta = ?, existencias = ? where idProducto = ?;";
            
            con.OpenConnection();
            
            parametro = (PreparedStatement) con.conexionBD.prepareStatement(query);
            
            parametro.setString(1, producto.getNombreObjeto());
            parametro.setInt(2, producto.getId_marca());
            parametro.setString(3, producto.getDescripcion());
            parametro.setDouble(4, producto.getPrecioCosto());
            parametro.setDouble(5, producto.getPrecioVenta());
            parametro.setInt(6, producto.getExistencia());
            parametro.setInt(7, producto.getId());
            
            retorno = parametro.executeUpdate();
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally{
            con.Closeconnection();
        }
        
        return retorno;
        
    }

    
    
    @Override
    public int EliminarProducto(int idproducto) {
        
        int retorno = 0;

        try {
            con = new Conexion();
            
            String query = "delete from productos where idProducto = ? ;";
            
            con.OpenConnection();
            
            parametro = (PreparedStatement)con.conexionBD.prepareStatement(query);
            
            parametro.setInt(1, idproducto);
            retorno = parametro.executeUpdate();

            System.out.println(retorno);

        } catch (SQLException e) {
        
            
        }
        
        return retorno;
    }
    
    
    
}
