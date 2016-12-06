/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.SessionBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author student
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB private SessionBeanLocal localbean;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession sessie = request.getSession();
        String navigatie = request.getParameter("navigatieknop");
        
        
        //Alle navigatie die naar start gaat
       if ((navigatie == null) || navigatie.equals("naarStart")) {
            request.setAttribute("onkosten", localbean.getOnkosten());
            this.goToPage("start.jsp", request, response);
        }
          
        if (navigatie.equals("naarVerwijderenOnkost")) {    //onkost uit databank verwijderen, enkel onkost in aanmaak kan verwijderd worden
            request.setAttribute("onkosten", localbean.getOnkosten());
            this.goToPage("verwijderenonkost.jsp", request, response);
        }
       
        if (navigatie.equals("naarInloggen")) {
            sessie.invalidate();
//            response.sendRedirect("/start.jsp");
            request.setAttribute("onkosten", localbean.getOnkosten());
            this.goToPage("start.jsp", request, response);
            // kan opgelost worden met een redirect
//            this.goToPage("inloggen.jsp", request, response);
        }
       
        
        ///Alle navigatie naar Aanpassen onkost        
        if (navigatie.equals("naarAanpassenOnkost")) {
            request.setAttribute("status", "inMaak");
            this.goToPage("aanpassenonkost.jsp", request, response);
        }
        
        if (navigatie.equals("naarNieuweOnkost")){
            request.setAttribute("status", "nieuweOnkost");
            this.goToPage("aanpassenonkost.jsp", request, response);
        }
        
        
        ///Alle pagina's naar Details onkost
        if (navigatie.equals("naarDetailsOnkost")){
            this.goToPage("detailsonkost.jsp", request, response);
        }
        
        
        ///Alle navigatie naar KiesKrediet
        if (navigatie.equals("naarKiesKrediet")){
            request.setAttribute("kredieten", localbean.getKredieten());
            this.goToPage("kieskrediet.jsp", request, response);
        }
        
        ///Alle navigatie naar OverzichtAlleKredieten
        if (navigatie.equals("naarOverzichtAlleKredieten")){
            this.goToPage("overzichtallekredieten.jsp", request, response);
        }
        
        else{
            this.goToPage("start.jsp", request, response);

        }        
    }
    
    private void goToPage(String pagina, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher(pagina);
        view.forward(req, res);
    }

    private int test(){
        return 5;
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
