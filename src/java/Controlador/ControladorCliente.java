
package Controlador;

import Modelo.Cliente;
import ModeloDAO.ClienteDAO;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorCliente extends HttpServlet {

   
    String listar="vistas/Cliente/listarCliente.jsp";
    String add="vistas/Cliente/addCliente.jsp";
    String edit="vistas/Cliente/editCliente.jsp";
    
    Cliente cl=new Cliente();
    
    ClienteDAO dao=new ClienteDAO(); 
    int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCliente at " + request.getContextPath() + "</h1>");
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
            String nom=request.getParameter("txtNombres"); 
            String ape=request.getParameter("txtApellidos");
            int tip=Integer.parseInt(request.getParameter("txtIdTipo"));
            String ndo=request.getParameter("txtNumerodoc");
            String tel=request.getParameter("txtTelefono");
            String cor=request.getParameter("txtCorreo");
            String dir=request.getParameter("txtDireccion");
           
            
            cl.setNombres(nom); 
            cl.setApellidos(ape); 
            cl.setIdTipo(tip);
            cl.setNumerodoc(ndo); 
            cl.setTelefono(tel);
            cl.setCorreo(cor);
            cl.setDireccion(dir);
           
            
            dao.add(cl);     
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("llave",request.getParameter("id")); // 46-Modificar 1er IdAtri viene de la vista
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){ 
            id=Integer.parseInt(request.getParameter("txtid"));//No se modifica
            String nom=request.getParameter("txtNombres"); 
            String ape=request.getParameter("txtApellidos");
            int tip=Integer.parseInt(request.getParameter("txtIdTipo"));
            String ndo=request.getParameter("txtNumerodoc");
            String tel=request.getParameter("txtTelefono");
            String cor=request.getParameter("txtCorreo");
            String dir=request.getParameter("txtDireccion");
            
            
            cl.setIdCli(id);  
            cl.setNombres(nom); 
            cl.setApellidos(ape); 
            cl.setIdTipo(tip);
            cl.setNumerodoc(ndo); 
            cl.setTelefono(tel);
            cl.setCorreo(cor);
            cl.setDireccion(dir);
            
            
            dao.edit(cl);  
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            cl.setIdCli(id); 
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