
package Controlador;

import Modelo.RolUsu;
import ModeloDAO.RolUsuDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorRolUsu extends HttpServlet {

   String listar="vistas/RolUsu/listar.jsp";
    String add="vistas/RolUsu/add.jsp";
    String edit="vistas/RolUsu/edit.jsp";
    RolUsu rl = new RolUsu();
    RolUsuDAO dao =new RolUsuDAO();
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorRolUsu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorRolUsu at " + request.getContextPath() + "</h1>");
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
            String IdRol=request.getParameter("txtIdRol");  
            String IdUsu=request.getParameter("txtIdUsu");
            
            rl.setIdRol(id);
            rl.setIdUsu(id);
            dao.add(rl);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idRolUsu",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtIdRolUsu"));
            String idRolUsu=request.getParameter("txtIdRolUsu"); 
            String idUsu=request.getParameter("txtIdUsu");
            rl.setIdRol(id);
            rl.setIdUsu(id);
            dao.edit(rl);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            rl.setIdRolUsu(id);
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
