
package Controlador;

import Modelo.Factura;
import ModeloDAO.FacturaDAO;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorFactura extends HttpServlet {

    String listar="vistas/Factura/listarFactura.jsp";
    String add="vistas/Factura/addFactura.jsp";
    String edit="vistas/Factura/editFactura.jsp";
    Factura f =new Factura();
    FacturaDAO dao=new FacturaDAO(); 
    int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorFactura</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorFactura at " + request.getContextPath() + "</h1>");
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
            
            String emi=request.getParameter("txtEmision");
            String venc=request.getParameter("txtVencimiento");
            int idcli = Integer.parseInt(request.getParameter("txtIdCli"));
            int idven = Integer.parseInt(request.getParameter("txtIdVen"));
            int idped = Integer.parseInt(request.getParameter("txtIdPed")); 
            double imp = Double.parseDouble(request.getParameter("txtImpuestos"));
            
            f.setEmision(emi);
            f.setVencimiento(venc);
            f.setIdCli(idcli); // 44- Modificar Objeto.setAtributo(Atr)
            f.setIdVen(idven); // Igual´para todos los campos
            f.setIdPed(idped);
            f.setImpuestos(imp);
            
            dao.add(f);     //45- Cambiar el objeto
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idfac",request.getParameter("id")); // 46-Modificar 1er IdAtri viene de la vista
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){ 
            id=Integer.parseInt(request.getParameter("txtid"));//No se modifica
            String emi=request.getParameter("txtEmision");
            String venc=request.getParameter("txtVencimiento");
            int idcli = Integer.parseInt(request.getParameter("txtIdCli"));
            int idven = Integer.parseInt(request.getParameter("txtIdVen"));
            int idped = Integer.parseInt(request.getParameter("txtIdPed")); 
            double imp = Double.parseDouble(request.getParameter("txtImpuestos"));
            
            f.setIdfac(id);  
            f.setEmision(emi);
            f.setVencimiento(venc);
            f.setIdCli(idcli); 
            f.setIdVen(idven); 
            f.setIdPed(idped);
            f.setImpuestos(imp);
            
            dao.edit(f);  
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));// no se modifica
            f.setIdfac(id); //50-Modificar
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