
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


public class MarcaDao {
    
    Conexion con;
    
    
    
    public HashMap DropMarca(){
        
        HashMap<String,String> drop = new HashMap();
        
        try {
            
            String query = "select idMarca as id, marca from marcas;";
            
            con = new Conexion();
            
            con.OpenConnection();
            
            ResultSet consulta = con.conexionBD.createStatement().executeQuery(query);
            
            while (consulta.next()) {
                
                drop.put(consulta.getString("id"),consulta.getString("marca"));
                
            }
            
            //Debugging
            
            
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());       
        }finally{
            
            con.Closeconnection();
        }
        
     
        
        return drop;
    }
    
    

    
}
