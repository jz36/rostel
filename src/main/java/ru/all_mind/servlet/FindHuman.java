package ru.all_mind.servlet;

import com.google.gson.JsonArray;
import ru.all_mind.servlet.db.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/FindHuman")
public class FindHuman extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBWorker dbWorker = new DBWorker();
        response.setCharacterEncoding("utf8");
        JsonArray result = null;
        PrintWriter out = response.getWriter();
        result = dbWorker.getData(request, dbWorker.getDbConnection());
        dbWorker.closeConnection();
        if (result.equals("[]")){
            out.print("К сожалению, никто не найден");
        }
        else {
            out.print(result);
        }
    }
}
