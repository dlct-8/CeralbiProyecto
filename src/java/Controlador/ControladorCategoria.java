package Controlador;

import Modelo.Categoria;
import ModeloDAO.CategoriaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorCategoria extends HttpServlet {

    String listar="vistas/Categoria/listarCategoria.jsp";
    String add="vistas/Categoria/addCategoria.jsp";
    String edit="vistas/Categoria/editCategoria.jsp";
    Categoria objc =new Categoria();
    CategoriaDAO dao =new CategoriaDAO();
    int variableid;
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
            String nom=request.getParameter("txtNombreCat");
            String des=request.getParameter("txtDescripcion");            
            objc.setNombreCat(nom);
            objc.setDescripcion(des);                       
            dao.add(objc);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idCat",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            variableid=Integer.parseInt(request.getParameter("txtid"));
            String nom=request.getParameter("txtNombreCat");
            String des=request.getParameter("txtDescripcion");  
            objc.setIdCat(variableid);
            objc.setNombreCat(nom);
            objc.setDescripcion(des);           
            dao.edit(objc);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            variableid=Integer.parseInt(request.getParameter("id"));
            objc.setIdCat(variableid);
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