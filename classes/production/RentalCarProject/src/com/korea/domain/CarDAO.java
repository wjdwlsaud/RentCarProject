package com.korea.domain;

import com.korea.dto.CarDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDAO extends DAO
{
    public CarDAO()
    {
    }
    public ResultSet Select()
    {
        try
        {
            pstmt = conn.prepareStatement("select * from car_tbl");
            rs = pstmt.executeQuery();
            return rs;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet SelectSearch(CarDTO dto)
    {
        try
        {
            pstmt = conn.prepareStatement("select * from car_tbl where INSTR(Car_Name, ?) > 0");
            pstmt.setString(1, dto.getCar_Name());
            rs = pstmt.executeQuery();
            return rs;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet RentCheck(CarDTO dto)
    {
        try
        {
            pstmt = conn.prepareStatement("select Car_Code,Car_Name,Car_Person,Car_Color,Car_price from car_tbl where Car_Code = ?");
            pstmt.setString(1, dto.getCar_Code());
            rs = pstmt.executeQuery();
            return rs;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public boolean Insert(CarDTO dto)
    {
        try
        {
            pstmt = conn.prepareStatement("insert into car_tbl values(?,?,?,?,?)");
            pstmt.setString(1, dto.getCar_Code());
            pstmt.setString(2, dto.getCar_Name());
            pstmt.setInt(3, dto.getCar_Person());
            pstmt.setString(4, dto.getCar_Color());
            pstmt.setInt(5,dto.getCar_Price());

            int result = pstmt.executeUpdate();

            if(result != 0)
            {
                return true;    // Insert 성공
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                rs.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            try
            {
                pstmt.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean Update(CarDTO dto)
    {
        try
        {
            pstmt = conn.prepareStatement("UPDATE car_tbl SET Car_Name = ?, Car_Person = ?, Car_Color = ?, Car_Price = ? WHERE Car_Code = ?");
            pstmt.setString(5, dto.getCar_Code());
            pstmt.setString(1, dto.getCar_Name());
            pstmt.setInt(2, dto.getCar_Person());
            pstmt.setString(3, dto.getCar_Color());
            pstmt.setInt(4, dto.getCar_Price());

            int result = pstmt.executeUpdate();

            if(result != 0)
            {
                return true;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                rs.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            try
            {
                pstmt.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean Delete(CarDTO dto)
    {
        try
        {
            pstmt = conn.prepareStatement("delete from car_tbl where Car_Code=?");
            pstmt.setString(1, dto.getCar_Code());

            int result = pstmt.executeUpdate();

            if(result != 0)
            {
                return true;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                rs.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            try
            {
                pstmt.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }


}
