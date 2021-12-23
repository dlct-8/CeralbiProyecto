
package Controlador;

import Modelo.Auditoria;
import ModeloDAO.AuditoriaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


public class ControladorAuditoria extends HttpServlet {

    String listar="vistas/Auditoria/listarAuditoria.jsp";
    String add="vistas/Auditoria/addAuditoria.jsp";
    String edit="vistas/Auditoria/editAuditoria.jsp";
    
    Auditoria obja =new Auditoria();
    AuditoriaDAO dao =new AuditoriaDAO();
    int variableid;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorAuditoria</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorAuditoria at " + request.getContextPath() + "</h1>");
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
            String variableid =request.getParameter("txtUsuario");
            String des=request.getParameter("txtDescripcion");
            String fec=request.getParameter("txtFecha");            
            obja.setUsuario(variableid);
            obja.setDescripcion(des);
            obja.setFecha(fec);
            dao.add(obja);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("usuario",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            
            String variableid = request.getParameter("txtUsuario");
            String des=request.getParameter("txtDescripcion");
            String fec=request.getParameter("txtFecha");            
            obja.setUsuario(variableid);
            obja.setDescripcion(des);
            obja.setFecha(fec);           
            dao.edit(obja);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            variableid=Integer.parseInt(request.getParameter("id"));
            obja.setUsuario(listar);
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
