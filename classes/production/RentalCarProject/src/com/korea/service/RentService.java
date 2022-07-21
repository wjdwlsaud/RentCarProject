package com.korea.service;

import com.korea.domain.RentDAO;
import com.korea.dto.RentDTO;
import com.korea.view.SuperViewer;

import java.sql.ResultSet;

public class RentService
{
    RentDAO dao = new RentDAO();
    ResultSet rs;

    public boolean CarSearch(RentDTO dto, SuperViewer view)
    {
        try
        {
            rs = dao.CarSearch(dto);
            System.out.println("-------------------------------------------------");
            System.out.println("대여가능 차량 목록");
            System.out.println("-------------------------------------------------");
            System.out.println("차량번호\t차종\t인승\t색상\t가격");
            System.out.println("-------------------------------------------------");
            while(rs.next())
            {
                System.out.println(rs.getString("Car_Code") + "\t" + rs.getString("Car_Name") + "\t" + rs.getString("Car_Person") + "\t\t" + rs.getString("Car_Color") + "\t" + rs.getString("Car_Price") + "\t");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }

    public boolean Select(RentDTO dto, SuperViewer view)
    {
        try
        {
            rs = dao.Select();
            System.out.println("-------------------------------------------------");
            System.out.println("렌트번호\tID\t차량번호\t렌트 시작일\t렌트 종료일\t렌트기간\t렌트비용");
            System.out.println("-------------------------------------------------");
            while(rs.next())
            {
                System.out.println(rs.getString("Rent_code") + "\t" + rs.getString("Member_ID") + "\t" + rs.getString("Car_Code") + "\t" + rs.getDate("Start_date") + "\t\t" + rs.getDate("End_date") + "\t" + rs.getString("period") + "\t" + rs.getString("price"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }

    public boolean SelectSearch(RentDTO dto, SuperViewer view)
    {
        try
        {
            rs = dao.SelectSearch(dto);
            System.out.println("-------------------------------------------------");
            System.out.println("렌트번호\tID\t차량번호\t렌트 시작일\t렌트 종료일\t렌트기간\t렌트비용");
            System.out.println("-------------------------------------------------");
            while(rs.next())
            {
                System.out.println(rs.getInt("Rent_Code") + "\t" + rs.getString("Member_ID") + "\t" + rs.getString("Car_Code") + "\t" + rs.getDate("Start_date") + "\t\t" + rs.getDate("End_date") + "\t" + rs.getString("period") + "\t" + rs.getString("price"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }

    public boolean Insert(RentDTO dto)
    {
        return dao.Insert(dto);
    }
    public boolean Update(RentDTO dto)
    {
        return dao.Update(dto);
    }
    public boolean Delete(RentDTO dto)
    {
        return dao.Delete(dto);
    }
}

