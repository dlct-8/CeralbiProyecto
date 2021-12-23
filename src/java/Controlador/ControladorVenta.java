
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import Modelo.Venta;
import ModeloDAO.VentaDAO;


public class ControladorVenta extends HttpServlet {
    
    String listar="vistas/Venta/showVenta.jsp";
    String add="vistas/Venta/addVenta.jsp";
    String edit="vistas/Venta/editVenta.jsp";
    Venta objve=new Venta();
    VentaDAO dao=new VentaDAO();
    int id;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorVenta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorVenta at " + request.getContextPath() + "</h1>");
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
            /*Recuperar en variables campos de la vista add
            */
            int variableidPed = Integer.parseInt(request.getParameter("txtIdPed"));            
            String variablefechaReal = request.getParameter("txtFechaReal");
            String variablefechaEntreg = request.getParameter("txtFechaEntreg");
            int variableidmed = Integer.parseInt(request.getParameter("txtIdmed"));
            int variableidmet = Integer.parseInt(request.getParameter("txtIdmet"));
            String variabledirEnvio = request.getParameter("txtDirEnvio");
           
            
            
            /*setear en el objeto objba los valores de las variables definidas
            anteriormente*/
            objve.setIdPed(variableidPed);
            objve.setFechaReal(variablefechaReal);
            objve.setFechaEntreg(variablefechaEntreg);
            objve.setIdmed(variableidmed);
            objve.setIdmet(variableidmet);
            objve.setDirEnvio(variabledirEnvio);
           
            
            /*no olvidar invocar al dao y cargar acceso con listar*/
            dao.add(objve);
            acceso=listar;
           
        }
        else if(action.equalsIgnoreCase("editar")){
            // Ojo la variable llave se carga con el valor de la variable llaveid de la vista listar
            // Esta variable llave se debe invocar en la vista edit.jsp
            request.setAttribute("idVent",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
             /*Recuperar en variables campos de la vista edit
            */
            id = Integer.parseInt(request.getParameter("txtid"));
            int variableidPed = Integer.parseInt(request.getParameter("txtIdPed"));            
            String variablefechaReal = request.getParameter("txtFechaReal");
            String variablefechaEntreg = request.getParameter("txtFechaEntreg");
            int variableidmed = Integer.parseInt(request.getParameter("txtIdmed"));
            int variableidmet = Integer.parseInt(request.getParameter("txtIdmet"));
            String variabledirEnvio = request.getParameter("txtDirEnvio");
            
            /*setear en el objeto objba los valores de las variables definidas
            anteriormente*/
            objve.setIdVent(id);
            objve.setIdPed(variableidPed);
            objve.setFechaReal(variablefechaReal);
            objve.setFechaEntreg(variablefechaEntreg);
            objve.setIdmed(variableidmed);
            objve.setIdmet(variableidmet);
            objve.setDirEnvio(variabledirEnvio);
            
            /*no olvidar invocar al dao y cargar acceso con listar*/
            dao.edit(objve);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            objve.setIdVent(id);
            dao.delete(id);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
