package com.korea.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO
{
    String id = "root";
    String pw = "1234";
    String url = "jdbc:mysql://localhost:3306/RENTCARDB";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    DAO()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Driver Loading Success!");
            conn = DriverManager.getConnection(url, id, pw);
//            System.out.println("DB Connected..");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
