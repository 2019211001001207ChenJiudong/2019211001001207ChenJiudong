package com.ChenJiudong.week4.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name="ConfigDemoServlet",urlPatterns="/jdbc",initParams={
        @WebInitParam(name="name",value="chenjiudong"),
        @WebInitParam(name="student-id",value="2019211001001207")
})
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer=response.getWriter();
        writer.println("name:"+getServletConfig().getInitParameter("name"));
        writer.println("student-id:"+getServletConfig().getInitParameter("student-id"));
    }
}

