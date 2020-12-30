package com.sr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Step1Servlet extends HttpServlet
{

   private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
      doPost(req, resp);
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
      try
      {
         String fname = req.getParameter("fname");
         String lname = req.getParameter("lname");
         req.getSession().setAttribute("fname", fname);
         req.getSession().setAttribute("lname", lname);
         req.getSession().setAttribute("step1done", "yes");
         resp.sendRedirect("step2.jsp");
      }
      catch (Exception e)
      {
         e.printStackTrace();
         resp.sendRedirect("step1.jsp?msg=Error: " + e.getMessage());
      }
   }

}
