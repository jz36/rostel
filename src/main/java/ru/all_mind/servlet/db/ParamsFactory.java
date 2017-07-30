package ru.all_mind.servlet.db;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

public class ParamsFactory {
    public String getSQLquery(HttpServletRequest request){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT DISTINCT human.name, human.second_name FROM human LEFT JOIN cars on cars.id_human=human.id WHERE ");
        boolean first = false;
        List<String> paramName = Collections.list(request.getParameterNames());
        for(String name : paramName){
            if(!request.getParameter(name).equals("")){
                if(first){
                    sql.append(" AND ");
                }
                sql.append(name + "='" + request.getParameter(name) + "'");
                if(!first) first = true;
            }
        }
       return sql.toString();
    }
}
