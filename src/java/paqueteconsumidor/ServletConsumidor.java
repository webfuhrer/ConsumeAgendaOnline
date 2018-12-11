/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteconsumidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jdom2.Document;

/**
 *
 * @author Mañanas
 */
@WebServlet(name = "ServletConsumidor", urlPatterns = {"/ServletConsumidor"})
public class ServletConsumidor extends HttpServlet {

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
     String accion=request.getParameter("accion");
     HttpSession sesion=request.getSession();
     sesion.setAttribute(accion, request);
     if(accion.equals("listar"))
     {
         String xml_respuesta=Conexion.pedirXML("?accion=listar");
         Document xml=ParseaXML.convertirStringEnDocument(xml_respuesta);
         ArrayList<Contacto> lista_contactos=ParseaXML.parsearXML(xml);
         request.setAttribute("lista", lista_contactos);
         request.getRequestDispatcher("mostrardatos.jsp").forward(request, response);
     }else if(accion.equals("insertar"))
     {
         String nombre=request.getParameter("nombre");
         String email=request.getParameter("email");
         String xml_respuesta=Conexion.pedirXML("?accion=insertar&nombre="+nombre+"&email="+email);
         
         
     }else if (accion.equals("buscar"))
     {
          String nombre=request.getParameter("nombre");
          String xml_respuesta=Conexion.pedirXML("?accion=buscar&nombre="+nombre);
          Document xml=ParseaXML.convertirStringEnDocument(xml_respuesta);
          ArrayList<Contacto> lista_contactos=ParseaXML.parsearXML(xml);
          request.setAttribute("lista", lista_contactos);
         request.getRequestDispatcher("mostrardatos.jsp").forward(request, response);
          
     }
     else
     {
         request.getRequestDispatcher("index.html").forward(request, response);
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
