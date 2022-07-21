package com.korea.service;

import com.korea.domain.CarDAO;
import com.korea.dto.CarDTO;
import com.korea.view.SuperViewer;

import java.sql.ResultSet;

public class CarService
{
    CarDAO dao = new CarDAO();
    ResultSet rs;

    public boolean Select(CarDTO dto, SuperViewer view)
    {
        //        CarManagementGUI gui = (CarManagementGUI) view;

        try
        {
            rs = dao.Select();
            //            gui.SelectRecord(rs);
            System.out.println("--------------------------------------------------");
            System.out.println("차량번호\t차종\t인승\t색상\t가격");
            System.out.println("--------------------------------------------------");
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

    public boolean SelectSearch(CarDTO dto, SuperViewer view)
    {
        //        CarManagementGUI gui = (CarManagementGUI) view;

        try
        {
            rs = dao.SelectSearch(dto);
            //            gui.SelectRecord(rs);
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

    public ResultSet RentCheck(CarDTO dto)
    {
        rs = dao.RentCheck(dto);
        return rs;
    }

    public boolean Insert(CarDTO dto)
    {
        return dao.Insert(dto);
    }

    public boolean Update(CarDTO dto)
    {
        return dao.Update(dto);
    }

    public boolean Delete(CarDTO dto)
    {
        return dao.Delete(dto);
    }
}
