/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package io.github.thigassantos.templatejakarta;

import io.github.thigassantos.templatejakarta.credencial.Credencial;
import io.github.thigassantos.templatejakarta.credencial.CredencialBeanLocal;
import io.github.thigassantos.templatejakarta.log.LogBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EditCredencial", urlPatterns = {"/EditCredencial"})
public class EditCredencial extends HttpServlet {

    @Inject
    CredencialBeanLocal credencialBean;

    @Inject
    LogBeanLocal logBean;

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
            out.println("<title>Servlet EditCredencial</title>");
            out.println("</head>");
            out.println("<body>");
            String id = request.getParameter("idBusca");
            long idBusca = Long.parseLong(id);
            Credencial cr = credencialBean.buscarId(idBusca);
            out.println("<form method=\"post\"> \n"
                    + "  <label>ID</label> " + cr.getId() + " \n"
                    + "  <label>Nome</label> <input type=\"text\" name=\"nome\" value=\"" + cr.getName() + "\"/> \n"
                    + "  <label>Email</label> <input type=\"text\" name=\"email\"value=\"" + cr.getEmail() + "\"/> \n"
                    + "  <label>Ativo</label> <input type=\"checkbox\" name=\"ativo\"" + (cr.getAtivo() ? "checked" : "") + "/> \n"
                    + "  <button name=\"metodo\" value=\"atualizar\" type=\"submit\">Editar</button>\n"
                    + "  <button name=\"metodo\" value=\"deletar\" type=\"submit\">Deletar</button>\n"
                    + "</form> ");
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

        String metodo = request.getParameter("metodo");
        String id = request.getParameter("idBusca");
        long idBusca = Long.parseLong(id);

        if (metodo.equals("atualizar")) {

            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String ativo = request.getParameter("ativo");

            Credencial cr = new Credencial();

            cr.setId(Long.parseLong(id));
            cr.setName(nome);
            cr.setEmail(email);
            cr.setAtivo(ativo != null);
            
            credencialBean.atualizar(cr);
        }else{
            credencialBean.removerId(idBusca);
        }
        response.sendRedirect("/TemplateJakarta-1.0-SNAPSHOT/ListCredencialServlet");
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
