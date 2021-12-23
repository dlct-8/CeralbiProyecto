
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.UsuarioNT;
import ModeloDAO.UsuarioNTDAO;
/**
 *
 * @author ZAYRA
 */
public class ControladorUsuarioNT extends HttpServlet {

  UsuarioNTDAO dao = new UsuarioNTDAO(); // se instancia la clase UsuarioNTDAO
UsuarioNT p= new UsuarioNT(); // se instancia la clase persona
int r;
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
        String accion=request.getParameter("accion");
        if(accion.equals("Ingresar")){
            String Usuario=request.getParameter("txtUsuario");
            String Clave=request.getParameter("txtClave");
            p.setUsuario(Usuario);
            p.setClave(Clave);  //se envia a la capa modelo
            r=dao.validar(p); // se ejecuta el metodo validar
            if (r==1){
                request.getSession().setAttribute("Usuario", Usuario);
            request.getSession().setAttribute("Clave", Clave);
                request.getRequestDispatcher("AdminPanel.jsp").forward(request, response);// si los datos son correctos r es 1 va a principal
            }else{
                 request.getRequestDispatcher("login.jsp").forward(request, response);// si los datos son incorrectos r es diferente de 1 y entonces va a index 
            }
        }else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
