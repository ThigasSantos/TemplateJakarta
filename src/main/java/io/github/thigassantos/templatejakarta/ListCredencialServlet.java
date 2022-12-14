/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package io.github.thigassantos.templatejakarta;

import io.github.thigassantos.templatejakarta.credencial.CredencialBeanLocal;
import io.github.thigassantos.templatejakarta.credencial.Credencial;
import io.github.thigassantos.templatejakarta.credencial.Credencial;
import io.github.thigassantos.templatejakarta.credencial.CredencialBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tygsv
 */
@WebServlet(name = "ListCredencialServlet", urlPatterns = {"/ListCredencialServlet"})
public class ListCredencialServlet extends HttpServlet {

     @Inject
    CredencialBeanLocal credencialBean;
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListCredencialServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"divBusca\">");
            out.println("<form method=\"get\" action=\"/TemplateJakarta-1.0-SNAPSHOT/EditCredencial\">");
            out.println("<input type=\"text\" id=\"txtBusca\" placeholder=\"Buscar...\" name=\"idBusca\"/>");
            out.println("<button id=\"btnBuscar\" type=\"submit\">Buscar</button> \n"+"  </form> ");
            out.println("</div>");
            out.println("<div id=\"lista\">");
            List<Credencial> lista = credencialBean.buscarTodos();
            lista.forEach(cr->{out.println("<p>"+cr.getId()+" - "+cr.getName()+"</p>");});
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
