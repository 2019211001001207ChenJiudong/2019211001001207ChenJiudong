package com.ChenJiudong.controller;

import com.ChenJiudong.dao.OrderDao;
import com.ChenJiudong.model.Item;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "OrderDetailsServlet", value = "/OrderDetailsServlet")
public class OrderDetailsServlet extends HttpServlet {
    Connection con =null;
    public void init()throws ServletException{
        con=(Connection) getServletContext().getAttribute("con");
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int orderId=request.getParameter("orderId")!=null?
                Integer.parseInt(request.getParameter("orderId")):0;
        Item item=new Item();
        OrderDao dao=new OrderDao();
        List<Item> items=dao.findItemsByOrderId(con,orderId);
        request.setAttribute("itemList",items);
        String path="orderDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}