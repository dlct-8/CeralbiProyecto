
package Controlador;

import Modelo.Registro;
import ModeloDAO.RegistroDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


public class ControladorRegistro extends HttpServlet {

    String listar="vistas/Registro/listarRegistro.jsp";
    String add="vistas/Registro/addRegistro.jsp";
    String edit="vistas/Registro/editRegistro.jsp";
  
    Registro objr =new Registro();
    RegistroDAO dao =new RegistroDAO();
    int variableid;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorRegistro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorRegistro at " + request.getContextPath() + "</h1>");
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
            String usu=request.getParameter("txtUsuario");
            String con=request.getParameter("txtContrasena");
            
            objr.setNombres(nom);
            objr.setApellidos(ape); 
            objr.setUsuario(usu);
            objr.setContrasena(con);
            
            dao.add(objr);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idReg",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            variableid=Integer.parseInt(request.getParameter("txtid"));
            String nom=request.getParameter("txtNombres");
            String ape=request.getParameter("txtApellidos"); 
            String usu=request.getParameter("txtUsuario");
            String con=request.getParameter("txtContrasena");
            
            objr.setIdReg(variableid);
            objr.setNombres(nom);
            objr.setApellidos(ape); 
            objr.setUsuario(usu);
            objr.setContrasena(con);
            dao.edit(objr);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            variableid=Integer.parseInt(request.getParameter("id"));
            objr.setIdReg(variableid);
            dao.eliminar(variableid);
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
