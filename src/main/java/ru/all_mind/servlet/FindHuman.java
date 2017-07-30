package ru.all_mind.servlet;

import ru.all_mind.servlet.db.DBWorker;
import ru.all_mind.servlet.db.ParamsFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


@WebServlet("/FindHuman")
public class FindHuman extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBWorker dbWorker = DBWorker.getInstance();
        response.setCharacterEncoding("utf8");
        ArrayList<String>  result = null;
        ParamsFactory paramsFactory = new ParamsFactory();
        PrintWriter out = response.getWriter();
        result = dbWorker.getData(paramsFactory.getSQLquery(request));
        if (result.isEmpty()){
            out.print("К сожалению, никто не найден");
        }
        else {
            for (String current : result) {
                out.print(current);
            }
        }
    }
}
