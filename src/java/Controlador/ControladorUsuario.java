
package Controlador;

import Modelo.Usuario;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorUsuario extends HttpServlet {
    String listar="vistas/Usuario/listar.jsp";
    String add="vistas/Usuario/add.jsp";
    String edit="vistas/Usuario/edit.jsp";
    Usuario u =new Usuario();
    UsuarioDAO dao=new UsuarioDAO(); 
    int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
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
            String contraseUsu=request.getParameter("txtContraseUsu"); 
            String nombreUsu=request.getParameter("txtNombreUsu"); 
           
            u.setContraseUsu(contraseUsu); 
            u.setNombreUsu(nombreUsu); 
           
            dao.add(u);     
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idUsu",request.getParameter("id")); // 
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){ 
            id=Integer.parseInt(request.getParameter("txtid"));
            String contraseUsu=request.getParameter("txtContraseUsu"); 
            String nombreUsu=request.getParameter("txtNombreUsu");
          
            u.setIdUsu(id);  
            u.setContraseUsu(contraseUsu);
            u.setNombreUsu(nombreUsu);           
            dao.edit(u);  
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            u.setIdUsu(id);
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