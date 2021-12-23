//37- Creamos paquete Controlador
//38- Creamos un servlet y  marcamos la casilla add... 

package Controlador;
// 39-Importamos:
import Modelo.Persona;// Clase que necesito
import ModeloDAO.PersonaDAO;// ClaseDAO que necesito
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;// no viene dentro del servlet
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControladorPer extends HttpServlet {
//40- Modificar .../ NombreClase/...Pertenenece a la carpeta Vista Nombre clase
    String listar="vistas/Persona/listar.jsp";
    String add="vistas/Persona/add.jsp";
    String edit="vistas/Persona/edit.jsp";
    Persona p=new Persona();//41- Modificar la declaración del objeto 
    PersonaDAO dao=new PersonaDAO(); //42- Modificar la declaración del objeto
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
            String dni=request.getParameter("txtDni"); //43- Modificar atributos en los dos eventos de la linea 
            String nom=request.getParameter("txtNom");//Igual para todos los atributos
            String ape=request.getParameter("txtApe");
            String dir=request.getParameter("txtDir");
            String tel=request.getParameter("txtTel");
            String cor=request.getParameter("txtCor");
            p.setDni(dni); // 44- Modificar Objeto.setAtributo(Atr)
            p.setNom(nom); // Igual´para todos los campos
            p.setApe(ape);
            p.setDir(dir);
            p.setTel(tel);
            p.setCor(cor);
            dao.add(p);     //45- Cambiar el objeto
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id")); // 46-Modificar 1er IdAtri viene de la vista
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){ 
            id=Integer.parseInt(request.getParameter("txtid"));//No se modifica
            String dni=request.getParameter("txtDni"); //47- Modificar en los dos casos de la linea 
            String nom=request.getParameter("txtNom");// Igual para todos los campos
            String ape=request.getParameter("txtApe");
            String dir=request.getParameter("txtDir");
            String tel=request.getParameter("txtTel");
            String cor=request.getParameter("txtCor");
            p.setId(id);  // 48- Modificar Objeto.setAtributo(Atr)
            p.setDni(dni);// Igual para todos
            p.setNom(nom);
            p.setApe(ape);
            p.setDir(dir);
            p.setTel(tel);
            p.setCor(cor);
            dao.edit(p);  //49- Cambiar el objeto
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));// no se modifica
            p.setId(id); //50-Modificar
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