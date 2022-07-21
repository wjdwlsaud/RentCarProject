package com.korea.domain;

import com.korea.dto.RentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RentDAO extends DAO
{
    public RentDAO()
    {
    }

    public ResultSet CarSearch(RentDTO dto)
    {
        try
        {
            pstmt = conn.prepareStatement("select * from car_tbl where car_code not in (select car_code from rent_tbl where (start_date <= ? and end_date >= ?) or (start_date between ? and ?) or (end_date between ? and ?))");
            pstmt.setDate(1, dto.getStart_Date());
            pstmt.setDate(2, dto.getEnd_Date());
            pstmt.setDate(3, dto.getStart_Date());
            pstmt.setDate(4, dto.getEnd_Date());
            pstmt.setDate(5, dto.getStart_Date());
            pstmt.setDate(6, dto.getEnd_Date());
            rs = pstmt.executeQuery();
            return rs;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet Select()
    {
        try
        {
            pstmt = conn.prepareStatement("select * from rent_tbl");
            rs = pstmt.executeQuery();
            return rs;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet SelectSearch(RentDTO dto)
    {
        try
        {
            pstmt = conn.prepareStatement("select * from rent_tbl where Member_ID = ?");
            pstmt.setString(1, dto.getMember_id());
            rs = pstmt.executeQuery();
            return rs;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public boolean Insert(RentDTO dto)
    {
        try
        {
            pstmt = conn.prepareStatement("insert into rent_tbl(Member_ID,Car_Code,Start_date,end_date,period,price) values(?,?,?,?,?,?)");
            pstmt.setString(1, dto.getMember_id());
            pstmt.setString(2, dto.getCar_code());
            pstmt.setDate(3, dto.getStart_Date());
            pstmt.setDate(4, dto.getEnd_Date());
            pstmt.setInt(5,dto.getPeriod());
            pstmt.setInt(6,dto.getPrice());

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
                pstmt.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean Update(RentDTO dto)
    {
        try
        {
            pstmt = conn.prepareStatement("UPDATE rent_tbl SET Member_ID = ?, Car_Code = ?, Start_date = ?, end_date = ?, period = ?, price = ? WHERE Rent_Code = ?");
            pstmt.setInt(7, dto.getRent_code());
            pstmt.setString(1, dto.getMember_id());
            pstmt.setString(2, dto.getCar_code());
            pstmt.setDate(3, dto.getStart_Date());
            pstmt.setDate(4, dto.getEnd_Date());
            pstmt.setInt(5, dto.getPeriod());
            pstmt.setInt(6, dto.getPrice());

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

    public boolean Delete(RentDTO dto)
    {
        try
        {
            pstmt = conn.prepareStatement("delete from rent_tbl where Rent_Code=?");
            pstmt.setInt(1, dto.getRent_code());

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
