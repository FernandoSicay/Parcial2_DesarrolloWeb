
package Controller;

import Model.IProductoDao;
import Model.ProductoDao;
import Model.ProductoEntity;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class MarcaControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SrMarca</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Marcas at " + request.getContextPath() + "</h1>");
            
            IProductoDao dao = new ProductoDao();
            IProductoDao dao1 = new ProductoDao();
            
            ProductoEntity producto = new ProductoEntity();
            
            
            producto.setId(Integer.valueOf(request.getParameter("txt_id")));
            producto.setNombreObjeto(request.getParameter("txt_producto"));
            producto.setDescripcion(request.getParameter("txt_descripcion"));
            producto.setPrecioCosto(Double.valueOf((request.getParameter("txt_costo"))));
            producto.setPrecioVenta(Double.valueOf((request.getParameter("txt_venta"))));
            producto.setExistencia(Integer.valueOf((request.getParameter("txt_existencias"))));
            producto.setId_marca(Integer.valueOf(request.getParameter("drop_marca")));
            
            
          
           
            
            //Botno Guardar
            if ("agregar".equals(request.getParameter("btn_agregar"))) {
                
                int contador = dao.AgregarProducto(producto);
                
                if (contador > 0) {
                    response.sendRedirect("index.jsp");

                } else {
                    out.println("<h1> xxxxxxx No se Ingreso xxxxxxxxxxxx </h1>");
                    out.println("<a href='index.jsp'>Regresar...</a>");
                }
            }
            
            
             // ----------------------------------------------------
           
             // Boton modificar 
            if ("modificar".equals(request.getParameter("btn_modificar"))){
                
                int contador = dao.ActualizarProducto(producto);
                
             if (contador>0){
             response.sendRedirect("index.jsp");
             
             }else{
             out.println("<h1> xxxxxxx No se Modifico xxxxxxxxxxxx </h1>");
             out.println("<a href='index.jsp'>Regresar...</a>");
             }
             }
            
            
            
           // ----------------------------------------------------
           
           
            // Boton eliminar 
            if ("eliminar".equals(request.getParameter("btn_eliminar"))){
                 
                int contadorE = dao1.EliminarProducto(Integer.valueOf(request.getParameter("txt_id")));
                 
             if (contadorE>0){
             response.sendRedirect("index.jsp");
             
             }else{
             out.println("<h1> xxxxxxx No se Elimino xxxxxxxxxxxx </h1>");
             out.println("<a href='index.jsp'>Regresar...</a>");
             }
             }
            
           
            
                 
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
