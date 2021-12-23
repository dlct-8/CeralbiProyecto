
package Controlador;

import Modelo.Vendedor;
import ModeloDAO.VendedorDAO;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorVendedor extends HttpServlet {
String listar="vistas/Vendedor/listaVendedor.jsp";
    String add="vistas/Vendedor/addVendedor.jsp";
    String edit="vistas/Vendedor/editVendedor.jsp";
    Vendedor v=new Vendedor();//41- Modificar la declaración del objeto 
    VendedorDAO dao=new VendedorDAO(); //42- Modificar la declaración del objeto
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
            int usu = Integer.parseInt(request.getParameter("txtIdUsu"));            
            String nom=request.getParameter("txtNombresVen");
            String ape=request.getParameter("txtApellidosVen");
            String tip=request.getParameter("txtTipoDoc");
            String ndo=request.getParameter("txtNumerodoc");
            String tel=request.getParameter("txtTelefono");
            String cor=request.getParameter("txtCorreo");
            
            v.setIdUsu(usu); 
            v.setNombresVen(nom); 
            v.setApellidosVen(ape);
            v.setTipoDoc(tip);
            v.setNumerodoc(ndo);
            v.setTelefono(tel);
            v.setCorreo(cor);
            
            
            dao.add(v);     
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idVen",request.getParameter("id")); // 46-Modificar 1er IdAtri viene de la vista
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){ 
            id=Integer.parseInt(request.getParameter("txtid"));
            int usu = Integer.parseInt(request.getParameter("txtIdUsu"));             
            String nom=request.getParameter("txtNombresVen");
            String ape=request.getParameter("txtApellidosVen");
            String tip=request.getParameter("txtTipoDoc");
            String ndo=request.getParameter("txtNumerodoc");
            String tel=request.getParameter("txtTelefono");
             String cor=request.getParameter("txtCorreo");
            
            v.setIdVen(id);  // 48- Modificar Objeto.setAtributo(Atr)
            v.setIdUsu(usu);// Igual para todos
            v.setNombresVen(nom);
            v.setApellidosVen(ape);
            v.setTipoDoc(tip);
            v.getNumerodoc();
            v.setTelefono(tel);
            v.setCorreo(cor);
           
            
            dao.edit(v);  //49- Cambiar el objeto
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            v.setIdVen(id); 
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