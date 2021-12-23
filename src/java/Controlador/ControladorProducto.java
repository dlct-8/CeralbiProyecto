
package Controlador;

import Modelo.Producto;
import ModeloDAO.ProductoDAO;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladorProducto extends HttpServlet {

   String listar="vistas/Producto/listarProducto.jsp";
    String add="vistas/Producto/addProducto.jsp";
    String edit="vistas/Producto/editProducto.jsp";
    
    Producto pr=new Producto();
    
    ProductoDAO dao=new ProductoDAO(); 
    
    int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorProducto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorProducto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;            
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){             
            String nom=request.getParameter("txtNombrePro");
            String des=request.getParameter("txtDescripcion");
            String med=request.getParameter("txtMedidas");
            int uni = Integer.parseInt(request.getParameter("txtUnidades"));
            float prc = Float.parseFloat(request.getParameter("txtPrecioCosto"));
            float prv = Float.parseFloat(request.getParameter("txtPrecioVenta"));
            String ima=request.getParameter("txtImagenProd");
            int  cat = Integer.parseInt(request.getParameter("txtIdCat"));
            
                       
            pr.setNombrePro(nom);
            pr.setDescripcion(des);
            pr.setMedidas(med);
            pr.setUnidades(uni);
            pr.setPrecioCosto(prc);
            pr.setPrecioVenta(prv);
            pr.setImagenProd(ima);
            pr.setIdCat(cat);
            dao.add(pr);     
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idPro",request.getParameter("id")); 
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){ 
            id=Integer.parseInt(request.getParameter("txtid"));
            String nom=request.getParameter("txtNombrePro");
            String des=request.getParameter("txtDescripcion");
            String med=request.getParameter("txtMedidas");
            int uni = Integer.parseInt(request.getParameter("txtUnidades"));
            float prc = Float.parseFloat(request.getParameter("txtPrecioCosto"));
            float prv = Float.parseFloat(request.getParameter("txtPrecioVenta"));
            String ima=request.getParameter("txtImagenProd");
            int  cat = Integer.parseInt(request.getParameter("txtIdCat"));
            pr.setIdPro(id); 
            pr.setNombrePro(nom);
            pr.setDescripcion(des);
            pr.setMedidas(med);
            pr.setUnidades(uni);
            pr.setPrecioCosto(prc);
            pr.setPrecioVenta(prv);
            pr.setImagenProd(ima);
            pr.setIdCat(cat);
            dao.edit(pr); 
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            pr.setIdPro(id); 
            dao.eliminar(id);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}