

<%@page import="Model.ProductoDao"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page import="java.util.HashMap"%>
<%@page import="Model.MarcaDao"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>Productos</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link href="main.css" rel="stylesheet" type="text/css">
</head>



    <body>
        
        
        

    <div class="container-xl">
        <div class="table-responsive">
          <div class="table-wrapper">
            <div class="table-title">
              <div class="row">
                <div class="col-sm-6">
                  <h2>Gestionar <b>Productos</b></h2>
                </div>
                <div class="col-sm-6">
                
                  <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i
                      class="material-icons">&#xE147;</i> <span>Agregar Producto</span></a>
                 
                     
                </div>
              </div>
            </div>
    
    
            <table class="table table-striped table-hover">
              <thead>
                <tr>
                  <th>Producto</th>
                  <th>Descripcion</th>
                  <th>Precio Costo</th>
                  <th>Precio Venta</th>
                  <th>Existencias</th>
                  <th>Marca</th>
                  
                </tr>
              </thead>
              <tbody id="tbl_productos">
                  
                  <%
                      ProductoDao producto = new ProductoDao();
                      DefaultTableModel tabla = new DefaultTableModel();
                      
                      tabla = producto.Reed();
                      
                      for (int t=0;t<tabla.getRowCount();t++){
                          
                          out.println("<tr data-id=" + tabla.getValueAt(t,0) + " data-idmarca=" + tabla.getValueAt(t,7) + ">");
                          out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
                          out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
                          out.println("<td>" + tabla.getValueAt(t,3) + "</td>");
                          out.println("<td>" + tabla.getValueAt(t,4) + "</td>");
                          out.println("<td>" + tabla.getValueAt(t,5) + "</td>");
                          out.println("<td>" + tabla.getValueAt(t,6) + "</td>");
                          out.println("</tr>");
        
        }
                  
                  %>
                  
                
              </tbody>
            </table>
    
    
    
          </div>
        </div>
      </div>
    
    
    
      <!-- Edit Modal HTML -->
      <div id="addEmployeeModal" class="modal fade">
        <div class="modal-dialog">
          <div class="modal-content">
    
            <form action="SrMarca" method="post" class="form-group">
              <div class="modal-header">
                <h4 class="modal-title">Gestion de Producto</h4>
               
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="limpiar()">&times</button>
              </div>
    
              <div class="modal-body">
    
                    <label for="lbl_id" ><b>ID</b></label>
                    <input type="text" name="txt_id" id="txt_id" class="form-control" value="0"  readonly> 
    
                    <label for="lbl_producto" ><b>Producto</b></label>
                    <input type="text" name="txt_producto" id="txt_producto" class="form-control"  required>
                    
                    <label for="lbl_descripcion" ><b>Descripcion</b></label>
                    <input type="text" name="txt_descripcion" id="txt_descripcion" class="form-control" required>
                   
                    <label for="lbl_costo" ><b>Precio Costo</b></label>
                    <input type="number" name="txt_costo" id="txt_costo" class="form-control" required>
                   
                    <label for="lbl_venta" ><b>Precio Venta</b></label>
                    <input type="number"  name="txt_venta" id="txt_venta" class="form-control" required>
                                  
                    <label for="lbl_marca" ><b>Marca</b></label>
                    <select name="drop_marca" id="drop_marca" class="form-control">
                        
                        <%
                            
                            MarcaDao marca = new MarcaDao();
                            
                            HashMap<String,String> drop = marca.DropMarca();
                            
                            for (String i:drop.keySet()){
                             out.println("<option value='" + i + "'>" + drop.get(i) + "</option>");
                         }
                            
                            

                            

                        %>
                        
                    </select>
    
                    <label for="lbl_existencias" ><b>Existencias</b></label>
                    <input type="number"  name="txt_existencias" id="txt_existencias" class="form-control" required>
                                  
    
              </div>
    
              <div class="modal-footer">
    
                
                
                <button name="btn_agregar" id="btn_agregar"  value="agregar" class="btn btn-primary">Agregar</button>
                
                <button name="btn_modificar" id="btn_modificar"  value="modificar" class="btn btn-success">Modificar</button>
                
                <button name="btn_eliminar" id="btn_eliminar"  value="eliminar" class="btn btn-danger" onclick="javascript:if(!confirm('¿Desea Eliminar?'))return false" >Eliminar</button>
           
              </div>
    
            </form>
    
          </div>
        </div>
      </div>
    
    
    









      
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  
        
    <script type="text/javascript">
        
        function limpiar(){
       $("#txt_id").val(0);
       $("#txt_producto").val('');
       $("#txt_descripcion").val('');
       $("#txt_costo").val('');
       $("#txt_venta").val('');
       $("#txt_existencias").val('');
       $("#drop_marca").val(1);
        }
        
        $('#tbl_productos').on('click', 'tr td', function(evt){
            var target, id, idmarca, producto, descripcion, costo, venta,existencia;
            
            target = $(event.target);
            
            id = target.parent().data("id");
            idmarca = target.parent().data("idmarca");
            producto = target.parent("tr").find("td").eq(0).html();
            descripcion = target.parent("tr").find("td").eq(1).html();
            costo = target.parent("tr").find("td").eq(2).html();
            venta = target.parent("tr").find("td").eq(3).html();
            existencia = target.parent("tr").find("td").eq(4).html();
            
            $("#txt_id").val(id);
            $("#txt_producto").val(producto);
            $("#txt_descripcion").val(descripcion);
            $("#txt_costo").val(costo);
            $("#txt_venta").val(venta);
            $("#drop_marca").val(idmarca);
            $("#txt_existencias").val(existencia);
            
            $("#addEmployeeModal").modal('show');
            
            
        })
        
        
       
        
    
</script>
        
        
    </body>
</html>
