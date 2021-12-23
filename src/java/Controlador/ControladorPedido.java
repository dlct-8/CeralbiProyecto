
package Controlador;

import Modelo.Pedido;
import ModeloDAO.PedidoDAO;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorPedido extends HttpServlet {
    
    String listar="vistas/Pedido/listarPedido.jsp";
    String add="vistas/Pedido/addPedido.jsp";
    String edit="vistas/Pedido/editPedido.jsp";
    
    Pedido pe=new Pedido();
    PedidoDAO dao = new PedidoDAO();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorPedido</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorPedido at " + request.getContextPath() + "</h1>");
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
            float variablesubt = Float.parseFloat(request.getParameter("txtSubtotal"));
            float variabledesc = Float.parseFloat(request.getParameter("txtDescuento"));
            float variabletotal = Float.parseFloat(request.getParameter("txtTotal"));
            
            
            /*setear en el objeto objba los valores de las variables definidas
            anteriormente*/
            pe.setSubtotal(variablesubt);
            pe.setDescuento(variabledesc);
            pe.setTotal(variabletotal);
            
            
            /*no olvidar invocar al dao y cargar acceso con listar*/
            dao.add(pe);
            acceso=listar;
           
        }
        else if(action.equalsIgnoreCase("editar")){
            // Ojo la variable llave se carga con el valor de la variable llaveid de la vista listar
            // Esta variable llave se debe invocar en la vista edit.jsp
            request.setAttribute("idPed",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
             /*Recuperar en variables campos de la vista edit
            */
            id = Integer.parseInt(request.getParameter("txtid"));            
            float subt = Float.parseFloat(request.getParameter("txtSubtotal"));
            float desc = Float.parseFloat(request.getParameter("txtDescuento"));
            float total = Float.parseFloat(request.getParameter("txtTotal"));
            
            /*setear en el objeto objba los valores de las variables definidas
            anteriormente*/
            pe.setIdPed(id);
            pe.setSubtotal(subt);
            pe.setDescuento(desc);
            pe.setTotal(total);
            
            /*no olvidar invocar al dao y cargar acceso con listar*/
            dao.edit(pe);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            pe.setIdPed(id);
            dao.eliminar(id);
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
