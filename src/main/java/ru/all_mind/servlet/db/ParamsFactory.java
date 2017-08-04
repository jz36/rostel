package ru.all_mind.servlet.db;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ParamsFactory {
    private PreparedStatement sql_query = null;
    public ResultSet getSQLquery(HttpServletRequest request, Connection connection) throws SQLException {
            sql_query = connection.prepareStatement("SELECT DISTINCT human.name, human.second_name " +
                    "FROM human LEFT JOIN cars on cars.id_human=human.id LEFT JOIN city ON city.id=human.city WHERE " +
                    "name LIKE ? AND second_name LIKE ? AND third_name LIKE ? AND cityname LIKE ?" +
                    "AND  mark LIKE ? AND model LIKE ? AND gov_number LIKE ? AND gov_number2 LIKE ?");
        HashMap<String, String> params = new HashMap<String, String>();
        for(String name : Collections.list(request.getParameterNames())){
            params.put(name, request.getParameter(name));
            }
        sql_query.setString(1, "%" + params.get("name") + "%");
        sql_query.setString(2, "%" + params.get("second_name") + "%");
        sql_query.setString(3, "%" + params.get("third_name") + "%");
        sql_query.setString(4, "%" + params.get("cityname") + "%");
        sql_query.setString(5, "%" + params.get("mark") + "%");
        sql_query.setString(6, "%" + params.get("model") + "%");
        sql_query.setString(7, "%" + params.get("gov_number") + "%");
        sql_query.setString(8, "%" + params.get("gov_number2") + "%");
        return sql_query.executeQuery();
    }
}
